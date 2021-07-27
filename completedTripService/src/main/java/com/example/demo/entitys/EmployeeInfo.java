package com.example.demo.entitys;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="employee")
public class EmployeeInfo {
	@Id
 String employeeId;
 String EmployeeName;
 String EmployeeMail;
 long EmployeeNumber;
 String domainlead;
 String projectName;
 String projectLead;
 int isAdmin;
 int isBlocked;
 LocalDate blocked;
 String createdBy;
 String modifiedBy;
 String modifieddate;
 String deleted;
 
 
 
 
}
