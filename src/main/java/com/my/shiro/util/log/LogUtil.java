package com.my.shiro.util.log;

import org.springframework.stereotype.Service;

@Service
public class LogUtil {

	@LogAnnotation(mothodName="加钱")
	public String addMon(String userId1, int num){
		System.out.println("addMon service!");
		return "return";
	}
	
	@LogAnnotation(mothodName="加多钱")
	public String addMons(String userId, int num){
		System.out.println("addMons service!");
		return "return";
	}
}
