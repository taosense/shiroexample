package com.github.zhangkaitao.shiro.chapter12;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.shiro.util.log.LogUtil;

public class TestLog {
	static LogUtil logUtil;
	private static ApplicationContext appContext;
	
	@BeforeClass
    public static void setUpBeforeClass() throws Exception {
        appContext = new ClassPathXmlApplicationContext(
                "spring-log.xml");
        // 初始化cacheDao
        logUtil = appContext.getBean("logUtil", LogUtil.class);
    }

    @AfterClass
    public static void setUpAfterClass() throws Exception {
    }
	
	
	@Test
	public void testName() throws Exception {
		logUtil.addMon("sdafd", 1);
		logUtil.addMons("sdafd", 1);
	}

}
