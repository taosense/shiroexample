package com.github.zhangkaitao.shiro.chapter12;


import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.my.shiro.credentials.RetryLimitHashedCredentialsMatcher;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml", "classpath:spring-shiro.xml"})
@TransactionConfiguration(defaultRollback = false)
public class TestCache {
	@Autowired
	CacheManager cacheManager;
	
	 private Cache<String, AtomicInteger> passwordRetryCache;
	
	@Test
	public void clear(){
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
		new RetryLimitHashedCredentialsMatcher(cacheManager);
		passwordRetryCache.remove("zhang");
	}

}
