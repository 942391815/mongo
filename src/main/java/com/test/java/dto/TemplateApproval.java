package com.test.java.dto;

import java.io.Serializable;
import java.util.Date;

public class TemplateApproval implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @描述:     
     * @字段:ID CHAR(32)  
     */	
	private String id;

	/**
     * @描述:流程模板名称
     * @字段:CUSTOM_NAME VARCHAR(200)
     */
	private String customName;

	/**
     * @描述:定义过要启动的流程模板id
     * @字段:CUSTOM_ID VARCHAR(32)
     */
	private String customId;

	/**
     * @描述:交易平台模板id
     * @字段:TEMPLATE_ID VARCHAR(32)
     */
	private String templateId;

	/**
     * @描述:工作流模板请求唯一标示
     * @字段:CUSTOM_UNIQUE_ID VARCHAR(32)
     */
	private String customUniqueId;

	/**
     * @描述:租户id
     * @字段:TENANT_ID CHAR(32)
     */
	private String tenantId;


	/**
     * @描述:状态(0=无效,1=有效,2=停用)
     * @字段:STATUS TINYINT(3)
     */
	private Integer status;
	/**
     * @描述:模板类型
     * @字段: TYPE INT(10)
     */
	private Integer type;


	/**
     * @描述:流程类型 0 财务 1，业务 2 项目 3 文档
     * @字段:TYPE TINYINT(3)
     */
	private Long orgCode;


	/**
     * @描述:
     * @字段:CREATE_USER_ID CHAR(32)
     */
	private String createUserId;

	/**
     * @描述:
     * @字段:CREATE_USER_NAME CHAR(100)
     */
	private String createUserName;

	/**
     * @描述:
     * @字段:CREATE_TIME DATETIME(19)
     */
	private Date createTime;

	/**
     * @描述:
     * @字段:UPDATE_USER_ID CHAR(32)
     */
	private String updateUserId;

	/**
     * @描述:
     * @字段:UPDATE_USER_NAME CHAR(100)
     */
	private String updateUserName;

	/**
     * @描述:
     * @字段:UPDATE_TIME DATETIME(19)
     */
	private Date updateTime;

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 *
	 */
	public TemplateApproval(){
	}

	/**
	 * @param id
	 */
	public TemplateApproval(String id){
		this.id = id;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @param customName 流程模板名称
	 */
	public void setCustomName(String customName) {
		this.customName = customName;
	}

	/**
	 * @return 流程模板名称
	 */
	public String getCustomName() {
		return this.customName;
	}

	/**
	 * @param customId 定义过要启动的流程模板id
	 */
	public void setCustomId(String customId) {
		this.customId = customId;
	}

	/**
	 * @return 定义过要启动的流程模板id
	 */
	public String getCustomId() {
		return this.customId;
	}

	/**
	 * @param templateId 交易平台模板id
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return 交易平台模板id
	 */
	public String getTemplateId() {
		return this.templateId;
	}

	/**
	 * @param customUniqueId 工作流模板请求唯一标示
	 */
	public void setCustomUniqueId(String customUniqueId) {
		this.customUniqueId = customUniqueId;
	}

	/**
	 * @return 工作流模板请求唯一标示
	 */
	public String getCustomUniqueId() {
		return this.customUniqueId;
	}

	/**
	 * @param tenantId 租户id
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * @return 租户id
	 */
	public String getTenantId() {
		return this.tenantId;
	}

	/**
	 * @param status 状态(0=无效,1=有效,2=停用)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return 状态(0=无效,1=有效,2=停用)
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * @param type 流程类型 0 财务 1，业务 2 项目 3 文档
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return 流程类型 0 财务 1，业务 2 项目 3 文档
	 */
	public Integer getType() {
		return this.type;
	}


	public Long getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(Long orgCode) {
		this.orgCode = orgCode;
	}
}
