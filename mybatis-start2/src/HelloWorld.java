import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.models.IUser;
import com.yiibai.mybatis.models.MyUser;

public class HelloWorld {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static {

		try {
			reader = Resources.getResourceAsReader("config/Configure.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSessionFactory.getConfiguration().addMapper(IUser.class);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUser iuser = session.getMapper(IUser.class);
			MyUser user = iuser.getUserByID(1);
			System.out.println("���֣�" + user.getName());
			System.out.println("�������ţ�" + user.getDept());
			System.out.println("��ҳ��" + user.getWebsite());
		} finally {
			// TODO: handle finally clause
			session.close();
		}

	}
}
