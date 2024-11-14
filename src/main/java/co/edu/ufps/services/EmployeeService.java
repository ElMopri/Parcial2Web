package co.edu.ufps.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Department;
import co.edu.ufps.entities.Employee;
import co.edu.ufps.repositories.DepartmentRepository;
import co.edu.ufps.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee get(Integer id) {
		Optional<Employee> SelecionOpt = employeeRepository.findById(id);
		if (SelecionOpt.isPresent()) {
			return SelecionOpt.get();
		}
		return null;
	}

	public Employee addDepartment(Integer id, Integer departmentId) {
		Optional<Employee> employeeOpt = employeeRepository.findById(id);
		if (employeeOpt.isPresent()) {
			Employee employee = employeeOpt.get();
			Optional<Department> departmentOpt = departmentRepository.findById(departmentId);
			if (departmentOpt.isPresent()) {
				employee.addDepartment(departmentOpt.get());
			}
			return employeeRepository.save(employee);
		}
		return null;
	}

	public Employee removeDepartment(Integer id, Integer funcionId) {
		Optional<Employee> employeeOpt = employeeRepository.findById(id);
		if (employeeOpt.isPresent()) {
			Employee employee = employeeOpt.get();
			Optional<Department> departmentOpt = departmentRepository.findById(funcionId);
			if (departmentOpt.isPresent()) {
				employee.removeDepartment(departmentOpt.get());
			}
			return employeeRepository.save(employee);
		}
		return null;
	}

}
