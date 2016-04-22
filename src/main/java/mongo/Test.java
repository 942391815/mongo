package mongo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
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
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
////		CommonQuery bean = (CommonQuery)context.getBean("commonQuery");
//		TemplateApproval approval = new TemplateApproval();
//		approval.setId("004f64caaebd11e598bcfa163e84de1b");
//		List findByCondtion = bean.findByCondtion(approval);
//		System.out.println(findByCondtion.get(0));
	}
}
