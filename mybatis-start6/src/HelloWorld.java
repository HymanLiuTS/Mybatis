import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.model.GroupMaper;
import com.yiibai.mybatis.model.MyGroup;
import com.yiibai.mybatis.model.MyUser;
import com.yiibai.mybatis.model.UserGroup;;

public class HelloWorld {

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

	public static void main(String[] args) {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			// Group相关操作
			GroupMaper groupMaper = session.getMapper(GroupMaper.class);
			MyGroup group = groupMaper.getGroup(1);
			System.out.println("Group => " + group.getGroupName());
			List<MyUser> users = group.getUsers();
			for (MyUser user : users) {
				System.out.println("\t:" + user.getId() + "\t" + user.getUsername());
			}
			groupMaper.insertGroup("cet");
			// User相关操作
			MyUser user = session.selectOne("com.yiibai.maper.UserMaper.getUser", 1);
			System.out.println("User => " + user.getUsername());
			List<MyGroup> groups = user.getGroups();
			for (MyGroup g : groups) {
				System.out.println("\t:" + g.getGroupId() + "\t" + g.getGroupName());
			}
			
			//增加关系
			UserGroup userGroup = new UserGroup();
			userGroup.setGroupId(1);
			userGroup.setUserId(2);
			session.insert("com.yiibai.mybatis.model.UserGroupMaper.insertUserGroup", userGroup);
			

			session.commit();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
