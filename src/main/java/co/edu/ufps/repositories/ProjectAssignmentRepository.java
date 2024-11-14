package co.edu.ufps.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.entities.Project;
import co.edu.ufps.entities.ProjectAssignment;

public interface ProjectAssignmentRepository extends JpaRepository<ProjectAssignment,Integer>{
	
	//public List<ProjectAssignment> findAllByProject_id(Project project_id);
	
	//public boolean existsByProject_id(Project project_id);
	
}
