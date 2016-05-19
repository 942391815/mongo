package mongo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.test.java.dto.TemplateApproval;
import com.test.java.mongo.service.templateapproval.TemplateApprovalService;

public class TestFrame {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		TemplateApprovalService bean = context.getBean(TemplateApprovalService.class);
		MongoTemplate bean = (MongoTemplate)context.getBean("mongoTemplate");
		
		
	}
}
