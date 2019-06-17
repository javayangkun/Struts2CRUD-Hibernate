package com.yangkun.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yangkun.entity.Page;
import com.yangkun.entity.User;
import com.yangkun.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	private static UserServiceImpl userService = new UserServiceImpl();
	private int p;
	private User user = new User();

	public String save() {
		userService.save(user);
		return "find";
	}

	public String find() {
		Page<User> page = userService.findPageData(p, 5);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("page", page);
		return "findUI";
	}

	public String delete() {
		userService.delete(user.getId());
		return "find";
	}

	public String update() {
		userService.update(user);
		return "find";
	}

	public String updateUI() {
		// 根据id查询获取User对象
		ServletActionContext.getRequest().setAttribute("user", userService.find(user.getId()));
		return "updateUI";
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	@Override
	public User getModel() {
		// TODO 获得user对象
		return user;
	}

}
