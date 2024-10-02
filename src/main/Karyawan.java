package main;

public class Karyawan {
	private String code;
	private String name;
	private String gender;
	private String role;
	private int Salary;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public Karyawan(String code, String name, String gender, String role, int salary) {
		super();
		this.code = code;
		this.name = name;
		this.gender = gender;
		this.role = role;
		Salary = salary;
	}
	
	
}
