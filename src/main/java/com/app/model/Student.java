package com.app.model;

import java.time.LocalDate;

public class Student {
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	private Integer id;
    public Student(Integer id, String name, String lastName, LocalDate birthday, String nationality, String university,
			Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthday = birthday;
		this.nationality = nationality;
		this.university = university;
		this.active = active;
	}
	private String name;
    private String lastName;
    private LocalDate birthday;
    private String nationality;
    private String university;
    private Boolean active;
    
    
}