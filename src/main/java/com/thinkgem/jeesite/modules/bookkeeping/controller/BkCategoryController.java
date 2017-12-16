package com.thinkgem.jeesite.modules.bookkeeping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.bookkeeping.entity.BkCategory;
import com.thinkgem.jeesite.modules.bookkeeping.service.BkCategoryService;

@Controller
@RequestMapping(value = "${adminPath}/bookkeeping")
public class BkCategoryController extends BaseController {

	@Autowired
	private BkCategoryService bkCategoryService;
	
	@ModelAttribute
	public BkCategory get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return bkCategoryService.get(id);
		}else{
			return new BkCategory();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(BkCategory bkCategory, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<BkCategory> page = bkCategoryService.findPage(new Page<BkCategory>(request, response), bkCategory); 
        model.addAttribute("page", page);
		return "modules/bookkeeping/bkCategoryList";
	}
	
	
	@RequestMapping(value = "form")
	public String form(BkCategory bkCategory, Model model) {
		
		model.addAttribute("bkCategory", bkCategory);
		return "modules/bookkeeping/bkCategoryFrom";
	}
	
	
	@RequestMapping(value = "save")
	public String save(BkCategory bkCategory, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bkCategory)){
			return form(bkCategory, model);
		}
		bkCategoryService.save(bkCategory);
		addMessage(redirectAttributes, "保存成功");
		return "redirect:" + adminPath + "/bookkeeping/list";
	}
	
	
	@RequestMapping(value = "delete")
	public String delete(BkCategory bkCategory, RedirectAttributes redirectAttributes) {
		bkCategoryService.delete(bkCategory);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + adminPath + "/bookkeeping/list";
	}
	
}
