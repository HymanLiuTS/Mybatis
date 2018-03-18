import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.models.IUser;
import com.yiibai.mybatis.models.MyUser;

public class HelloWord {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("config/Configure.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {

			IUser iuser=session.getMapper(IUser.class);
			MyUser user=iuser.getUserByID(1);
			if(user!=null){
				String userInfo = "名字："+user.getUsername()+", 电话：："+user.getMobile();
				System.out.println(userInfo);
			}
			
			user=iuser.getUserByIDName(user);
			if(user!=null){
				String userInfo = "名字："+user.getUsername()+", 电话：："+user.getMobile();
				System.out.println(userInfo);
			}
			user.setUsername(null);
			user.setId(2);
			user=iuser.getUserByChose(user);
			if(user!=null){
				String userInfo = "名字："+user.getUsername()+", 电话：："+user.getMobile();
				System.out.println(userInfo);
			}
			
			user=iuser.getUserByTrim(user);
			if(user!=null){
				String userInfo = "名字："+user.getUsername()+", 电话：："+user.getMobile();
				System.out.println(userInfo);
			}
			
			user.setId(2);
			user.setMobile(123456);
			user.setUsername("hyman");
			iuser.updateUser(user);
			
			user.setUsername("hyman2");
			iuser.updateUser2(user);
			
			
			session.commit();
		} finally {
			session.close();
		}
	}

}
