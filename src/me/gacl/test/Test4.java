package me.gacl.test;

import me.gacl.domain.Classes;
import me.gacl.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test4 {

	@Test
	public void testGetClass3(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		String statementString = "me.gacl.mapping.classMapper.getClass3";
		
		Classes clazzClasses = sqlSession.selectOne(statementString, 1);
		
		sqlSession.close();
		
		System.out.println(clazzClasses);
	}
	
	@Test
	public void testGetClass4(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		String statementString = "me.gacl.mapping.classMapper.getClass4";
		
		Classes clazzClasses = sqlSession.selectOne(statementString, 1);
		
		sqlSession.close();
		
		System.out.println(clazzClasses);
	}
}
