package com.adarsh.spring.controller;

import com.adarsh.spring.bean.EmployeeBean;
import com.adarsh.spring.entity.Employee;
import com.adarsh.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 31/1/2015 00:11 AM#
 */
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") EmployeeBean employeeBean, 
			BindingResult result) {
		final Employee employee = this.prepareModel(employeeBean);
		this.employeeService.addEmployee(employee);
		return new ModelAndView("redirect:/add.do");
	}

	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListOfBean(employeeService.listEmployees()));
		return new ModelAndView("employeesList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListOfBean(employeeService.listEmployees()));
		return new ModelAndView("addEmployee", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result) {
		employeeService.deleteEmployee(prepareModel(employeeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		model.put("employees",  prepareListOfBean(employeeService.listEmployees()));
		return new ModelAndView("addEmployee", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", prepareEmployeeBean(employeeService.getEmployee(employeeBean.getId())));
		model.put("employees",  prepareListOfBean(employeeService.listEmployees()));
		return new ModelAndView("addEmployee", model);
	}
	
	private Employee prepareModel(EmployeeBean employeeBean){
		Employee employee = new Employee();
		employee.setEmpAddress(employeeBean.getAddress());
		employee.setEmpAge(employeeBean.getAge());
		employee.setEmpName(employeeBean.getName());
		employee.setSalary(employeeBean.getSalary());
		employee.setEmpId(employeeBean.getId());
		employeeBean.setId(null);
		return employee;
	}
	
	private List<EmployeeBean> prepareListOfBean(final List<Employee> employees){
		List<EmployeeBean> beans = null;
		if(employees != null && !employees.isEmpty()){
			beans = new ArrayList<EmployeeBean>();
			EmployeeBean bean = null;
			for(final Employee employee : employees){
				bean = new EmployeeBean(){
					{
						setName(employee.getEmpName());
						setId(employee.getEmpId());
						setAddress(employee.getEmpAddress());
						setSalary(employee.getSalary());
						setAge(employee.getEmpAge());
					}
				};
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private EmployeeBean prepareEmployeeBean(final Employee employee){
		return new EmployeeBean(){
			{
				setAddress(employee.getEmpAddress());
				setAge(employee.getEmpAge());
				setName(employee.getEmpName());
				setSalary(employee.getSalary());
				setId(employee.getEmpId());
			}
		};
	}
}
