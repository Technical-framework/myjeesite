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
import com.thinkgem.jeesite.modules.bookkeeping.entity.Bills;
import com.thinkgem.jeesite.modules.bookkeeping.service.BillsService;

@Controller
@RequestMapping(value = "${adminPath}/bookkeeping/bills")
public class BillsController extends BaseController {

	@Autowired
	private BillsService billsService;
	
	@ModelAttribute
	public Bills get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return billsService.get(id);
		}else{
			return new Bills();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(Bills bills, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Bills> page = billsService.findPage(new Page<Bills>(request, response), bills); 
        model.addAttribute("page", page);
		return "modules/bookkeeping/billsList";
	}
	
	
	@RequestMapping(value = "form")
	public String form(Bills bills, Model model) {
		
		model.addAttribute("bills", bills);
		return "modules/bookkeeping/billsFrom";
	}
	
	
	@RequestMapping(value = "save")
	public String save(Bills bills, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bills)){
			return form(bills, model);
		}
		billsService.save(bills);
		addMessage(redirectAttributes, "保存成功");
		return "redirect:" + adminPath + "/bookkeeping/list";
	}
	
	
	@RequestMapping(value = "delete")
	public String delete(Bills bills, RedirectAttributes redirectAttributes) {
		billsService.delete(bills);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + adminPath + "/bookkeeping/list";
	}
	
}
