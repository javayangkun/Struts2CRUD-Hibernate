package com.yangkun.service.impl;

import java.util.List;

import com.yangkun.dao.impl.UserDaoImpl;
import com.yangkun.entity.Page;
import com.yangkun.entity.User;
import com.yangkun.service.IUserService;

public class UserServiceImpl implements IUserService {
	private static UserDaoImpl userDao = new  UserDaoImpl();
	@Override
	public void save(User user) {
		// TODO save User
		userDao.save(user);
	}

	@Override
	public void delete(Integer id) {
		// TODO delete User by User`s id
		userDao.delete(id);
	}

	@Override
	public void update(User user) {
		// TODO update users
		userDao.update(user);
	}

	@Override
	public List<User> find() {
		// TODO list all users
		return userDao.find();
	}

	@Override
	public User find(Integer id) {
		// TODO query user by User`s id
		return userDao.find(id);
	}

	@Override
	public Page<User> findPageData(int p, int size) {
		//TODO init Page and return Page
		int rowCount = userDao.getRowCount();
		//获取初始化过的Page对象
		Page<User> page = new Page<>(size,p,rowCount);
		//将数据page对象封装进list集合
		List<User> list = userDao.find(page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}

}
