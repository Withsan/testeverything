package testeverything;

import com.TestEverythingApplication;
import com.wyl.Async.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= TestEverythingApplication.class)
public class TestEverythingApplicationTests {
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
	}

