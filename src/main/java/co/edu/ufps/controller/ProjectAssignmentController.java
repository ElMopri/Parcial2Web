package co.edu.ufps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.services.ProjectAssignmentService;

@RestController
@RequestMapping("/project_assignment")
public class ProjectAssignmentController {

		@Autowired
	private ProjectAssignmentService projectAssignmentService;
		
	@PostMapping()
	public ResponseEntity<ProjectAssignment> create(@RequestBody ProjectAssignment projectAssignment) {
		ProjectAssignment newProjectAssignment = projectAssignmentService.create(projectAssignment);
		return ResponseEntity.ok(newProjectAssignment);
	}
	
}
