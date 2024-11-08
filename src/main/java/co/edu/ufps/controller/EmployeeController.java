package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Employee;
import co.edu.ufps.entities.Position;
import co.edu.ufps.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
		@PostMapping()
	public ResponseEntity<Employee> create(@RequestBody Employee employee) {
			Employee newEmployee = employeeService.create(employee);
		return ResponseEntity.ok(newEmployee);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Employee> get(@PathVariable Integer id) {
		return ResponseEntity.ok(employeeService.get(id));
	}
	
		@PostMapping("/{id}/agregar_departemento/{funcionId}")
	public ResponseEntity<Employee> create(@PathVariable Integer id, @PathVariable Integer departmentId) {
			Employee newEmployee = employeeService.addDepartment(id, departmentId);
		return ResponseEntity.ok(newEmployee);
	}
	
}
