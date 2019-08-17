package cn.dhc.logon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogonApplicationTest {

	@Test
	public void contextLoads() {
        System.out.println("This is my first test");
	}

	@Test
    public String findName(){

	    return "Charles";
    }
}
