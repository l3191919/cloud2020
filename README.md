#Java Spring cloud 分布式
####payment 8001 8002 8003
使用的技术有 
MySql
eureka
mybatis

注解有 
@SpringBootApplication 启动main方法基本注解
@EnableEurekaClient  让启动类识别Eureka服务

dao层的 @Mapper是数据持久层，用于给mapper接口 自动根据一个添加@Mapper注解的接口生成一个实现类


servic层的 @Service  表示给当前类命名一个别名，方便注入到其他类中 默认别名就是当前类名，但是首字母小写
如果有一个类带了@Service注解，将自动注册到Spring容器
不理解的地方：第一，怎么注册？

第二，注册了之后是什么样子。

第三 ，注册了之后有什么作用？

第四 ，什么叫定义bean，定义了之后什么样子，定义之后，有什么作用。

Controller层的 @RestController 就是@Controller+@ResponseBody

@Controller 是一种特殊化的@Component 类。
@Controller 习惯于和@RequestMapping绑定来使用，后者是用来指定路由映射的。
@ResponseBody 是用来把返回对象自动序列化成HttpResponse的。


@Resource
@Autowired

1、在启动Spring时，首先要启动容器

2、在启动Spring容器时，会默认寻找容器扫描范围内的可加载的bean，然后查找哪些bean上的属性和方法有@resource注解

3、找到@Resource注解后，判断其name属性是否为空，若为空，看Spring容器中的bean中的id与@Resource要注解的那个变量属性名是否相同，如相同，匹配成功；如不同，看spring容器中bean的id对应的类型是否与@Resource要注解的那个变量属性对应的类型是否相等，若相等，匹配成功，若不相等，匹配失败。

4、如果@Resource注解括号中的name属性不为空，看name的属性值和容器中的bean的id名是否相等，如相等，则匹配成功；如不相等，则匹配失败。

@Mapping
@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)

新方法可以简化为：

@GetMapping("/get/{id}")

@PostMapping(path = "/members", consumes = "application/json", produces = "application/json")



nocos支持负载均衡，是因为内置了ribbon，而ribboin只是个客户端负载均衡工具，服务调用这里用的是restTemplate，restTemplate只管调用，本身不具备负载均衡功能，要用@LoadBalanced注解赋予restTemplate负载均衡的功能


nacos和eureka代码上在集成ribbon，feign是一样的，没有任何区别，只是配置从eureka换成了nacos discovery

CAP
C：强一致性；A：高可用性；P：分区容错性