package projects.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import projects.dao.ProjectDao;
import projects.entity.Project;
import projects.exception.DbException;

public class ProjectService {
private ProjectDao projectDao = new ProjectDao();
private Integer projectId;

public Project addProject(Project project) {
	return projectDao.insertProject(project);
}

public List<Project> fetchAllProjects() {
	return projectDao.fetchAllProjects();
}
Optional<Project> op = projectDao.fetchProjectById(projectId);

public Project fetchProjectById(Integer projectId) {
	return projectDao.fetchProjectById(projectId).orElseThrow(
			() -> new NoSuchElementException(
					"Project with project ID=" + projectId 
					+ " does not exist."));
}

  public void modifyProjectDetails(Project project) {
	if(!projectDao.modifyProjectDetails(project)) {
		throw new DbException("Project with ID=" + project.getProjectId() + " does not exixt.");
	}
	
}

public void deleteProject(Integer projectId) {
	if(!projectDao.deleteProject(projectId)) {
		throw new DbException("Project with ID=" + projectId + " does not exist.");
	}
	
}

}
