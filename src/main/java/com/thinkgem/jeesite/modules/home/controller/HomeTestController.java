package com.thinkgem.jeesite.modules.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.home.entity.HomeTest;
import com.thinkgem.jeesite.modules.home.service.HomeTestService;
import com.thinkgem.jeesite.modules.sys.entity.Dict;

@Controller
@RequestMapping(value = "${adminPath}/home/test")
public class HomeTestController extends BaseController {
	
	@Autowired
	private HomeTestService homeTestService;
	
	@ModelAttribute
	public HomeTest get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return homeTestService.get(id);
		}else{
			return new HomeTest();
		}
	}
	
	/**
	 * 列表分页
	 * @param homeTest
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"list", ""})    ///home/test/list
	public String list(HomeTest homeTest, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<HomeTest> page = homeTestService.findPage(new Page<HomeTest>(request, response), homeTest); 
        model.addAttribute("page", page);
		return "modules/home/homeTestList";
	}
	
	/**
	 * 点击新增后台调整用
	 * @param homeTest
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "form")
	public String form(HomeTest homeTest, Model model) {
		if(homeTest.getId() != null && !"".equals(homeTest.getId())){
			homeTest = homeTestService.get(homeTest.getId());
		}
		model.addAttribute("homeTest", homeTest);
		return "modules/home/testForm";
	}
	
	/**
	 * 新增保存方法
	 * @param homeTest
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "save")
	public String save(HomeTest homeTest, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, homeTest)){
			return form(homeTest, model);
		}
		homeTestService.save(homeTest);
		addMessage(redirectAttributes, "保存成功");
		return "redirect:" + adminPath + "/home/test/list";
	}
	
	/**
	 * 根据ID删除
	 * @param homeTest
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "delete")
	public String delete(HomeTest homeTest, RedirectAttributes redirectAttributes) {
		homeTestService.delete(homeTest);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + adminPath + "/home/test/list";
	}
	
}
