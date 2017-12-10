package com.thinkgem.jeesite.modules.demo.controller;

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
import com.thinkgem.jeesite.modules.demo.entity.DemoUser;
import com.thinkgem.jeesite.modules.demo.service.DemoUserService;
import com.thinkgem.jeesite.modules.home.entity.HomeTest;

@Controller
@RequestMapping(value = "${adminPath}/demo")
public class DemoUserController extends BaseController {

	@Autowired
	private DemoUserService demoUserService;
	
	/**
	 * 公用的方法Get
	 * @param id
	 * @return
	 */
	@ModelAttribute
	public DemoUser get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return demoUserService.get(id);
		}else{
			return new DemoUser();
		}
	}
	
	/**
	 * 查询分页
	 * @param demoUser
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"list", ""})
	public String list(DemoUser demoUser, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<DemoUser> page = demoUserService.findPage(new Page<DemoUser>(request, response), demoUser); 
        model.addAttribute("page", page);
		return "modules/demo/demoUserList";
	}
	
	/**
	 * 添加
	 * @param demoUser
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "form")
	public String form(DemoUser demoUser, Model model) {
		if(demoUser.getId() != null && !"".equals(demoUser.getId())){
			demoUser = demoUserService.get(demoUser.getId());
		}
		model.addAttribute("demoUser", demoUser);
		return "modules/demo/demoUserFrom";
	}
	
	/**
	 * 保存
	 * @param demoUser
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "save")
	public String save(DemoUser demoUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, demoUser)){
			return form(demoUser, model);
		}
		demoUserService.save(demoUser);
		addMessage(redirectAttributes, "保存成功");
		return "redirect:" + adminPath + "/demo/list";
	}
	
	/**
	 * 删除
	 * @param demoUser
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "delete")
	public String delete(DemoUser demoUser, RedirectAttributes redirectAttributes) {
		demoUserService.delete(demoUser);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + adminPath + "/demo/list";
	}
	
}
