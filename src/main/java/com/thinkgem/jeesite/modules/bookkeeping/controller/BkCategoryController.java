package com.thinkgem.jeesite.modules.bookkeeping.controller;

import java.util.Date;
import java.util.List;

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
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

@Controller
@RequestMapping(value = "${adminPath}/bookkeeping/category")
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
		
		//查询条件初始化数据
		BkCategory bkCategoryBase = new BkCategory();
		bkCategoryBase.setParentId(0);
		List<BkCategory> baseList = bkCategoryService.findList(bkCategoryBase);
		model.addAttribute("baseList", baseList);
		
		//查询列表分页数据
        Page<BkCategory> page = bkCategoryService.findPage(new Page<BkCategory>(request, response), bkCategory);
        
//        List<BkCategory> list = page.getList();
//        for(BkCategory bkc : list){
//        	BkCategory bkcObj = new BkCategory();
//        	if(bkc.getParentId() != null && bkc.getParentId() > 0){
//        		bkcObj = this.get(bkc.getParentId().toString());
//        	}
//        	bkc.setParentName(bkcObj.getName());
//        }
        
        model.addAttribute("page", page);
        
        //查询参数，返回，用于做条件默认
        model.addAttribute("bkCategory",bkCategory);
        
		return "modules/bookkeeping/bkCategoryList";
	}
	
	
	@RequestMapping(value = "form")
	public String form(BkCategory bkCategory, Model model) {
		if(bkCategory.getId() != null && !"".equals(bkCategory.getId())){
			bkCategory = this.get(bkCategory.getId());
		}
		model.addAttribute("bkCategory", bkCategory);
		return "modules/bookkeeping/bkCategoryFrom";
	}
	
	
	@RequestMapping(value = "save")
	public String save(BkCategory bkCategory, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bkCategory)){
			return form(bkCategory, model);
		}
		bkCategory.setGmtCreate(new Date());
		bkCategory.setCreateUser(Integer.valueOf(UserUtils.getUser().getId()));
		bkCategoryService.save(bkCategory);
		addMessage(redirectAttributes, "保存成功");
		return "redirect:" + adminPath + "/bookkeeping/category/list";//保存成功，重定向调用list方法刷新列表
	}
	
	
	@RequestMapping(value = "delete")
	public String delete(BkCategory bkCategory, RedirectAttributes redirectAttributes) {
		bkCategoryService.delete(bkCategory);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + adminPath + "/bookkeeping/category/list";
	}
	
}
