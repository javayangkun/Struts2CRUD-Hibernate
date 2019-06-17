package com.yangkun.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.yangkun.dao.IUserDao;
import com.yangkun.entity.User;
import com.yangkun.utils.HiBernateUtil;

public class UserDaoImpl implements IUserDao {
	// 1.创建会话对象

	@Override
	public void save(User user) {
		// TODO save User
		// 开始事务
		Session s = HiBernateUtil.openSession();
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
		Session s = HiBernateUtil.openSession();
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
		Session s = HiBernateUtil.openSession();
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
		Session s = HiBernateUtil.openSession();
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
		Session s = HiBernateUtil.openSession();
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
		Session s = HiBernateUtil.openSession();
		s.beginTransaction();
		//===================================================
		String hql = "SELECT COUNT(id) FROM User";
		@SuppressWarnings("rawtypes")
		Query query = s.createQuery(hql);
		//返回的实际类型为Long型
		Object result = query.uniqueResult();
		//强转为Long,然后转为int类型
		Long rowCount = (Long) result;
		//===================================================
		s.getTransaction();
		s.close();
		return rowCount.intValue();
	}

	@Override
	public List<User> find(int startLine, int size) {
		Session s = HiBernateUtil.openSession();
		s.beginTransaction();
		//=====================================================
		String hql = "from User";
		@SuppressWarnings("rawtypes")
		Query query = s.createQuery(hql);
		query.setFirstResult(startLine);
		query.setMaxResults(size);
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		//=====================================================
		s.getTransaction().commit();
		s.close();
		return users;
	}

}
