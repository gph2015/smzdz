package com.smzdz.util.result;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/11 12:23
 */
public enum ResultStatus {
    SUCCESS(0, "成功"),

    // ------------------系统错误-----------------------
    SYSTEM_ERROR(1000, "系统错误"),
    SYSTEM_DB_ERROR(1001, "数据库系统错误"),
    APPID_NOTEXISTED(1500, "应用ID不存在"),
    SIGNATURE_ERROR(1510, "签名错误"),
    CAPTCHA_ERROR(1600, "验证码错误"),
    CAPTCHA_REQUIRED(1601, "验证码必需"),
    PARAM_ERROR(1602, "参数异常"),
    // ------------------依赖平台错误-------------------
    PASSPORT_SERVICE_ERROR(8000, "Passport服务错误"),
    PASSPORT_SERVICE_TIMEOUT(8001, "Passport服务超时"),

    // ------------------业务逻辑异常-------------------

    ADD_USER_ERROR(2000, "添加用户信息数据库操作异常"),
    ADD_USER_APPID_ERROR(2002, "添加用户信息失败，业务线id不合法"),
    ADD_EXISTSUSER_ERROR(2003, "已经存在相同邮箱的用户"),
    ADD_AGENCY_ERROR(3000, "支付机构编码+类型+接入平台重复"),
    ADD_FEE_ERROR(3001, "支付类型+商户号编码重复"),
    UPLOADFILE_ERROR(5000, "上传图片异常"),
    ADD_CHANNEL_ERROR(3002, "添加渠道失败，已经存在渠道信息"),
    ADD_CHANNEL_LOW_ERROR(3003, "添加渠道失败,最低限额输入有误"),
    ADD_CHANNEL_HIGH_ERROR(3004, "添加渠道失败,最高限额输入有误"),
    ADD_ADAPT_ERROR(4000, "产品名称+接入平台+渠道编码+渠道类型+银行卡类型重复"),
    ADD_ROUTER_ERROR(5000, "银行+接入平台+银行卡类型重复"),
    ADD_APP_PARAM_ERROR(6000, "产品ID参数错误，请重新添加产品"),
    ADD_APP_ERROR(6001, "产品名称或者产品ID重复，请重新添加产品"),
    ADD_BANKALIAS_ERROR(7000, "支付机构编码+银行卡类型+银行简称重复");

    private int code;
    private String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 状态信息
     */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 状态代码字符串
     */
    public String getName() {
        return this.name();
    }

    /**
     * 向外部输出的状态代码字符串
     */
    public String getOutputName() {
        return this.name();
    }

    @Override
    public String toString() {
        return getName();
    }
}
