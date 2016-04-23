package mongo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.java.dto.TemplateApproval;
import com.test.java.mongo.service.templateapproval.TemplateApprovalService;

public class TestFrame {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TemplateApprovalService bean = context.getBean(TemplateApprovalService.class);
		TemplateApproval dto = new TemplateApproval();
		dto.setId("021cf518cc0e41ac81849df05e089e14");
		dto.setCustomName("ding表审批");//-定标审批1
		bean.updateByPk(dto);
		TemplateApproval findByPk = bean.findByPk("021cf518cc0e41ac81849df05e089e14",TemplateApproval.class);
		System.out.println(findByPk.getCustomName());
		
	}
}
