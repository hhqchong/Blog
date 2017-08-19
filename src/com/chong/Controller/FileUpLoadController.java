package com.chong.Controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.chong.entity.Demo;
import com.chong.entity.PageBean;
import com.chong.service.FileUploadService;


@Controller
public class FileUpLoadController {
	@Resource
	private FileUploadService demoService;

	/**
	 * ��ҳ��ѯ����Demo
	 * @param currPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doDemo/{role}/{currPage}")
	public String demo(@PathVariable int currPage,@PathVariable String role, Model model) {
		if (currPage < 1) {
			currPage = 1;
		}
		// ��ѯ��ǰչʾҳ������Ϣ
		PageBean<Demo> listDemo = demoService.findAll(currPage);
		// ֵ�洢���󶨵�request��
		model.addAttribute("listDemo", listDemo);
		return role+"/demo";
	}
	/**
	 * �ϴ�ͼƬ
	 * @param demo
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	private String fildUpload(Demo demo, @RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) throws Exception {
		// �������·��webapp����·��
		String pathRoot = request.getSession().getServletContext().getRealPath("");
		String path = "";
		if (!file.isEmpty()) {
			String imageName = file.getOriginalFilename();
			path = "/style/img/"+ imageName;
			System.out.println("imaageName:"+path);
			file.transferTo(new File(pathRoot + path));
		}
		// ��path���浽���ݿ�
		demo.setUrl(path);
		demoService.save(demo);
		request.setAttribute("imagesPath", path);
		return "admin/demoPublish";
	}
	
	@RequestMapping(value = "admin/doDemoPublish")
	public String godemoPublish() {
		return "admin/demoPublish";
	}
	
	/**
	 * ɾ��demo��static�е�img
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteFile")
	public String deleteById(@RequestParam int file_id,HttpServletRequest request ) {
		Demo demo = demoService.findById(file_id);	
		// �������·��webapp����·��
	    String pathRoot = request.getSession().getServletContext().getRealPath("");
	    File file = new File(pathRoot+demo.getUrl());
	    if(file.isFile() && file.exists()){
	    	file.delete();//"ɾ�������ļ�"
	    	System.out.println("ͼƬɾ���ɹ�");
	    }
        demoService.delete(demo);
		return "admin/doDemo?currPage=1";
	}
	
	/*ǰ̨*/
	/**
	 * ��ѯ����demo
	 */
	@RequestMapping(value="/doDemo")
	public String listdemo(ModelMap map){
		List<Demo> list = demoService.findAllDemo();
		map.put("list", list);
		return "blog/demo";
	}
	/**
	 * ��ʾ��ǰdemo
	 */
	@RequestMapping(value="/demo/show")
	public String showDemo(ModelMap map,@RequestParam int id){
		Demo demo = demoService.findById(id);
		map.put("demo", demo);
		return "blog/demoShow";
	}
}
