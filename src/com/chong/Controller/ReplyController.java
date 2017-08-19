package com.chong.Controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.chong.entity.Article;
import com.chong.entity.PageBean;
import com.chong.entity.Reply;
import com.chong.service.ArticleService;
import com.chong.service.ReplyService;

@Controller
public class ReplyController {
	 @Resource
	 ReplyService replyService;
	 @Resource
	 ArticleService articleService;
		/**
		 * ��ҳ��ѯreplyҳ��
		 * @return
		 */
	    @RequestMapping(value="admin/doReply")
	    public String reply(@RequestParam int currPage,Model model){
	    	PageBean<Reply> listReply = replyService.findAllReply(currPage);
	    	// ֵ�洢���󶨵�request��
	    	model.addAttribute("listReply",listReply);
	    	return "admin/reply";
	    }
	    @RequestMapping(value="/deleteReply")
	    public String delete(@RequestParam int id){
	    	replyService.delete(id);
	    	System.out.println("ɾ���ɹ�");
	    	return "redirect:admin/doReply?currPage=1";
	    }
	   //��json��ʾ 
	    @RequestMapping(value = "blog/articleShow/reply", method = RequestMethod.GET)  
	    @ResponseBody  
	    public Map<String, Object> saveReply(@RequestParam String content,@RequestParam int article_id) {  
	    	Map<String,Object> map=new HashMap<String,Object>(); 
	    	System.out.println("����getReply");
	    	// ����reply����
	    	Reply reply = new Reply();
	    	// ��ȡ��ǰʱ��
	    	java.util.Date nDate = new java.util.Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String sDate = sdf.format(nDate);
	        java.sql.Date now = java.sql.Date.valueOf(sDate);
	        reply.setContent(content);
	        reply.setTime(now);
	        // ��ȡ����������
	        Article article = articleService.findById(article_id);
	        reply.setArticle(article);
	    	replyService.save(reply);
	    	System.out.print("saveReply()ִ�гɹ�");
	    	map.put("reply", reply);
	      return map;  
	    }
	    
}
