package com.java8.casestudy.case2;

import java.util.function.Function;

class Emp{
	private int id;
	private String name;
	private double salary;
	private String dept;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Emp(int id, String name, double salary, String dept) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}
	public Emp() {}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emp [id=").append(id).append(", name=").append(name).append(", salary=").append(salary)
				.append(", dept=").append(dept).append("]");
		return builder.toString();
	}
	
	public EmpSelectedData getEmpSelectedData() {
		return new EmpSelectedData(name, salary);
	}
}

class EmpSelectedData{
	private String name;
	private double salary;
	public EmpSelectedData(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public EmpSelectedData() {}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmpSelectedData [name=").append(name).append(", salary=").append(salary).append("]");
		return builder.toString();
	}
	
	
}
public class DemoFuncation {
	
	public static void main(String[] args) {
											//this		-> EmpSelectedData
		//Function<Emp, EmpSelectedData> function=e->  new EmpSelectedData(e.getName(), e.getSalary());
					
		Function<Emp, EmpSelectedData> function=Emp::getEmpSelectedData;
		
				
				
	}

}
