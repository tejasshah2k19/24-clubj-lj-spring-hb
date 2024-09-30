package com.entity.onetomany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="project_manager")
public class ProjectManagerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectManagerId;
	private String firstName;
	private String lastName;

	@OneToMany(mappedBy = "projectManager")
	List<ProjectEntity> projects;

	public Integer getProjectManagerId() {
		return projectManagerId;
	}

	public void setProjectManagerId(Integer projectManagerId) {
		this.projectManagerId = projectManagerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
