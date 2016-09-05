package me.gacl.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	/**
	 * 获取SqlSessionFactory
	 * @return SqlSessionFactory
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		String resouce = "conf.xml";
		InputStream is = MyBatisUtil.class.getClassLoader()
				.getResourceAsStream(resouce);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		return factory;

	}
	
	/**
	 * 获取SqlSession
	 * @return
	 */
	public static SqlSession getSqlSession(){
		return getSqlSessionFactory().openSession();
	}
	
	/**
	 * 获取SqlSession
	 * @param isAutoCommit
	 * 	true表示创建的SqlSession对象在执行完SQL之后会自动提交事务
	 * 	false表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用Sqlsession。commmit（）
	 * @return
	 */
	public static SqlSession getSqlSession(boolean isAutoCommit){
		return getSqlSessionFactory().openSession(isAutoCommit);
	}
}
