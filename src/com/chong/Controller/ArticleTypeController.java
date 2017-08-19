package com.chong.Controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import com.chong.entity.ArticleType;
import com.chong.entity.PageBean;
import com.chong.service.ArticleTypeService;
@Controller
public class ArticleTypeController {
	   @Resource
       ArticleTypeService articleTypeService;
		@RequestMapping(value = "admin/doPublish")
		public String findAllType(ModelMap map){
			List<ArticleType> typeList = articleTypeService.findAllType();
			map.put("typeList", typeList);
			return "admin/publish";
		}
	   /**
		 * ��ҳ����catagory
		 * @param currPage
		 * @param model
		 * @return
		 */
		@RequestMapping(value = "admin/doCatagory")
		public String findAllArticleType(@RequestParam int currPage,Model model){
			PageBean<ArticleType> listType = articleTypeService.findAll(currPage);
			model.addAttribute("listType", listType);
			return "admin/catagory";
		}
		/**
		 * ������� ���༭���ڱ�������ת
		 * @param at
		 * @return
		 */
		@RequestMapping(value="/updateArticleT")
		public String goUpdate(ArticleType at){
			System.out.println("id:"+at.getId()+",type:"+at.getType());
			articleTypeService.update(at);
			return "redirect:admin/doCatagory?currPage=1";
		}
		 /**
	     * ɾ���������
	     * @param articletype_id
	     * @return
	     */
	    @RequestMapping(value = "/deleteArticleT")
	    public String delete(@RequestParam int articletype_id){
	    	ArticleType at = articleTypeService.findById(articletype_id);
	    	articleTypeService.delete(at);
	    	return "redirect:admin/doCatagory?currPage=1";
	    }
	    /**
		 * ����������
		 * @param at
		 * @return
		 */
	    @RequestMapping(value= "/addCatagory")
	    public String addCatagory(ArticleType at){
	    	articleTypeService.save(at);
	    	return "redirect:admin/doCatagory?currPage=1";
	    }
}
