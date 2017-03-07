package cn.jbit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jbit.dao.ClassesDao;
import cn.jbit.pojo.Classes;
import cn.jbit.pojo.Faqs;
import cn.jbit.serivce.FaqsSerivce;
import cn.jbit.util.Page;

@Controller
@RequestMapping("/")
public class FaqsController {
	@Autowired
	@Qualifier("faqsSerivce")
	private FaqsSerivce faqsSerivce;
	
	public void setFaqsSerivce(FaqsSerivce faqsSerivce) {
		this.faqsSerivce = faqsSerivce;
	}
	
	@Autowired
	@Qualifier("classesDao")
	private ClassesDao classesDao;
	
	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}

	@RequestMapping("findAll.do")
	public String findAll(Model model){
		Page page=new Page();
		page.setPageSize(2);
		page.setTotalCount(faqsSerivce.getCount(null));
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startRow", (page.getPageIndex()-1)*page.getPageSize());
		map.put("endRow", page.getPageSize());
		List<Faqs> list=faqsSerivce.findAll(map);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "list";
	}
	
	@RequestMapping("findByTitle.do")
	public String findByTitle(Model model,Page page,Faqs faqs){
		Map<String, Object> map=new HashMap<String, Object>();
		page.setPageSize(2);
		page.setTotalCount(faqsSerivce.getCount(faqs));
		map.put("startRow", (page.getPageIndex()-1)*page.getPageSize());
		map.put("endRow", page.getPageSize());
		map.put("faqs", faqs);
		List<Faqs> list=faqsSerivce.findByTitle(map);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("title", faqs.getTitle());
		return "list";
	}
	
	@RequestMapping("insert.do")
	public String insert(Faqs faqs){
		faqsSerivce.insert(faqs);
		return "redirect:findAll.do";
	}
	
	@RequestMapping("InsertInit.do")
	public String InsertInit(Model model){
		List<Classes> list=classesDao.findAll();
		model.addAttribute("list", list);
		return "add";
	}
	
	@RequestMapping("findById.do")
	public String findById(Integer id,Model model){
		Faqs faqs=faqsSerivce.findById(id);
		model.addAttribute("faqs", faqs);
		List<Classes> list=classesDao.findAll();
		model.addAttribute("list", list);
		return "update";
	}

	@RequestMapping("update.do")
	public String update(Faqs faqs){
		faqsSerivce.update(faqs);
		return "redirect:findAll.do";
	}
	
	@RequestMapping("deleteById.do")
	public String deleteById(Integer id){
		faqsSerivce.deleteById(id);
		return "redirect:findAll.do";
	}
}
