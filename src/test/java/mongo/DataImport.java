package mongo;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSONObject;
import com.test.java.dto.TemplateApprovalInstance;

public class DataImport {
	public static void main(String[] args) {
		String sql = "SELECT t.id,t.APPROVAL_ID           approvalId,t.PROCESS_ID            processId,"
				+ "t.PROCESS_NAME          processName,t.END_TYPE              endType,t.CURRENT_NODE          currentNode,t.ROUND                 ROUND,t.STATUS                STATUS,"
				+ "t.BUSINESS_ID           businessId,t.BUSINESS_DATA         businessData,t.CALLBACK_URL          callBackUrl,t.CREATE_USER_ID        createUserId,t.CREATE_USER_NAME      createUserName,"
				+ "t.UPDATE_TIME           updateTime,t.TENANT_ID             tenantId,t.ORG_CODE              orgCode,"
				+ "t.DATA_KEY              dataKey,t.APPROVAL_NODE_CODE    approvalNodeCode,t.STORE_DATA            storeData,t.WORK_FLOW             workFlow"
				+ " FROM template_approval_instance t";
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		MongoTemplate mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
		List<TemplateApprovalInstance> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper(TemplateApprovalInstance.class));
//		Map each = queryForList.get(0);
		for(TemplateApprovalInstance each:query){
//			TemplateApprovalInstance instance = new TemplateApprovalInstance();
//			instance.setId(each.get("id"));
//			TemplateApprovalInstance parseObject = JSONObject.parseObject(each.toString(), TemplateApprovalInstance.class);
			mongoTemplate.insert(each);
		}
	}
}
