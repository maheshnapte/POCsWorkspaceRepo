package com.app.bean;

public class EmployeePrototype {

	private String id;
	private String name;
	private String designation;

	public EmployeePrototype() {
		super();
	}

	public EmployeePrototype(String id, String name, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "EmployeePrototype [id=" + id + ", name=" + name + ", designation=" + designation + "]";
	}

}
