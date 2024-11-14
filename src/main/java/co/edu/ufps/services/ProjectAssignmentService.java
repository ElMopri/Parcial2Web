package co.edu.ufps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.repositories.ProjectAssignmentRepository;

@Service
public class ProjectAssignmentService {

	@Autowired
	private ProjectAssignmentRepository projectAssignmentRepository;
	

	
	public ProjectAssignment create(ProjectAssignment projectAssignment) {
		return projectAssignmentRepository.save(projectAssignment);
	}
	
}
