package com.yangkun.service;

import java.util.List;

import com.yangkun.entity.Page;
import com.yangkun.entity.User;

public interface IUserService {
	void save(User user);
	void delete(Integer id);
	void update(User user);
	List<User> find();
	User find(Integer id);
	Page<User> findPageData(int p, int size);
}
