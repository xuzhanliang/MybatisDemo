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
		//ִ�в������
		int retResult = sqlSession.insert(statement, user);
		//�ֶ��ύ����
		//sqlSession.commit();
		//ʹ��SqlSessionִ����SQL֮����Ҫ�ر�
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
