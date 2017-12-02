/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test1.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.result.JsonResult;
import com.thinkgem.jeesite.common.result.TableJson;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.test1.entity.TestStudent;
import com.thinkgem.jeesite.modules.test1.service.TestStudentService;

/**
 * 学生Controller
 * @author yangqinghua
 * @version 2016-01-03
 */
@Controller
@RequestMapping(value = "${adminPath}/test1/testStudent")
public class TestStudentController extends BaseController {

	@Autowired
	private TestStudentService testStudentService;
	
	@ModelAttribute
	public TestStudent get(@RequestParam(required=false) String id) {
		TestStudent entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = testStudentService.get(id);
		}
		if (entity == null){
			entity = new TestStudent();
		}
		return entity;
	}
	
	@RequiresPermissions("test1:testStudent:view")
	@RequestMapping(value = {"list", ""})
	public String list(TestStudent testStudent, HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/test1/testStudentList";
	}
	
	@RequiresPermissions("test1:testStudent:view")
	@RequestMapping(value = { "jsonList" })
	public @ResponseBody TableJson<TestStudent> getTableData(TestStudent testStudent, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<TestStudent> page = testStudentService.findPage(new Page<TestStudent>(request, response), testStudent);
		return new TableJson<TestStudent>(page);
	}

	@RequiresPermissions("test1:testStudent:view")
	@RequestMapping(value = "form")
	public String form(TestStudent testStudent, Model model) {
		model.addAttribute("testStudent", testStudent);
		return "modules/test1/testStudentForm";
	}

	@RequiresPermissions("test1:testStudent:edit")
	@RequestMapping(value = "save")
	public @ResponseBody Object save(TestStudent testStudent, Model model, JsonResult jsonResult, HttpServletRequest request) {
		try {
			if (!beanValidator(model, testStudent)){
				jsonResult.setSuccess(false);
				jsonResult.setMessage(model.asMap().get("message").toString());
				return jsonResult;
			}
			testStudentService.save(testStudent);
			jsonResult.setSuccess(true);
		} catch (Exception e) {
			logger.error("保存失败:{}", e.getMessage());
			jsonResult.setSuccess(false);
			jsonResult.setMessage("保存失败");
		}
		return jsonResult;
	}
	
	@RequiresPermissions("test1:testStudent:edit")
	@RequestMapping(value = "delete")
	public @ResponseBody Object delete(String ids, JsonResult jsonResult) {
		String[] idString = ids.split(",");
		try {
			for (int i = 0; i < idString.length; i++) {
				String id = idString[i];
				TestStudent testStudent = new TestStudent();
				testStudent.setId(id);
				testStudentService.delete(testStudent);
			}
			jsonResult.setSuccess(true);
		} catch (Exception e) {
			logger.error("删除错误", e.getMessage());
			jsonResult.setSuccess(false);
			jsonResult.setMessage("删除失败");
		}
		return jsonResult;
	}

}