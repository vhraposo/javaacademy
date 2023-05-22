package jpaMapeamentos_n_n;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Department{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToMany(mappedBy = "departmentSet")
	private Set<Employee> employeeSet;
	
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
	public Set getEmployeeSet() {
		return employeeSet;
	}
	public void setEmployeeSet(Set employeeSet) {
		this.employeeSet = employeeSet;
	}
	public Department() {
		super();
	}
	public Department(String name, Set employeeSet) {
		super();
		this.id = id;
		this.name = name;
		this.employeeSet = employeeSet;
	}
}
