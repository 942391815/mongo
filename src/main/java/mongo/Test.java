package mongo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSONObject;
import com.test.java.dto.Person;
import com.test.java.dto.TemplateApproval;
import com.test.java.dto.TemplateApprovalInstance;
import com.test.java.utils.Tools;

public class Test {
	public static void main(String[] args) throws Exception {
		insert();
	}
	public static void test() throws Exception{
		Map map = new HashMap();
		Person p = new Person();
		p.setAge("132");
		p.setId("sdfsdf");
		p.setName("zhangsan");
		p.setHobby(new String[]{"sdf","sdxx"});
		Class clazz = p.getClass();
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for(Method each:declaredMethods){
			if(each.getName().startsWith("get")){
				String fieldName = Tools.converFirstCharToLower(each.getName().substring(3));
				map.put(fieldName, each.invoke(p, null));
			}
		}
		System.out.println(map);
	}
	public static void insert(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MongoTemplate template = (MongoTemplate)context.getBean("mongoTemplate");
		JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
		
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList("select * from template_approval_instance");
		for(Map each:queryForList){
			String eachObj = JSONObject.toJSON(each).toString();
			System.out.println(each);
			TemplateApprovalInstance bean = (TemplateApprovalInstance)JSONObject.parseObject(eachObj, TemplateApprovalInstance.class);
			template.insert(bean);
		}
	}
}
