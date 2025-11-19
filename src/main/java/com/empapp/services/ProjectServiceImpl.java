package com.empapp.services;

import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.empapp.model.Project;
import com.empapp.model.ProjectDto;
import com.empapp.repository.IProjectRepository;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private IProjectRepository projectRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public void addProject(ProjectDto projectDto) {
		Project project = mapper.map(projectDto, Project.class);
		projectRepository.save(project);

	}

	@Override
	public void updateProject(ProjectDto projectDto) {
		Project project = mapper.map(projectDto, Project.class);
		projectRepository.save(project);
	}

	@Override
	public void deleteProject(int projectId) {
		projectRepository.deleteById(projectId);

	}

	@Override
	public ProjectDto getById(int projectId) {
		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new RuntimeException("invalid project"));
		return mapper.map(project, ProjectDto.class);
	}

}
