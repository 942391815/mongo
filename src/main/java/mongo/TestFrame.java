package mongo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.java.dto.TemplateApproval;
import com.test.java.mongo.service.templateapproval.TemplateApprovalService;

public class TestFrame {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TemplateApprovalService bean = context.getBean(TemplateApprovalService.class);
		TemplateApproval findByPk = bean.findByPk("01977928ad4f11e598bcfa163e84de1b", TemplateApproval.class);
		System.out.println(findByPk.getCustomName());
	}
}
