import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yiibai.maper.UserMaper;
import com.yiibai.pojo.Order;
import com.yiibai.pojo.User;

public class Main {

	private static ApplicationContext ctx;

	static {
		try {
			ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UserMaper userMaper = (UserMaper) ctx.getBean("userMaper");
//		// ����id=1���û���ѯ���ɸ������ݿ��е�����޸�.
		User user = userMaper.getUserById(1);
		System.out.println("��ȡ�û� ID=1 ���û�����"+user.getUsername());
//
//		// �õ������б����
		System.out.println("�õ��û�idΪ1�����ж����б�:");
		System.out.println("=============================================");
		List<Order> orders = userMaper.getUserOrders(1);

		for (Order order : orders) {
			System.out.println("�����ţ�"+order.getOrderNo() + "��������" + order.getMoney());
		}

	}

}
