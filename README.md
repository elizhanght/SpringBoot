# DisConfSys
1. 分布式文件配置中心
2. 此工程是 SpringBoot 为基础进行开发的，基于 Spring 框架开发。
3. 此项目包括两个部分 DisConfSys 和 SisConfSysClient 两个部分。DisConfSys 主要提供web配置功能以及和 client 的接口。
4. 主要功能
    1. 添加项目
    2. 添加配置文件
    3. 添加属性文件
    4. 提供 HTTP 接口
    
#如何使用
  1. 添加 client 依赖的 JAR 包
  ~~~
    
  ~~~
  2. 引入资源
  ~~~
    @PropertySource(value ="classpath:config.properties",factory=})
  ~~~
  
  3. 使用资源
  ~~~
    @Value("${rom_remote_url}")
	  private String romRemoteUrl;
  ~~~
  
