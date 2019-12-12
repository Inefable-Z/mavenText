package com.example.diedai;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		List list = new ArrayList();
		User user = new User();
		user.setId(1);
		user.setName("ÖÜÎå");
		user.setIdc(18);
		
		User user2 = new User();
		user2.setId(2);
		user2.setName("ÖÜÁù");
		user2.setIdc(22);
		
		list.add(user);
		list.add(user2);
		
		List list2 = new ArrayList();
		for(int i=0;i<list.size();i++) {
			User a = (User) list.get(i);
			list2.add(a.getIdc());
		}
		
		for(int i=0;i<list2.size();i++) {
			System.out.println(list2.get(i));
		}
	}
}
