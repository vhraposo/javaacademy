package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid")
    private int eid;

    @Column(name = "deg")
    private String deg;

    @Column(name = "ename")
    private String ename;

    @Column(name = "salary")
    private double salary;

    @OneToOne(mappedBy = "employee")
    private DepartmentEmployee departmentEmployee;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public DepartmentEmployee getDepartmentEmployee() {
		return departmentEmployee;
	}

	public void setDepartmentEmployee(DepartmentEmployee departmentEmployee) {
		this.departmentEmployee = departmentEmployee;
	}

    // Construtores, getters e setters
    
}
