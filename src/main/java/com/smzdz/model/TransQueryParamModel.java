package com.smzdz.model;
/**
 * 交易流水查询参数
 * @author wujingpan
 *
 */
public class TransQueryParamModel {

	private Integer appId;
	private String startTime;
	private String endTime;
	private Integer status;
	private Integer accessPlatform;
	 
	private String payId;
	
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getAccessPlatform() {
		return accessPlatform;
	}
	public void setAccessPlatform(Integer accessPlatform) {
		this.accessPlatform = accessPlatform;
	}
	
	
}
