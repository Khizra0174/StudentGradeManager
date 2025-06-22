package studentgrademanager;

import java.util.ArrayList;

public class Students {
	private String name;
	private String id;
	private String grade;
	public Students(String id,String name) {
		this.id = id;
		this.name=name;
		this.grade = ""; 
	}
	public void setName(String name) {
		this.name= name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getName() {
		return this.name;
	}
	public String getId() {
		return this.id;
	}
	public String getGrade() {
		return this.grade;
	}
	public void calculateGrade() {
		
	}
}
