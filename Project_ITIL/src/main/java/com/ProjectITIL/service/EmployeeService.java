package com.ProjectITIL.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectITIL.dao.Itil_dao;
import com.ProjectITIL.dao.Ticket_dao;
import com.ProjectITIL.model.Employee;
import com.ProjectITIL.model.Ticket;


@Service
public class EmployeeService implements IEmployeeService {

@Autowired
public Itil_dao itil_dao;
@Autowired
public Ticket_dao ticket_dao;

@Override
public Employee findRole(Employee employee) {

	System.out.println(employee.getEmployeeName()+employee.getPassword());
	
return this.itil_dao.findByEmployeeNameAndPassword(employee.getEmployeeName(),employee.getPassword());


}

@Override
public List<Ticket> myTickets(int employeeId) {
	
	return this.ticket_dao.findByEmployeeId(employeeId);
}
@Transactional
@Override
public Ticket newTicket(Ticket ticket) {
	
	String var="New Ticket";
	
	Ticket ticket1=ticket_dao.save(ticket);
	int i=ticket_dao.updateEmployee(var, ticket.getEmployeeId());
	return ticket1;
			

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

/*@Override
public List<Ticket> myTickets(int employeeId) {
	return ticket_dao.findByEmployeeID(employeeId);

//return itil_dao.viewTicketDetails(employee.getEmployeeId());

}

@Override
public Ticket newTicket(Ticket ticket) {
// TODO Auto-generated method stub
return null;
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
*/
}
