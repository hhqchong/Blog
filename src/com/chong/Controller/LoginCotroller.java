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
	 * ҳ����תǰ̨
	 * @return
	 */
	@RequestMapping(value = "/doHome")
	public String doHome(){
		System.out.println("�ɹ�");
		return "blog/home";
	}
	@RequestMapping(value = "/doArticle")
	public String doArticle(){
		System.out.println("article��¼�ɹ�");
		return "redirect: blog/article";
	}
}
