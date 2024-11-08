package co.edu.ufps.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Project;
import co.edu.ufps.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository ProjectRepository;
	
	public List<Project> list(){
		return ProjectRepository.findAll();
	}
	
	public Project update(Integer id, Project projectDetails) {
		Optional<Project> projectOpt = ProjectRepository.findById(id);

		if (!projectOpt.isPresent()) {
			return null;
		}

		Project project = projectOpt.get();
		project.setName(projectDetails.getName());
		project.setDescription(projectDetails.getDescription());
		project.setStart_date(projectDetails.getStart_date());

		return ProjectRepository.save(project);
	}
	
}
