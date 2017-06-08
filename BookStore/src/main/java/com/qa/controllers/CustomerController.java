package com.qa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.qa.models.Customer;
import com.qa.services.CustomerService;


@Controller
@SessionAttributes({"loggedInCustomer"})
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	
	@ModelAttribute("loggedInCustomer")
	public Customer loggedInCustomer() {
		Customer defaultCust = new Customer();
		defaultCust.setFirstName("Not logged in");
		return defaultCust;
	}
	
	@RequestMapping("/loginPage")
	public String loginPage() {
		return "loginPage";
	}
	
	@RequestMapping("/registrationPage")
	public String registrationPage() {
		return "registration";
	}
	
	@RequestMapping("/register")
	public String registrationProcess(@ModelAttribute Customer c) {
		System.out.println("String" + c);
	
		Boolean doesEmailExist = customerService.getCustomerByEmail(c.getEmail()) != null;
		
		if(!c.getFirstName().equals("") && !c.getLastName().equals("") && !c.getEmail().equals("") && !c.getPassword().equals("")  && !doesEmailExist) {
			System.out.println("valid Input");
			customerService.createCustomerRecord(c);
			return "reg_success";
		}
		else {
			System.out.println("Invalid input");
			return "reg_failed";
		}
	}
	@RequestMapping("/validate")
	public ModelAndView login(@RequestParam("email")String email, @RequestParam("password")String password){
		
		
		Customer c = customerService.login(email, password);
		if (c!=null) {
			Customer c2 = customerService.getCustomerByEmail(email);
			ModelAndView mv = new ModelAndView("loginSuccess", "loggedInCustomer", c2);
			return mv;
		}
		else {
			Customer c3 = new Customer();
			ModelAndView mv = new ModelAndView("loginFailed", "loggedInCustomer", c3);
			return mv;
		}
	}
	
//	@RequestMapping("/logout")
//	public ModelAndView logout() {
//		
//		ModelAndView mv = new ModelAndView("logOutSuccessful", defaultCust);
//		mv.addObject(attributeValue)
//		
//		
//	}

//	@RequestMapping("/updateAccount")
//	public ModelAndView updateUserDetails(@ModelAttribute Customer c) {
//		customerService.updateFirstNameById(c.getId(), c.getFirstName());
//		customerService.updateLastNameById(c.getId(), c.getLastName());
//		customerService.updateEmailById(c.getId(), c.getEmail());
//		customerService.updatePasswordById(c.getId(), c.getPassword());
//		Customer updatedCust = customerService.getCustomerById(c.getId());
//		ModelAndView mv = new ModelAndView("", "loggedInCustomer", updatedCust);
//		return mv;
//	}
	
	@RequestMapping("/userDetails")
	public ModelAndView viewUserDetails(@ModelAttribute ("loggedInCustomer") Customer c) {
		System.out.println("c" + c);
		Customer customer = customerService.getCustomerById(c.getId());
		System.out.println("user" + customer);
		ModelAndView mv = new ModelAndView("userDetails", "loggedInCustomer", customer);
		return mv;
	}
	
	@RequestMapping("/updateFirstName")
	public ModelAndView updateFirstNameById(@RequestParam("id") int id, @RequestParam("firstName") String firstName) {
		System.out.println("id" + id + "name" + firstName);
		int i = customerService.updateFirstNameById(id, firstName);
		System.out.println("i" + i);
		Customer customer = customerService.getCustomerById(id);
		ModelAndView mv = new ModelAndView("userDetails", "loggedInCustomer", customer);
		return mv;
	}
	
	@RequestMapping("/updateLastName")
	public ModelAndView updateLastNameById(@RequestParam("id") int id, @RequestParam("lastName") String lastName) {
		System.out.println("id" + id + "lname" + lastName);
		int i = customerService.updateLastNameById(id, lastName);
		System.out.println("i" + i);
		Customer customer = customerService.getCustomerById(id);
		ModelAndView mv = new ModelAndView("userDetails", "loggedInCustomer", customer);
		return mv;
	}
	
	@RequestMapping("/updateEmail")
	public ModelAndView updateEmailById(@RequestParam("id") int id, @RequestParam("email") String email) {
		System.out.println("id" + id + "email" + email);
		int i = customerService.updateEmailById(id, email);
		System.out.println("i" + i);
		Customer customer = customerService.getCustomerById(id);
		ModelAndView mv = new ModelAndView("userDetails", "loggedInCustomer", customer);
		return mv;
	}
	
	@RequestMapping("/updatePassword")
	public ModelAndView updatePasswordById(@RequestParam("id") int id, @RequestParam("password") String password) {
		System.out.println("id" + id + "password" + password);
		int i = customerService.updatePasswordById(id, password);
		System.out.println("i" + i);
		Customer customer = customerService.getCustomerById(id);
		ModelAndView mv = new ModelAndView("userDetails", "loggedInCustomer", customer);
		return mv;
	}
	
	
	
	
}
