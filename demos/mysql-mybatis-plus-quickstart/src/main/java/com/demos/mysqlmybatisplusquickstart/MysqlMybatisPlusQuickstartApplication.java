package com.demos.mysqlmybatisplusquickstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demos.mysqlmybatisplusquickstart.mapper")
public class MysqlMybatisPlusQuickstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlMybatisPlusQuickstartApplication.class, args);
	}

}
