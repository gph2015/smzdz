package log;

import com.smzdz.enums.OperationLogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qibaichao on 2015/4/14.
 */
public class LogUtil {

    private static final String USER_KEY = "username";

    private static final Logger log = LoggerFactory.getLogger("dbLogger");

    public static void info(OperationLogType operationLogType, String msg) {

        log.info("删除一条数据",OperationLogType.DELETE.getValue(),"bb","cc","dd","ee");
//        String aa="旧字符串";
//        try {
//            String a = new String(aa.getBytes(),"UTF-8");
//            log.info(a);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

    }


    public static void main(String args[]) {
        MDC.put(USER_KEY, "齐百超");
//        LogUtil.info(OperationLogType.INSERT, "ddd");
        log.info("删除一条数据",OperationLogType.DELETE.getValue(),"userId","userName","host","params");
//        long aa = new java.util.Date().getTime();
//        SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//        System.out.println(aa);
//        java.util.Date dt = new Date(aa);
//        String sDateTime = sdf.format(dt);  //得到精确到秒的表示：08/31/2006 21:08:00
//        System.out.println(sDateTime);
    }

}
