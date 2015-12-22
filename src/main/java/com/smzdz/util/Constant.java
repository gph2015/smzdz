package com.smzdz.util;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Description: 常量类
 */
public class Constant {

    /**
     * 接入平台
     */
    public static final HashMap<Integer, String> ACCESSPLAT_MAP = new HashMap<Integer, String>() {
        private static final long serialVersionUID = 1L;

        {
            put(1, "PC");
            put(2, "WAP");
            put(3, "SDK");
            put(99, "不区分");
        }
    };

    /**
     * 支付机构是否有银行别名
     */
    @SuppressWarnings("serial")
    public static final HashMap<Integer, String> ALIAS_MAP = new HashMap<Integer, String>() {
        {
            put(0, "无");
            put(3, "有");
        }
    };

    /**
     * 付款类型
     */
    public static final HashMap<Integer, String> PAY_FEETYPE_MAP = new HashMap<Integer, String>() {
        {
            put(1, "网银支付");
            put(2, "第三方支付");
            put(3, "扫码支付");
            put(99, "不区分");
        }
    };

    /**
     * 支付机构商户表--加密类型
     */
    public static final HashMap<Integer, String> ENCRYPTIONMAP = new HashMap<Integer, String>() {
        {
            put(1, "签名");
            put(2, "非对称加密");
            put(3, "对称加密");
        }
    };

    /**
     * 支付机构商户表--支付机构商户启用与否
     */
    public static final HashMap<Integer, String> ISUSEDMAP = new HashMap<Integer, String>() {
        {
            put(1, "启用");
            put(2, "不启用");
        }
    };

    /**
     * 支付机构商户表--公司名称
     */
    public static final HashMap<Integer, String> COMPANYMAP = new HashMap<Integer, String>() {
        {
            put(1, "搜狗网络");
            put(2, "搜狗科技");
        }
    };

    /**
     * 银行别名表--银行卡类型
     */
    public static final HashMap<Integer, String> BANKCARDMAP = new HashMap<Integer, String>() {
        {
            put(1, "储蓄卡");
            put(2, "信用卡");
            put(3, "不区分");
        }
    };

    /**
     * 渠道表表--渠道类型
     */
    public static final HashMap<Integer, String> CHANNELTYPEMAP = new HashMap<Integer, String>() {
        {
            put(1, "银行");
            put(2, "支付机构");
            put(3, "搜狗");
        }
    };

    /**
     * 渠道表表--渠道性质
     */
    public static final HashMap<Integer, String> CHANNELNATUREMAP = new HashMap<Integer, String>() {
        {
            put(1, "支付");
            put(2, "提现");
            put(3, "支付和提现");
        }
    };

    /**
     * 支付单--支付状态
     */
    public static final HashMap<Integer, String>
            PAYORDER_STATUS_MAP =
            new HashMap<Integer, String>() {
                {
                    put(1, "未支付");
                    put(2, "部份支付");
                    put(3, "支付完成");
                    put(4, "无效");
                    put(5, "已关闭");
                }
            };

    public static final HashMap<Integer, String>
            PAYORDER_REFUND_STATUS_MAP =
            new HashMap<Integer, String>() {
                {
                    put(1, "未退款");
                    put(2, "部份退款");
                    put(3, "退款完成");
                }
            };

    /**
     * 产品线--接入产品
     */
    public static final HashMap<Integer, String> APP_MAP = new HashMap<Integer, String>() {
        {
            put(1000, "搜狗支付中心");
            put(2012, "彩票");
            put(2015, "号码通");
            put(1100, "游戏");
            put(1024, "搜狗地图");
            put(1065, "浏览器");
            put(1099, "手机助手");
            put(2002, "壁纸");
            put(2003, "输入法");
        }
    };

    /**
     * 退款状态
     */
    public static final HashMap<Integer, String>
            REFUND_STATUS_MAP =
            new HashMap<Integer, String>() {
                {
                    put(1, "初始状态");
                    put(2, "退款成功");
                    put(3, "退款失败");
                }
            };

    /**
     * 用户表--用户启用与否
     */
    public static final HashMap<Integer, String> USERISUSEDMAP = new HashMap<Integer, String>() {
        {
            put(1, "启用");
            put(2, "失效");
        }
    };

    /**
     * 产品列表--启用与禁用
     */
    public static final HashMap<Integer, String> APPISUSEDMAP = new HashMap<Integer, String>() {
        {
            put(1, "启用");
            put(2, "禁用");
        }
    };
    /**
     * 对账类型
     */
    public static final HashMap<Integer, String> CHECK_TYPE_MAP = new HashMap<Integer, String>() {
        {
            put(1, "支付");
            put(3, "退款");
        }
    };
    /**
     * 对账状态
     */
    public static final HashMap<Integer, String> CHECK_STATUS_MAP = new HashMap<Integer, String>() {
        {
            put(1, "成功");
            put(2, "失败");
            put(3, "成功(已人工处理)");
        }
    };

    /**
     * 对账差异类型
     */
    public static final HashMap<Integer, String>
            CHECK_DIFF_TYPE_MAP =
            new HashMap<Integer, String>() {
                {
                    put(2, "金额不符");
                    put(3, "漏单");
                    put(4, "多单");
                }
            };

    /**
     * 支付机构编码对中文名
     */
    public static final HashMap<String, String> AGENCY_TYPE_MAP = new HashMap<String, String>() {
        {
            put("ALIPAY", "支付宝");
            put("TENPAY", "财付通");
            put("WECHAT", "微信");
//            put("BILL99", "微信");
        }
    };


    /**
     * 手续费管理--手续费类型
     */
    public static final HashMap<Integer, String> FEE_TYPE_MAP = new HashMap<Integer, String>() {
        {
            put(1, "按比例");
            put(2, "按定额");
        }
    };

    /**
     * 手续费管理--手续费状态
     */
    public static final HashMap<Integer, String> FEE_STAUTS_MAP = new HashMap<Integer, String>() {
        {
            put(0, "未启用");
            put(1, "已启用");
        }
    };
    /**
     * 业务类型
     */
    public static final HashMap<Integer, String> BIZ_TYPE_MAP = new HashMap<Integer, String>() {
        {
            put(1, "支付");
            put(2, "充值");
            put(3, "退款");
        }
    };

    /**
     * 报表统计维度
     */
    public static final HashMap<Integer, String> STATIS_DIMENSION_MAP = new HashMap<Integer, String>() {
        {
            put(1, "支付方式");
            put(2, "支付机构");
        }
    };
    /**
     * 报表统计指标
     */
    public static final LinkedHashMap<Integer, String> STATIS_INDEX_MAP = new LinkedHashMap<Integer, String>() {
        {
            put(1, "笔数");
            put(2, "金额");
        }
    };


    /**
     * 代付批次--代付状态
     */
    public static final HashMap<Integer, String>
            TRADE_STATUS_MAP =
            new HashMap<Integer, String>() {
                {
                    put(1, "初始化状态");
                    put(2, "审核通过");
                    put(3, "审核不通过");
                    put(4, "银行处理中");
                    put(5, "受理完成");
                    put(6, "付款失败");
                }
            };

    /**
     * 代付单--支付状态
     */
    public static final HashMap<Integer, String>
            PAY_STATUS_MAP =
            new HashMap<Integer, String>() {
                {

                    put(1, "未处理");
                    put(2, "处理中");
                    put(3, "成功");
                    put(4, "失败");
                    put(5, "退票");
                }
            };


    /**
     * 用户类型
     */
    public static final HashMap<Integer, String>
            USER_TYPE_MAP =
            new HashMap<Integer, String>() {
                {

                    put(1, "管理员");
                    put(2, "业务线交易查询员");
                    put(3, "代付审批员");
                    put(4, "交易与代付审批员");
                }
            };
    
    /**
     * 代付审核状态
     */
    //审核通过
    public static final Integer AUDIT_STATUS_2 = 2;
    //审核未通过
    public static final Integer AUDIT_STATUS_3 = 3;
}
