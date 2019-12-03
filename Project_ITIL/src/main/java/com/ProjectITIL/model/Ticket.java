package com.ProjectITIL.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ticket")
public class Ticket implements Serializable {
	 
	 
	  @Id
	  @Column(name = "ticket_Id", length = 5)
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int ticketId;
	  
	  @Column(name = "description", length = 15)
	  private String description; 
	  
	  @Column(name = "ticket_Type", length = 15)
	  private String ticketType ;  
	  
	  
	   @Column (name = "employee_Id")
	  private int employeeId;
	  
	  public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	@Column(name = "team_Member", length = 15)
	  private String teamMember;
	     
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	
	public String getTeamMember() {
		return teamMember;
	}
	public void setTeamMember(String teamMember) {
		this.teamMember = teamMember;
	}
		

}
