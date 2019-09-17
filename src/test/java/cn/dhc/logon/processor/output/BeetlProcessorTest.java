package cn.dhc.logon.processor.output;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-09-17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BeetlProcessorTest {
    BeetlProcessor beetlProcessor;

    @Before
    public void setUp() throws Exception {
        beetlProcessor=new BeetlProcessor();
    }

    @Test
    public void testGetStringTemplate() throws IOException {
        String stringTemplate = beetlProcessor.getStringTemplate();
        Assert.assertEquals("hello,beetl",stringTemplate);
    }

    @Test
    public void testGetFileTemplate() throws IOException {
        String stringTemplate = beetlProcessor.getFileTemplate();
        Assert.assertNotEquals("",stringTemplate);
    }

    @Test
    public void testGtClasspathTemplate() throws IOException {
        beetlProcessor.getClasspathTemplate();
    }
}