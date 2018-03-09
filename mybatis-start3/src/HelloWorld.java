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
			// 查询单个对象
			System.out.println("插入前：");
			MyUser user = iuser.getUser(1);
			System.out.println("名字：" + user.getName());
			System.out.println("所属部门：" + user.getDept());
			System.out.println("主页：" + user.getWebsite());

			// 插入对象
			user = new MyUser();
			// user.setId(2);
			user.setName("Hyman");
			user.setDept("cet");
			user.setPhone("123456789");
			iuser.insertUser(user);

			// 更新对象
			System.out.println("插入后：");
			user.setId(2);
			user.setWebsite("www.codenest.cn");
			iuser.updateUser(user);

			List<MyUser> list = iuser.getUserList();
			for (MyUser u : list) {
				System.out.println("名字：" + u.getName());
				System.out.println("所属部门：" + u.getDept());
				System.out.println("主页：" + u.getWebsite());

			}
			
			iuser.deleteUser(2);

			session.commit();
		} finally {
			// TODO: handle finally clause
			session.close();
		}

	}

}
