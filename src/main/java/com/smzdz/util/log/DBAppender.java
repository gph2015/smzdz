
package com.smzdz.util.log;

import ch.qos.logback.classic.db.DBHelper;
import ch.qos.logback.classic.db.names.DBNameResolver;
import ch.qos.logback.classic.db.names.DefaultDBNameResolver;
import ch.qos.logback.classic.spi.*;
import ch.qos.logback.core.db.DBAppenderBase;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by qibaichao on 2015/04/15.
 */
public class DBAppender extends DBAppenderBase<ILoggingEvent> {
    protected String insertPropertiesSQL;
    protected String insertExceptionSQL;
    protected String insertSQL;
    protected static final Method GET_GENERATED_KEYS_METHOD;
    private DBNameResolver dbNameResolver;
    static final int TIMESTMP_INDEX = 1;
    static final int FORMATTED_MESSAGE_INDEX = 2;
    static final int LOGGER_NAME_INDEX = 3;
    static final int LEVEL_STRING_INDEX = 4;
    static final int THREAD_NAME_INDEX = 5;
    static final int REFERENCE_FLAG_INDEX = 6;
    static final int OPER_TYPE = 7;
    static final int USER_ID = 8;
    static final int USER_NAME = 9;
    static final int HOST = 10;
    static final int PARAMS = 11;
    static final int CALLER_FILENAME_INDEX = 12;
    static final int CALLER_CLASS_INDEX = 13;
    static final int CALLER_METHOD_INDEX = 14;
    static final int CALLER_LINE_INDEX = 15;
    static final int EVENT_ID_INDEX = 16;
    static final StackTraceElement EMPTY_CALLER_DATA = CallerData.naInstance();

    public DBAppender() {
    }

    public void setDbNameResolver(DBNameResolver dbNameResolver) {
        this.dbNameResolver = dbNameResolver;
    }

    public void start() {
        if (this.dbNameResolver == null) {
            this.dbNameResolver = new DefaultDBNameResolver();
        }

        this.insertExceptionSQL = SQLBuilder.buildInsertExceptionSQL(this.dbNameResolver);
        this.insertPropertiesSQL = SQLBuilder.buildInsertPropertiesSQL(this.dbNameResolver);
        this.insertSQL = SQLBuilder.buildInsertSQL(this.dbNameResolver);
        try {
            super.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    protected void subAppend(ILoggingEvent event, Connection connection, PreparedStatement insertStatement) throws Throwable {
        this.bindLoggingEventWithInsertStatement(insertStatement, event);
        this.bindLoggingEventArgumentsWithPreparedStatement(insertStatement, event.getArgumentArray());
        this.bindCallerDataWithPreparedStatement(insertStatement, event.getCallerData());
        try {
            int updateCount = insertStatement.executeUpdate();
            if (updateCount != 1) {
                this.addWarn("Failed to insert loggingEvent");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    protected void secondarySubAppend(ILoggingEvent event, Connection connection, long eventId) throws Throwable {
        Map mergedMap = this.mergePropertyMaps(event);
        this.insertProperties(mergedMap, connection, eventId);
        if (event.getThrowableProxy() != null) {
            this.insertThrowable(event.getThrowableProxy(), connection, eventId);
        }

    }

    void bindLoggingEventWithInsertStatement(PreparedStatement stmt, ILoggingEvent event) throws SQLException {

        stmt.setTimestamp(1, new java.sql.Timestamp(event.getTimeStamp()));
        stmt.setString(2, event.getFormattedMessage());
        stmt.setString(3, event.getLoggerName());
        stmt.setString(4, event.getLevel().toString());
        stmt.setString(5, event.getThreadName());
        stmt.setShort(6, DBHelper.computeReferenceMask(event));
    }

    void bindLoggingEventArgumentsWithPreparedStatement(PreparedStatement stmt, Object[] argArray) throws SQLException {
        int arrayLen = argArray != null ? argArray.length : 0;

        int i;
        for (i = 0; i < arrayLen && i < 5; ++i) {
            stmt.setObject(7 + i, this.asStringTruncatedTo254(argArray[i]));
        }

        if (arrayLen < 4) {
            for (i = arrayLen; i < 5; ++i) {
                stmt.setObject(7 + i, (String) null);
            }
        }

    }

    String asStringTruncatedTo254(Object o) {
        String s = null;
        if (o != null) {
            s = o.toString();
        }

        return s == null ? null : (s.length() <= 254 ? s : s.substring(0, 254));
    }

    void bindCallerDataWithPreparedStatement(PreparedStatement stmt, StackTraceElement[] callerDataArray) throws SQLException {
        StackTraceElement caller = this.extractFirstCaller(callerDataArray);
        stmt.setString(12, caller.getFileName());
        stmt.setString(13, caller.getClassName());
        stmt.setString(14, caller.getMethodName());
        stmt.setString(15, Integer.toString(caller.getLineNumber()));
    }

    private StackTraceElement extractFirstCaller(StackTraceElement[] callerDataArray) {
        StackTraceElement caller = EMPTY_CALLER_DATA;
        if (this.hasAtLeastOneNonNullElement(callerDataArray)) {
            caller = callerDataArray[0];
        }

        return caller;
    }

    private boolean hasAtLeastOneNonNullElement(StackTraceElement[] callerDataArray) {
        return callerDataArray != null && callerDataArray.length > 0 && callerDataArray[0] != null;
    }

    Map<String, String> mergePropertyMaps(ILoggingEvent event) {
        HashMap mergedMap = new HashMap();
        Map loggerContextMap = event.getLoggerContextVO().getPropertyMap();
        Map mdcMap = event.getMDCPropertyMap();
        if (loggerContextMap != null) {
            mergedMap.putAll(loggerContextMap);
        }

        if (mdcMap != null) {
            mergedMap.putAll(mdcMap);
        }

        return mergedMap;
    }

    protected Method getGeneratedKeysMethod() {
        return GET_GENERATED_KEYS_METHOD;
    }

    protected String getInsertSQL() {
        return this.insertSQL;
    }

    protected void insertProperties(Map<String, String> mergedMap, Connection connection, long eventId) throws SQLException {
        Set propertiesKeys = mergedMap.keySet();
        if (propertiesKeys.size() > 0) {
            PreparedStatement insertPropertiesStatement = null;

            try {
                insertPropertiesStatement = connection.prepareStatement(this.insertPropertiesSQL);
                Iterator i$ = propertiesKeys.iterator();

                while (i$.hasNext()) {
                    String key = (String) i$.next();
                    String value = (String) mergedMap.get(key);
                    insertPropertiesStatement.setLong(1, eventId);
                    insertPropertiesStatement.setString(2, key);
                    insertPropertiesStatement.setString(3, value);
                    if (this.cnxSupportsBatchUpdates) {
                        insertPropertiesStatement.addBatch();
                    } else {
                        insertPropertiesStatement.execute();
                    }
                }

                if (this.cnxSupportsBatchUpdates) {
                    insertPropertiesStatement.executeBatch();
                }
            } finally {
                ch.qos.logback.core.db.DBHelper.closeStatement(insertPropertiesStatement);
            }
        }

    }

    void updateExceptionStatement(PreparedStatement exceptionStatement, String txt, short i, long eventId) throws SQLException {
        exceptionStatement.setLong(1, eventId);
        exceptionStatement.setShort(2, i);
        exceptionStatement.setString(3, txt);
        if (this.cnxSupportsBatchUpdates) {
            exceptionStatement.addBatch();
        } else {
            exceptionStatement.execute();
        }

    }

    short buildExceptionStatement(IThrowableProxy tp, short baseIndex, PreparedStatement insertExceptionStatement, long eventId) throws SQLException {
        StringBuilder buf = new StringBuilder();
        ThrowableProxyUtil.subjoinFirstLine(buf, tp);
        this.updateExceptionStatement(insertExceptionStatement, buf.toString(), baseIndex++, eventId);
        int commonFrames = tp.getCommonFrames();
        StackTraceElementProxy[] stepArray = tp.getStackTraceElementProxyArray();

        for (int sb = 0; sb < stepArray.length - commonFrames; ++sb) {
            StringBuilder sb1 = new StringBuilder();
            sb1.append('\t');
            ThrowableProxyUtil.subjoinSTEP(sb1, stepArray[sb]);
            this.updateExceptionStatement(insertExceptionStatement, sb1.toString(), baseIndex++, eventId);
        }

        if (commonFrames > 0) {
            StringBuilder var11 = new StringBuilder();
            var11.append('\t').append("... ").append(commonFrames).append(" common frames omitted");
            this.updateExceptionStatement(insertExceptionStatement, var11.toString(), baseIndex++, eventId);
        }

        return baseIndex;
    }

    protected void insertThrowable(IThrowableProxy tp, Connection connection, long eventId) throws SQLException {
        PreparedStatement exceptionStatement = null;

        try {
            exceptionStatement = connection.prepareStatement(this.insertExceptionSQL);
            short baseIndex = 0;

            while (true) {
                if (tp == null) {
                    if (this.cnxSupportsBatchUpdates) {
                        exceptionStatement.executeBatch();
                    }
                    break;
                }

                baseIndex = this.buildExceptionStatement(tp, baseIndex, exceptionStatement, eventId);
                tp = tp.getCause();
            }
        } finally {
            ch.qos.logback.core.db.DBHelper.closeStatement(exceptionStatement);
        }

    }

    static {
        Method getGeneratedKeysMethod;
        try {
            getGeneratedKeysMethod = PreparedStatement.class.getMethod("getGeneratedKeys", (Class[]) null);
        } catch (Exception var2) {
            getGeneratedKeysMethod = null;
        }

        GET_GENERATED_KEYS_METHOD = getGeneratedKeysMethod;
    }
}
