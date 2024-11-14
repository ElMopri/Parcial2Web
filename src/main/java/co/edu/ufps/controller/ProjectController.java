package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Project;
import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.services.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping
	public ResponseEntity<List<Project>> list() {
		return ResponseEntity.ok(projectService.list());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Project> update(@PathVariable Integer id, @RequestBody Project projectDetails) {
		Project updatedProject = projectService.update(id, projectDetails);
		return ResponseEntity.ok(updatedProject);
	}
	
		@GetMapping("/{id}/get_project_assignment")
	public ResponseEntity<List<ProjectAssignment>> getProjectAssignment(@PathVariable Integer id) {
		return ResponseEntity.ok(projectService.get(id).getProjectAssignment());
	}
}
