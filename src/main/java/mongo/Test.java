package mongo;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSONObject;
import com.test.java.dto.TemplateApproval;
import com.test.java.mongo.service.templateapproval.TemplateApprovalService;

public class Test {
	public static void main(String[] args) throws Exception {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		MongoTemplate bean = (MongoTemplate)context.getBean("mongoTemplate");
//		Update update = new Update();
//		update.set("age", 17);
//		update.set("hobby", new String[]{"football"});
//		bean.updateFirst(new Query(Criteria.where("_id").is("testtest")), update, Person.class);
		
		importData();
	}
	public static void importData(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MongoTemplate template = (MongoTemplate)context.getBean("mongoTemplate");
		JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList("select * from template_approval_instance");
		for(Map each:queryForList){
			String eachJson = JSONObject.toJSON(each).toString();
			TemplateApproval approval = JSONObject.parseObject(eachJson, TemplateApproval.class);
			template.insert(approval);
		}
	}
}
