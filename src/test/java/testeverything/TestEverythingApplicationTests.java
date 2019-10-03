package testeverything;

import com.TestEverythingApplication;
import com.wyl.Async.AsyncTask;
import com.wyl.activeMQ.consumer.service.MsgConsumerService;
import com.wyl.activeMQ.producer.service.MsgProducerService;
import com.wyl.java8.Java8Stream;
import com.wyl.mybatis.entity.User;
import com.wyl.mybatis.service.UserService;
import com.wyl.redis.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= TestEverythingApplication.class)
public class TestEverythingApplicationTests {
    //测试Mybaits
	@Resource
	UserService userService;
	@Test
	public void mybatis() {
		User user = new User();
		user.setUserid(1);
		User lin = userService.getUserInfo(user);
		System.out.println(lin.getUsername());
	}
    //测试redis
	@Resource
	private StringRedisTemplate stringRedisTemplate;
	@Resource
	private RedisClient redisClient;
	@Test
	public void redis(){
		User myUser = new User();
		myUser.setAge("19");
		myUser.setGender("女");
		myUser.setUsername("琳琳");
		myUser.setUserid(21);
		redisClient.set("User",myUser);
//		stringRedisTemplate.opsForValue().set("wwwUser","wwwNameOs");
//		User redisUser = (User)redisClient.get("myUser");
//		System.out.println(redisUser.toString());
	}
	//测试async
	@Resource
	AsyncTask asyncTask;
	@Test
	public void testAsync() throws Exception{
		Future a = asyncTask.taskFuture();
		System.out.println("1");
		System.out.println("2");
		//这一步是阻塞的
		System.out.println(a.get().toString());
		System.out.println("5");
		System.out.println("6");
	}
	//测试java8
	@Resource
	private Java8Stream java8Stream;
	@Test
	public void java8Stream(){
//		java8Stream.testForEach();
//		java8Stream.testMap();
		java8Stream.testFilter();
	}
	//测试logback
	@Test
	public void testLogBack(){
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.info("this is info");
		logger.debug("this is Debug");
		logger.error("this is error");
		int i = 10/0;
	}
	//测试ActiveMQ
	@Resource
	private MsgProducerService msgProducerService;
	@Resource
	private MsgConsumerService msgConsumerService;
	@Test
	public  void testActiveMQ() {
		String msg = "tzsijiwjiw";
		msgProducerService.sendMsg(msg);
//		msgConsumerService.receivedMsg();

	}
}
