package com.yangkun.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.yangkun.dao.IUserDao;
import com.yangkun.entity.User;
import com.yangkun.utils.HiBernateUtil;

public class UserDaoImpl implements IUserDao {
	// 1.�����Ự����
	private Session s = HiBernateUtil.openSession();

	@Override
	public void save(User user) {
		// TODO save User
		// ��ʼ����
		s.beginTransaction();
		// ==================================================
		s.save(user);
		// ==================================================
		// �ύ����
		s.getTransaction().commit();
		// �رջỰ
		s.close();
	}

	@Override
	public void delete(Integer id) {
		// TODO delete User by User`s id
		// ��ʼ����
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
		// ��ʼ����
		s.beginTransaction();
		// ==================================================
		s.update(user);
		// ==================================================
		// �ύ����
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public List<User> find() {
		// TODO list all users
		String hql = "from User";
		// ��ʼ����
		s.beginTransaction();
		// ==================================================
		@SuppressWarnings("rawtypes")
		Query query = s.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		// ==================================================
		// �ύ����
		s.getTransaction().commit();
		s.close();
		return users;
	}

	@Override
	public User find(Integer id) {
		// ��ʼ����
		s.beginTransaction();
		// ==================================================
		User user = s.get(User.class, id);
		// ==================================================
		// �ύ����
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
