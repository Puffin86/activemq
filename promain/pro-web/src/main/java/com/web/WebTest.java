package com.web;

import com.core.CoreTest;
import com.util.UtilTest;

public class WebTest {
	public void talk(){
		CoreTest ct = new CoreTest();
		UtilTest ut = new UtilTest();
		ct.talk();
		ut.talk();
		System.out.println("WebTest talking~~");
	}
	
	
	public static void main(String[] args){
		WebTest wt = new WebTest();
		wt.talk();
	}
	
}
