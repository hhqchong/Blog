package com.chong.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginCotroller {
	@RequestMapping("/Login")
      public String Login(){
		System.out.println("haha");
    	  return "redirect:blog/home";
      }
	/**
	 * 页面跳转前台
	 * @return
	 */
	@RequestMapping(value = "/doHome")
	public String doHome(){
		System.out.println("成功");
		return "blog/home";
	}
	@RequestMapping(value = "/doArticle")
	public String doArticle(){
		System.out.println("article登录成功");
		return "redirect: blog/article";
	}
}
