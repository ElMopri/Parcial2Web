package co.edu.ufps.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Department;
import co.edu.ufps.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department get(Integer id) {
		Optional<Department> departmentOpt = departmentRepository.findById(id);
		if (departmentOpt.isPresent()) {
			return departmentOpt.get();
		}
		return null;
	}
	
}
