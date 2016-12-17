package org.hibernate.example.DTO;

public class StudentDTO {
	int id;
	String name;

	public StudentDTO(){}
	
	public StudentDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + "]";
	}

}
