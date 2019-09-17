package cn.dhc.logon.processor.output;

import lombok.extern.slf4j.Slf4j;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.core.resource.StringTemplateResourceLoader;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-09-17
 */
@Slf4j
public class BeetlProcessor {

    public String getStringTemplate() throws IOException {
        //初始化代码
        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        //获取模板
        Template t = gt.getTemplate("hello,${name}");
        t.binding("name", "beetl");
        //渲染结果
        String str = t.render();
        return str;
    }

    public String getFileTemplate() throws IOException {
        String root = System.getProperty("user.dir") + File.separator + "template";
        FileResourceLoader resourceLoader = new FileResourceLoader(root, "utf-8");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("/beetl/hello.btl");
        t.binding("name", "beetl");
        return t.render();
    }

    public void getClasspathTemplate() throws IOException {
        FileWriter write = new FileWriter("C:\\user\\test.txt");
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("template/beetl/");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("/hello.btl");
        t.binding("name", "beetl");
        t.renderTo(write);
        write.flush();
        write.close();
    }

}
