package com.ProjectITIL.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ProjectITIL.Exception.ResourceNotFoundException;
import com.ProjectITIL.model.Employee;
import com.ProjectITIL.model.Ticket;
import com.ProjectITIL.service.IEmployeeService;

@SessionAttributes("employee")
@RestController
public class EmployeeController {

	@Autowired
	public IEmployeeService employeeService;



	@ModelAttribute("employee")
	public Employee setUpLoginForm() {
		return new Employee();
	}

	@RequestMapping("/first")
	public ModelAndView welcome() {
		ModelAndView modelAndView=new ModelAndView("Welcome");
		return modelAndView;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView=new ModelAndView("Login");
		return modelAndView;
	}


	@GetMapping(value="/loginForm")
	public ModelAndView loginOperation(@Valid @ModelAttribute("employee") Employee employee1, BindingResult bindingResult)   throws ResourceNotFoundException {
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView=new ModelAndView("Login");
			return modelAndView;
        }
		Employee employee2= employeeService.findRole(employee1);
		String employeeRole=employee2.getEmployeeRole();
		ModelAndView modelAndView1=null;
		if(employeeRole.equals("Employee"))
		{
			modelAndView1=new ModelAndView("Employee");
			return modelAndView1;
		}

		else if(employeeRole.equals("Gatekeeper"))

		{
			modelAndView1=new ModelAndView("gatekeeper");
			return modelAndView1;
		}


		else if(employeeRole.equals("Team member"))
		{
			modelAndView1=new ModelAndView("Teammember");
			return modelAndView1;	
		}

		else 
			return null;


	}


	/*@RequestMapping(value="/ViewTickets", method=RequestMethod.GET)
	public ModelAndView viewTicketOperation(@SessionAttribute("employee") Employee employee,Model model) {
		List<Ticket> ticketList = employeeService.myTickets(employee.getEmployeeId());

		ModelAndView view = new ModelAndView("ViewTicketForm");
		model.addAttribute("ticketList", ticketList);
		return view;
	}*/
	@RequestMapping("/view")
	public ModelAndView viewTickets() {
		ModelAndView modelAndView=new ModelAndView("ViewTickets");
		return modelAndView;
	}
	
	@RequestMapping(value="/ViewTickets", method=RequestMethod.GET)
	public ModelAndView viewTicketOperation(@ModelAttribute("Ticket") Ticket ticket,Model model)   throws ResourceNotFoundException {
		List<Ticket> ticketList = employeeService.myTickets(ticket.getEmployeeId());
System.out.println(ticketList);
		ModelAndView view = new ModelAndView("ViewTicketForm");
		model.addAttribute("ticketList", ticketList);
		return view;
	}
	
	@RequestMapping("/RaiseNewTickets")
	public ModelAndView RaiseNewTickets() {
		ModelAndView modelAndView=new ModelAndView("RaiseNewTickets");
		return modelAndView;
	}


	@RequestMapping(value="/NewTickets", method=RequestMethod.GET)
	public ModelAndView raiseNewTicketOperation(@ModelAttribute("tickets") Ticket ticket)throws ResourceNotFoundException{
	
		employeeService.newTicket(ticket);

		return new ModelAndView("Success");
	}

}
