package com.demos.mysqlmybatisplusquickstart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demos.mysqlmybatisplusquickstart.entity.User;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

  @Select("select * from user where name=#{name}")
  List<User> selectByName(String name);
}
