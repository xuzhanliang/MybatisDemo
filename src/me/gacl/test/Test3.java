package me.gacl.test;

import me.gacl.domain.Classes;
import me.gacl.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test3 {
	
	@Test
	public void testGetClass(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		String statement = "me.gacl.mapping.classMapper.getClass";
		
		Classes clazz = sqlSession.selectOne(statement,1);
		sqlSession.close();
		System.out.println(clazz);
	}
	
	@Test
	public void testGetClass2(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		String statement = "me.gacl.mapping.classMapper.getClass2";
		
		Classes clazz = sqlSession.selectOne(statement,2);
		sqlSession.close();
		System.out.println(clazz);
	}
	
	
	
}
