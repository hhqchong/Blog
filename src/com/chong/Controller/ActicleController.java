package com.chong.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chong.entity.Article;
import com.chong.entity.ArticleType;
import com.chong.entity.PageBean;
import com.chong.entity.Reply;
import com.chong.service.ArticleService;
import com.chong.service.ArticleTypeService;
import com.chong.service.ReplyService;
@Controller
public class ActicleController {
	@Resource
	private ArticleService articleService;
	@Resource
	private ArticleTypeService articleTypeService;
	@Resource
	private ReplyService replyService;
	/**
	 * ��ҳ��ѯ��������
	 * @param currPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "admin/doMarticle")
	public String findAllArticle(@RequestParam int currPage,Model model){ //
		if(currPage<1){
		   	currPage = 1;
		}
		// ��ѯ��ǰչʾҳ������Ϣ
		PageBean<Article> listArticle = articleService.findAll(currPage);
		// ��ѯ���з���
		List<ArticleType> typeList = articleTypeService.findAllType();
		// ֵ�洢���󶨵�request��
		model.addAttribute("listArticle",listArticle);
		model.addAttribute("typeList", typeList);
		// System.out.println(listArticle.getCurrPage()+":"+listArticle.getTotalCount()+":"+listArticle.getList().get(0).getContent());
		return "admin/mArticle";
	}
	/**
	 * modelAttribute��������springmvc controllerִ��֮ǰִ��
	 * @param id
	 * @param map
	 */
	@ModelAttribute  
	public void getArticle(@RequestParam(value="id",required=false) Integer id,   
	        Map<String, Object> map){  
	    System.out.println("modelAttribute method");  
	    if(id != null){  
	        //ģ������ݿ��л�ȡ����  
	        Article article = articleService.findById(id); 
	        System.out.println("�����ݿ��л�ȡһ������: " + article);  
	          
	        map.put("article", article); 
	    }  
	}
	/**
	 * �������£�����ֱ�ӻ�ȡ����ı�Ĳ���
	 * @param article
	 * @param articletype
	 * @return
	 */
	@RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
	public String updateArticle(Article article,@RequestParam int articletype){
		// ��ȡ���º��selectֵarticletype
		System.out.println("typeId:"+articletype);
		// ����selectֵ
		article.getArticletype().setId(articletype);
		System.out.println("title:"+article.getTitle());
		// ����article
		articleService.update(article);
		return "redirect:admin/doMarticle?currPage=1";
	}
	/**
	 * ��ת���༭����ҳ�棬Marticleҳ���е���༭
	 * @param article_id url����Ĳ���
	 * @return
	 */
	@RequestMapping(value = "/doPublish")
	public String editArticle(@RequestParam int article_id,ModelMap map){
		// ��������id��ѯ
		Article article = articleService.findById(article_id);
		map.put("article",article);
		map.put("articletype", article.getArticletype());
		System.out.println("�������id:"+article.getArticletype().getId());
		// ��ѯ�������·���
		List<ArticleType> typeList = articleTypeService.findAllType();
		map.put("typeList",typeList);
		return "admin/updateArticle";
	}
	/**
	 * ɾ������
	 * @param article_id
	 * @return
	 */
    @RequestMapping(value = "/doDelete")
    public String delete(@RequestParam int article_id){
    	Article article = articleService.findById(article_id);
    	articleService.delete(article);
    	System.out.println("ɾ���ɹ�");
    	return "redirect:admin/doMarticle?currPage=1";
    }
	/**
	 * �첽Ո��article����blog/article.jsp����ʾ����
	 * 
	 * @return
	 */
	@RequestMapping(value = "blog/article")
	@ResponseBody
	public Map<String, Object> listArticle(@RequestParam int currPage) {
		System.out.println("�M��json");
		Map<String, Object> map = new HashMap<String, Object>();
		PageBean<Article> listArticle = articleService.findAll(currPage);
		// ֵ�洢���󶨵�request��
		map.put("listArticle", listArticle);
		System.out.println("jsonՈ��ɹ�");
		return map;
	}

	/**
	 * �첽����articleShow���鿴ĳ�����µ�����
	 */
	@RequestMapping(value = "/blog/articleShow/{id}")
	public String article(@PathVariable int id, ModelMap map) {
		Article article = articleService.findById(id);
		List<Reply> listReply = replyService.findReply(id);
		System.out.println(article);
		System.out.println(listReply);
		// ֵ�洢���󶨵�request��
		map.put("article", article);
		map.put("listReply", listReply);
		System.out.println("articlesՈ��ɹ�");
		return "blog/articleShow";
	}
}
