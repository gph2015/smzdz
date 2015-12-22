package com.smzdz.model;

import com.smzdz.entity.AgencyInfo;
import com.smzdz.util.Constant;
import com.smzdz.entity.AgencyInfo;
import com.smzdz.util.Constant;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/23 15:21
 */
public class AgencyInfoModel implements Serializable{

	private static final long serialVersionUID = 1L;

	public AgencyInfoModel(AgencyInfo info) {
		if (null != info) {
			this.setAccessPlatform(info.getAccessPlatform());
			this.setAgencyCode(info.getAgencyCode());
			this.setAgencyName(info.getAgencyName());
			this.setAgencyType(info.getAgencyType());
			this.setAliasFlag(info.getAliasFlag());
			this.setCreateTime(info.getCreateTime());
			this.setId(info.getId());
			this.setModifyTime(info.getModifyTime());
			this.setAccessPlatformSrt(Constant.ACCESSPLAT_MAP.get(info
					.getAccessPlatform()));
			this.setAliasStr(info.getAliasFlag() == 0 ? "无" : "有");
			this.setAgencyTypeStr(Constant.PAY_FEETYPE_MAP.get(info
					.getAgencyType()));
			this.setPayUrl(info.getPayUrl());
			this.setRefundUrl(info.getRefundUrl());
            this.setQueryRefundUrl(info.getQueryRefundUrl());
			this.setQueryUrl(info.getQueryUrl());
			this.setSendPhoneUrl(info.getSendPhoneUrl());
			this.setPrepayUrl(info.getPrepayUrl());
		}
	}

	private String accessPlatformSrt;
	private String agencyTypeStr;
	private String aliasStr;

	 public String getAccessPlatformSrt() {
		return accessPlatformSrt;
	}

	public void setAccessPlatformSrt(String accessPlatformSrt) {
		this.accessPlatformSrt = accessPlatformSrt;
	}

	public String getAgencyTypeStr() {
		return agencyTypeStr;
	}

	public void setAgencyTypeStr(String agencyTypeStr) {
		this.agencyTypeStr = agencyTypeStr;
	}

	public String getAliasStr() {
		return aliasStr;
	}

	public void setAliasStr(String aliasStr) {
		this.aliasStr = aliasStr;
	}

	private Integer id;
	    /**
	     * 支付机构编码
	     */
	    private String agencyCode;

	    /**
	     * 接入平台
	     */
	    private Integer accessPlatform;

	    /**
	     * 机构名称
	     */
	    private String agencyName;

	    /**
	     * 银行别名标示
	     */
	    private Integer aliasFlag;

	    /**
	     * 机构类型
	     */
	    private Integer agencyType;

	    /**
	     * 预支付URL
	     */
	    private String prepayUrl;

	    /**
	     * 支付URL
	     */
	    private String payUrl;

	    /**
	     * 查询URL
	     */
	    private String queryUrl;

	    /**
	     * 退款URL
	     */
	    private String refundUrl;

       /**
        * 退款查询URL
        */
        private String queryRefundUrl;

	    /**
	     * 发手机验证码URL
	     */
	    private String sendPhoneUrl;

	    /**
	     * 创建时间
	     */
	    private Date createTime;

	    /**
	     * 修改时间
	     */
	    private Date modifyTime;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getAgencyCode() {
			return agencyCode;
		}

		public void setAgencyCode(String agencyCode) {
			this.agencyCode = agencyCode;
		}

		public Integer getAccessPlatform() {
			return accessPlatform;
		}

		public void setAccessPlatform(Integer accessPlatform) {
			this.accessPlatform = accessPlatform;
		}

		public String getAgencyName() {
			return agencyName;
		}

		public void setAgencyName(String agencyName) {
			this.agencyName = agencyName;
		}

		public Integer getAliasFlag() {
			return aliasFlag;
		}

		public void setAliasFlag(Integer aliasFlag) {
			this.aliasFlag = aliasFlag;
		}

		public Integer getAgencyType() {
			return agencyType;
		}

		public void setAgencyType(Integer agencyType) {
			this.agencyType = agencyType;
		}

		public String getPrepayUrl() {
			return prepayUrl;
		}

		public void setPrepayUrl(String prepayUrl) {
			this.prepayUrl = prepayUrl;
		}

		public String getPayUrl() {
			return payUrl;
		}

		public void setPayUrl(String payUrl) {
			this.payUrl = payUrl;
		}

		public String getQueryUrl() {
			return queryUrl;
		}

		public void setQueryUrl(String queryUrl) {
			this.queryUrl = queryUrl;
		}

		public String getRefundUrl() {
			return refundUrl;
		}

		public void setRefundUrl(String refundUrl) {
			this.refundUrl = refundUrl;
		}

        public String getQueryRefundUrl() {
            return queryRefundUrl;
        }

        public void setQueryRefundUrl(String queryRefundUrl) {
            this.queryRefundUrl = queryRefundUrl;
        }

        public String getSendPhoneUrl() {
			return sendPhoneUrl;
		}

		public void setSendPhoneUrl(String sendPhoneUrl) {
			this.sendPhoneUrl = sendPhoneUrl;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public Date getModifyTime() {
			return modifyTime;
		}

		public void setModifyTime(Date modifyTime) {
			this.modifyTime = modifyTime;
		}

		@Override
		public String toString() {
			return "AgencyInfoModel [accessPlatformSrt=" + accessPlatformSrt
					+ ", agencyTypeStr=" + agencyTypeStr + ", aliasStr="
					+ aliasStr + ", id=" + id + ", agencyCode=" + agencyCode
					+ ", accessPlatform=" + accessPlatform + ", agencyName="
					+ agencyName + ", aliasFlag=" + aliasFlag + ", agencyType="
					+ agencyType + ", prepayUrl=" + prepayUrl + ", payUrl="
					+ payUrl + ", queryUrl=" + queryUrl + ", refundUrl="
					+ refundUrl + ", sendPhoneUrl=" + sendPhoneUrl
					+ ", createTime=" + createTime + ", modifyTime="
					+ modifyTime + "]";
		}


}
