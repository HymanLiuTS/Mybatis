import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.models.MyUser;
import com.yiibai.mybatis.models.Post;

public class HelloWorld {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static {

		try {
			reader = Resources.getResourceAsReader("config/Configure.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			int userid=1;
			MyUser user = session.selectOne("com.yiibai.userMaper.getUser", 1);
			System.out.println("username: "+user.getUsername()+",");
			List<Post> posts=user.getPosts();
			for(Post post:posts) {
				System.out.println(post.getTitle());
				System.out.println(post.getContent());
			}
		} finally {
			// TODO: handle finally clause
			session.close();
		}

	}

}
