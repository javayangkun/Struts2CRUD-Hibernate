package com.yangkun.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.yangkun.dao.impl.UserDaoImpl;
import com.yangkun.entity.Page;
import com.yangkun.entity.User;
import com.yangkun.service.impl.UserServiceImpl;

public class TestUserService {
	private static UserServiceImpl userService = new UserServiceImpl();
	private static UserDaoImpl userDao = new UserDaoImpl();
	@Test
	public void testSave() {
		//succeed
		User user = new User();
		user.setName("ÀîÄþ");
		user.setBirthday(new Date());
		user.setMoney(500d);
		userService.save(user);
	}

	@Test
	public void testDelete() {
		//succeed
		userService.delete(125);
	}

	@Test
	public void testUpdate() {
		//succeed
		User user = new User();
		user.setId(124);
		user.setName("ÀîÄþ");
		user.setBirthday(new Date());
		user.setMoney(5000d);
		userService.update(user);
	}

	@Test
	public void testFind() {
		//succeed
		List<User> users = userService.find();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void testFindByInteger() {
		User user = userService.find(1);
		System.out.println(user);
	}

	@Test
	public void testFindPageData() {
		Page<User> pageData = userService.findPageData(0, 5);
		System.out.println(pageData);
	}

	@Test
	public void testGetRowCount() {
		int rowCount = userDao.getRowCount();
		System.out.println(rowCount);
	}
}
