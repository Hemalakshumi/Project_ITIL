package com.itil.service;

import java.util.List;

public interface IEmployeeService {
	
	public Employee findRole(Employee employee);
	public List<Ticket> myTickets(Employee employee);
	public Ticket newTicket();
	public List<Ticket> viewNewTickets();
	public Ticket ticketAssignation();
	public List<Ticket> viewAssignedTickets();
	public Ticket ticketPorcessState();
	
}
