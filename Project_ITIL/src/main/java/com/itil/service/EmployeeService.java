package com.itil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	Itil_dao itil_dao;
	
	@Override
	public Employee findRole(Employee employee) {
		
		return itil_dao.searchEmployeeDetails(employee.getemployeeName(),employee.getemployeePassword());
	
		 
	}

	@Override
	public List<Ticket> myTickets(Employee employee) {
		
		return itil_dao.viewTicketDetails(employee.getEmployeeId());
		
	}

	@Override
	public Ticket newTicket() {
		// TODO Auto-generated method stub
		return itil_dao.
	}

	@Override
	public List<Ticket> viewNewTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket ticketAssignation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> viewAssignedTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket ticketPorcessState() {
		// TODO Auto-generated method stub
		return null;
	}

}
