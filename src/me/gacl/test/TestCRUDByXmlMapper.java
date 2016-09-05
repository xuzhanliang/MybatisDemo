package me.gacl.test;

import java.util.List;

import me.gacl.domain.User;
import me.gacl.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.junit.Test;

public class TestCRUDByXmlMapper {
	
	static Logger log = Logger.getLogger(TestCRUDByXmlMapper.class.getName());
	@Test
	public void testADD(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		
		String statement ="me.gacl.mapping.userMapper.addUser";
		User user = new User();
		user.setName("cmy");
		user.setAge(20);
		//执行插入操作
		int retResult = sqlSession.insert(statement, user);
		//手动提交事务
		//sqlSession.commit();
		//使用SqlSession执行完SQL之后需要关闭
		sqlSession.close();
		System.out.println(retResult);
	}
	
	@Test
	public void testUpdate(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		
		String statement ="me.gacl.mapping.userMapper.updateUser";
		User user = new User();
		user.setId(3);
		user.setName("yonghu1");
		user.setAge(20);
		int retResult = sqlSession.update(statement, user);
		sqlSession.close();
		System.out.println(retResult);
	}
	
	@Test
	public void testDelete(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		
		String statement ="me.gacl.mapping.userMapper.deleteUser";
		
		int retResult = sqlSession.update(statement, 6);
		sqlSession.close();
		System.out.println(retResult);
	}
	
	@Test
	public void testGetAll(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		
		String statement ="me.gacl.mapping.userMapper.getAllUsers";
		List<User> users = sqlSession.selectList(statement);
		for(User user:users){
			MDC.put("username", user.getName());
			log.info("info");
		}
		sqlSession.close();
		System.out.println(users);
		
	   // log.info(users);
	}
	
}
