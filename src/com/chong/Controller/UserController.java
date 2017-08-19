package com.chong.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chong.entity.User;
import com.chong.service.UserService;

@Controller
public class UserController {
	
	@Resource //����ע��
    private UserService userService;
	
	@RequestMapping(value="/login")
	public String Login(){
		return "admin/login";
	}
	
	/**
	 * �жϵ�¼
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/doLogin",method = RequestMethod.POST)
	public String doLogin(User user,HttpServletRequest req){
		HttpSession session=req.getSession();
		User existUser = userService.login(user);
		System.out.println("������ҳ��¼�ɹ�");
		if(existUser!=null){
			session.setAttribute("username",existUser.getUsername());
			return "admin/background";
		}
		return "redirect:login";
	}
	
	/**
	 * �˳���¼
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/SignOut")
	public String SignOut(HttpServletRequest req){
		HttpSession session=req.getSession(false);
		session.removeAttribute("username");
		return "redirect:login";
	}
	
	/**
	 * �޸ĸ�����ϵ��Ϣ
	 * @return
	 */
	@RequestMapping(value = "/doModify")
	public String modify(ModelMap map){
		User user = userService.findUser(1);
		map.put("user", user);
		System.out.println("user,���ҳɹ�");
		return "admin/dataModify";
	}
	/**
	 * �޸���ͨ����
	 * @param user
	 * @return
	 */
	@RequestMapping(value= "/updateUser")
	public String updateUserdata(User user){
		User u = userService.findUser(user.getId());
		userService.updateUser(u);
		return "admin/dataModify";
	}
	
	
	/**
	 * ��ѯ������ϵ��Ϣ
	 * @return
	 */
	@RequestMapping(value = "/doUser/{role}/{path}")
	public String doUser(@PathVariable String role,@PathVariable String path,ModelMap map){
		if(role.equals("admin"))
		   return role+"/"+path;  
		else
			return "redirect:login";
	}
	/**
	 * �޸��˺�����
	 * @param user
	 * @return
	 */
	@RequestMapping(value= "/updateUserPassword")
	public String updateUserP(User user){	
		userService.updateUserPassword(user);
		System.out.print("������³ɹ�");
		return "admin/userModify";
	}

	/**
	 * ҳ����תǰ̨
	 * @return
	 */
	@RequestMapping(value = "/doHome")
	public String doHome(){
		return "blog/home";
	}
	@RequestMapping(value = "/doArticle")
	public String doArticle(){
		System.out.println("article��¼�ɹ�");
		return "blog/article";
	}
	
//	@RequestMapping(value = "/doDemo")
//	public String doDemo(){
//		System.out.println("demo��¼�ɹ�");
//		return "blog/demo";
//	
}
