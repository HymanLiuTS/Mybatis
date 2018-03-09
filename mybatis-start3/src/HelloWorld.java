import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.dao.IMyUser;
import com.yiibai.mybatis.models.MyUser;

public class HelloWorld {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static {

		try {
			reader = Resources.getResourceAsReader("config/Configure.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			// sqlSessionFactory.getConfiguration().addMapper(IMyUser.class);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			IMyUser iuser = session.getMapper(IMyUser.class);
			// ��ѯ��������
			System.out.println("����ǰ��");
			MyUser user = iuser.getUser(1);
			System.out.println("���֣�" + user.getName());
			System.out.println("�������ţ�" + user.getDept());
			System.out.println("��ҳ��" + user.getWebsite());

			// �������
			user = new MyUser();
			// user.setId(2);
			user.setName("Hyman");
			user.setDept("cet");
			user.setPhone("123456789");
			iuser.insertUser(user);

			// ���¶���
			System.out.println("�����");
			user.setId(2);
			user.setWebsite("www.codenest.cn");
			iuser.updateUser(user);

			List<MyUser> list = iuser.getUserList();
			for (MyUser u : list) {
				System.out.println("���֣�" + u.getName());
				System.out.println("�������ţ�" + u.getDept());
				System.out.println("��ҳ��" + u.getWebsite());

			}
			
			iuser.deleteUser(2);

			session.commit();
		} finally {
			// TODO: handle finally clause
			session.close();
		}

	}

}
