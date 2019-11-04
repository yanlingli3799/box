
#### 代码编写方式

1. 引入需要的第三方 jar 包，有2个：
    > 1.`mybatis-plus-boot-starter`
    > 2.`mysql-connector-java`
    > eg：参见 pom.xml

2. 创建数据表，并创建数据表对应的 `xxxEntity`
    > 表名 -> Entity名 转换规则：首字母和 _开头的字母大写
    > 若表名和实体类名不一样，需要用 @TableName 注解做映射配置
    > eg：参见 User.java

3. 创建数据表对应的 `xxxMapper`，并 `extends BaseMapper<xxxEntity>`
    > 可自定义 sql 方法
    > eg：参见 UserMapper.java

4. 在启动类名前加 `@MapperScan` 注解，指明 mapper 存放的包路径
    > eg：参见 MysqlMybatisPlusQuickstartApplication.java

5. 加数据源配置
    > eg：参见 application.yml

6. @Resource 引用 xxxMapper
    > eg：参见 MysqlMybatisPlusQuickstartApplicationTests.java


------

#### 测试内容
1. SQL注入
    > 自带 selectList、自定义的 select 语句 **都没有 SQL 注入风险**
