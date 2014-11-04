package com.ClientCardManagement.action;

import java.sql.Timestamp;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.service.LoginService;
import com.ClientCardManagement.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5916053796470570580L;

	@Resource
	private UserService userService;
	@Resource
	private LoginService loginService;
	private MstUser user;
	private String username;
	private String password;
	private String userid;
	private boolean isPasswordCorrect;
	public boolean getIsPasswordCorrect(){
		return isPasswordCorrect;
	}
	public MstUser getUser() {
		return user;
	}

	public void setUser(MstUser user) {
		this.user = user;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String logout() {
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		session.remove("username");
		session.remove("userid");
		session.remove("userkub");
		return "not-login";
	}

	public String login() {

		if (username != null) {
			user = loginService.getUserFromName(username.trim());
		}
		if (user != null
				&& loginService.checkUserLogin(user, username, password)) {
			ActionContext ctx = ActionContext.getContext();
			Map<String, Object> session = ctx.getSession();
			session.put("username", user.getUsernam());
			session.put("userid", user.getUserid());
			session.put("userkub", user.getUserkub());
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			user.setLogintim(ts);
			userService.update(user);
			return SUCCESS;
		}
		return "not-login";
	}
	public void setUserid(String userid){
		this.userid = userid;
	}
	public String checkUserPassword() {
		if(userid!=null){
			userid = userid.trim();
			user = userService.get(userid);
		}
		if (user != null && loginService.checkUserLogin(user, user.getUsernam(), password)) {
			isPasswordCorrect = true;

		} else {

			isPasswordCorrect = false;
		}
		return SUCCESS;
	}

	public String getLoginPage() {
		return SUCCESS;
	}

	public String getIndexPage() {
		return SUCCESS;
	}
}
