package mongo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.test.java.dto.Person;
import com.test.java.dto.TemplateApproval;
import com.test.java.mongo.service.templateapproval.TemplateApprovalService;

public class Test {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MongoTemplate bean = (MongoTemplate)context.getBean("mongoTemplate");
		Update update = new Update();
		update.set("age", 17);
		update.set("hobby", new String[]{"football"});
		bean.updateFirst(new Query(Criteria.where("_id").is("testtest")), update, Person.class);
//		Person dto = new Person();
//		dto.setAge("16");
//		dto.setId("testtest");
//		bean.insert(dto);
	}
}
