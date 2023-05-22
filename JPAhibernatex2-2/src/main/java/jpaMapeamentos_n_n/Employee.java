package jpaMapeamentos_n_n;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String ename;
	private double salary;
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
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

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}

	public Set getDepartmentSet() {
		return departmentSet;
	}

	public void setDepartmentSet(Set departmentSet) {
		this.departmentSet = departmentSet;
	}

	private String deg;
	
	@ManyToMany(targetEntity = Department.class)
	@JoinTable(
	    name = "employee_department",
	    joinColumns = @JoinColumn(name = "employee_id"),
	    inverseJoinColumns = @JoinColumn(name = "department_id")
	)
	private Set<Department> departmentSet;
	
	public Employee(int eid, String ename, double salary, String deg, Set departmentSet) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.deg = deg;
		this.departmentSet = departmentSet;
	}
	
	public Employee() {
		super();
	}
}


