### mybatis-01-helloworld
* mybatis 配置介绍
* mybatis 实现增删改查
* mybatis-config.xml 配置模板设置
* xxxMapper.xml 配置模板设置
* [MyBatisTest]()
---

### mybatis-02-params
* mybatis 传参给sql实现增删改查
* mybatis获取参数值的两种方式
    * `#{}` 本质是占位符赋值,会自动添加单引号
    * `${}` 本质是字符串拼接
* 通过 `@Param` 注解定义传给sql的参数名
* 模糊查询
* 添加功能获取自增的主键
  * 在 `insert` 标签中配置 `useGeneratedKeys="true" keyProperty="对应的属性"`
* [TestMyBatisWithParams]
* [SpecialMapperTest]

---

### mybatis-03-resultmap
* 对多一映射处理
  * 级联方式
    * `<resultMap id="empDeptMap" type="Emp">`
    * `<result column="did" property="dept.did"></result>`
  * `association` 标签
    ```
    <association property="dept" javaType="Dept">
      <id column="did" property="did"></id>
      <result column="dname" property="dname"></result>
    </association>
    ```
  * 分步查询
    `<association property="dept"select="com.atguigu.MyBatis.mapper.DeptMapper.getEmpDeptByStep" column="did">`

* 一对多映射处理
  * `<collection property="emps" ofType="Emp">`
* [ResultMapTest]()

---

### mybatis-04-dynamicsql 动态sql
* [DynamicSqlTest]()
* `if`
    ```
    <if test="ename != '' and ename != null"> 
    ename = #{ename}
    </if>
    ```
* `where`
    ```
    select * from t_emp
    <where>
        <if test="ename != '' and ename != null">
            ename = #{ename}
        </if>
        <if test="age != '' and age != null">
            and age = #{age}
        </if>
        </if>
    </where>
    ```
* `trim`
    ```
    select * from t_emp
    <trim prefix="where" suffixOverrides="and">
        <if test="ename != '' and ename != null">
            ename = #{ename} and
        </if>
        <if test="age != '' and age != null">
            age = #{age} and
        </if>
        <if test="sex != '' and sex != null">
            sex = #{sex}
        </if>
    </trim>
    ```
* `choose/when/otherwise`: 相当于 `if-else if-else`
    ```
	select <include refid="empColumns"></include> from t_emp
	<where>
		<choose>
			<when test="ename != '' and ename != null">
				ename = #{ename}
			</when>
			<when test="age != '' and age != null">
				age = #{age}
			</when>
			<when test="sex != '' and sex != null">
				sex = #{sex}
			</when>
			<when test="email != '' and email != null">
				email = #{email}
			</when>
		</choose>
	</where>
    ```
* foreach
    ```
	insert into t_emp values
	<foreach collection="emps" item="emp" separator=",">
		(null,#{emp.ename},#{emp.age},#{emp.sex},#{emp.email},null)
	</foreach>
    ```
* sql片段
    ```
    <sql id="empColumns">
        eid,ename,age,sex,did
    </sql>
    
    select <include refid="empColumns"/> from t_emp
    ```

### mybatis-05-cache
* 一级缓存
  * SqlSession级别
* 二级缓存
  * SqlSessionFactory级别
  * 需要上一个SqlSession 提交/关闭 才会触发缓存
  * xxxMapper.xml 需要配置 `<cache />` 标签
  * 数据类需要实现序列化接口
* 两个缓存只要中间出现增删改操作 就会触发缓存失效
* [CacheTest]()

### mybatis-06-mbg
* 逆向插件
  * 通过读表信息 生成对应的代码
  * [generatorConfig.xml]()
  * [pom.xml]()
  * [MybatisMBGTest]()
* 分页插件
  * `com.github.pagehelper`
  * [PageTest]()