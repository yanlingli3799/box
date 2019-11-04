package com.demos.mysqlmybatisplusquickstart;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demos.mysqlmybatisplusquickstart.entity.User;
import com.demos.mysqlmybatisplusquickstart.mapper.UserMapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class MysqlMybatisPlusQuickstartApplicationTests {

	@Resource
	private UserMapper userMapper;


	@Test
	void testSelectAll() {
		System.out.print("----testSelectAll--------------------");
		List<User> userEntities = userMapper.selectList(null);
		System.out.println("结果："+userEntities);
		System.out.print("----testSelectAll--------------------");
	}

	/**
	 * 自定义的 select 语句
	 */

	@Test
	void testSelectByNormalName(){
		System.out.print("----testSelectByNormalName--------------------");
		List<User> userEntities = userMapper.selectByName("lisi");
		System.out.println("结果："+userEntities);
		System.out.print("----testSelectByNormalName--------------------");
	}


	@Test
	void testSelectByBadName(){
		System.out.print("----testSelectByBadName--------------------");
		List<User> userEntities = userMapper.selectByName("1' or '1'='1");
		System.out.println("结果："+userEntities);
		System.out.print("----testSelectByBadName--------------------");
	}


	/**
	 * 自带的 selectList
	 */

	@Test
	void testSelectListByNormalName(){
		System.out.print("----testSelectListByNormalName--------------------");
		List<User> userEntities = userMapper.selectList(new QueryWrapper<User>().eq("name", "lisi"));
		System.out.println("结果："+userEntities);
		System.out.print("----testSelectListByNormalName--------------------");
	}

	@Test
	void testSelectListByBadName(){
		System.out.print("----testSelectListByBadName--------------------");
		List<User> userEntities = userMapper.selectList(new QueryWrapper<User>().eq("name","1' or '1'='1"));
		System.out.println("结果："+userEntities);
		System.out.print("----testSelectListByBadName--------------------");
	}


}
