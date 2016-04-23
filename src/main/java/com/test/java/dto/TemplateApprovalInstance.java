package com.test.java.dto;

import java.io.Serializable;
import java.util.Date;


public class TemplateApprovalInstance implements Serializable{
	private String id;
	private String approvalId;
	private String processId;
	private String processName;
	private Integer endType;
	private Integer currentNode;
	private Integer round;
	private Integer status;
	private String businessId;
	private String businessData;
	private String storeData;
	private String callbackUrl;
	private String createUserId;
	private String createUserName;
	private Date createTime;
	private String updateUserId;
	private String updateUserName;
	private Date updateTime;
	private String tenantId;
	private Long orgCode;
	private String approvalNodeCode;
	private String workFlow;
	private String dataKey;
	
	public TemplateApprovalInstance(){
	}

	/**
	 * @param id 主键
	 */
	public TemplateApprovalInstance(String id){
		this.id = id;
	}

	/**
	 * @param id 主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return 主键
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @param approvalId 模板id
	 */
	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
	}

	/**
	 * @return 模板id
	 */
	public String getApprovalId() {
		return this.approvalId;
	}

	/**
	 * @param processId 流程实例id
	 */
	public void setProcessId(String processId) {
		this.processId = processId;
	}

	/**
	 * @return 流程实例id
	 */
	public String getProcessId() {
		return this.processId;
	}

	/**
	 * @param processName 流程实例名称申请内容
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}

	/**
	 * @return 流程实例名称申请内容
	 */
	public String getProcessName() {
		return this.processName;
	}

	/**
	 * @param endType 流程结束状态。2 非正常结束（撤项） 1 流程正常结束 0审批不通过导致流程结束
	 */
	public void setEndType(Integer endType) {
		this.endType = endType;
	}

	/**
	 * @return 流程结束状态。2 非正常结束（撤项） 1 流程正常结束 0审批不通过导致流程结束
	 */
	public Integer getEndType() {
		return this.endType;
	}

	/**
	 * @param currentNode 当前第几级审批
	 */
	public void setCurrentNode(Integer currentNode) {
		this.currentNode = currentNode;
	}

	/**
	 * @return 当前第几级审批
	 */
	public Integer getCurrentNode() {
		return this.currentNode;
	}

	/**
	 * @param round 流程的轮次（同一个businessId下流程的轮次）
	 */
	public void setRound(Integer round) {
		this.round = round;
	}

	/**
	 * @return 流程的轮次（同一个businessId下流程的轮次）
	 */
	public Integer getRound() {
		return this.round;
	}

	/**
	 * @param status 流程状态 是否结束0 否1是
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return 流程状态 是否结束0 否1是
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * @param businessId 业务id
	 */
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	/**
	 * @return 业务id
	 */
	public String getBusinessId() {
		return this.businessId;
	}

	/**
	 * @param businessData 详细审批数据
	 */
	public void setBusinessData(String businessData) {
		this.businessData = businessData;
	}

	/**
	 * @return 详细审批数据
	 */
	public String getBusinessData() {
		return this.businessData;
	}

	/**
	 * @param callbackUrl 回调url
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	/**
	 * @return 回调url
	 */
	public String getCallbackUrl() {
		return this.callbackUrl;
	}

	/**
	 * @param createUserId
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @return
	 */
	public String getCreateUserId() {
		return this.createUserId;
	}

	/**
	 * @param createUserName
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	/**
	 * @return
	 */
	public String getCreateUserName() {
		return this.createUserName;
	}

	/**
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * @param updateUserId
	 */
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * @return
	 */
	public String getUpdateUserId() {
		return this.updateUserId;
	}

	/**
	 * @param updateUserName
	 */
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	/**
	 * @return
	 */
	public String getUpdateUserName() {
		return this.updateUserName;
	}

	/**
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return
	 */
	public Date getUpdateTime() {
		return this.updateTime;
	}
	/**
	 * @param tenantId
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * @return
	 */
	public String getTenantId() {
		return this.tenantId;
	}

	public Long getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(Long orgCode) {
		this.orgCode = orgCode;
	}
	public String getDataKey() {
		return dataKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public String getApprovalNodeCode() {
		return approvalNodeCode;
	}

	public void setApprovalNodeCode(String approvalNodeCode) {
		this.approvalNodeCode = approvalNodeCode;
	}

	public String getStoreData() {
		return storeData;
	}

	public void setStoreData(String storeData) {
		this.storeData = storeData;
	}

	public String getWorkFlow() {
		return workFlow;
	}

	public void setWorkFlow(String workFlow) {
		this.workFlow = workFlow;
	}
}
