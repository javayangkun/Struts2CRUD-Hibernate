package com.yangkun.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.yangkun.dao.IUserDao;
import com.yangkun.entity.User;
import com.yangkun.utils.HiBernateUtil;

public class UserDaoImpl implements IUserDao {
	// 1.创建会话对象
	private Session s = HiBernateUtil.openSession();

	@Override
	public void save(User user) {
		// TODO save User
		// 开始事务
		s.beginTransaction();
		// ==================================================
		s.save(user);
		// ==================================================
		// 提交事务
		s.getTransaction().commit();
		// 关闭会话
		s.close();
	}

	@Override
	public void delete(Integer id) {
		// TODO delete User by User`s id
		// 开始事务
		s.beginTransaction();
		// ==================================================
		User user = new User();
		user.setId(id);
		s.delete(user);
		// ==================================================
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public void update(User user) {
		// 开始事务
		s.beginTransaction();
		// ==================================================
		s.update(user);
		// ==================================================
		// 提交事务
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public List<User> find() {
		// TODO list all users
		String hql = "from User";
		// 开始事务
		s.beginTransaction();
		// ==================================================
		@SuppressWarnings("rawtypes")
		Query query = s.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		// ==================================================
		// 提交事务
		s.getTransaction().commit();
		s.close();
		return users;
	}

	@Override
	public User find(Integer id) {
		// 开始事务
		s.beginTransaction();
		// ==================================================
		User user = s.get(User.class, id);
		// ==================================================
		// 提交事务
		s.getTransaction().commit();
		s.close();
		return user;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> find(int startLine, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
