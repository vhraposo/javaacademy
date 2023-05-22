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
@Table(name = "department_employee")
public class DepartmentEmployee {

    @Id
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "Department_id")
    private Department department;

    @OneToOne
    @JoinColumn(name = "employeelist_eid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

    // Construtores, getters e setters
    
}
