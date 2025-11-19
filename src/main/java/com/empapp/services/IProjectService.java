package com.empapp.services;

import com.empapp.model.ProjectDto;

public interface IProjectService {

	// CRUD operation
	void addProject(ProjectDto projectDto);

	void updateProject(ProjectDto projectDto);

	void deleteProject(int projectId);

	ProjectDto getById(int projectId);

}