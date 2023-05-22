package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	    public static void main(String[] args) {
	        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bancojpahibernate2");
	        EntityManager entityManager = entityManagerFactory.createEntityManager();

	        Department department = new Department();
	        department.setName("Novo Department");

	        Employee employee = new Employee();
	        employee.setDeg("Manager2");
	        employee.setEname("Fulano3");
	        employee.setSalary(7000);

	        DepartmentEmployee departmentEmployee = new DepartmentEmployee();
	        departmentEmployee.setDepartment(department);
	        departmentEmployee.setEmployee(employee);

	        entityManager.getTransaction().begin();
	        entityManager.persist(department);
	        entityManager.persist(employee);
	        entityManager.persist(departmentEmployee);
	        entityManager.getTransaction().commit();
	        
	        //(Update)
	        entityManager.getTransaction().begin();
	        employee.setEname("Lucas Luquinhas");
	        entityManager.merge(employee);
	        entityManager.persist(employee);
	        entityManager.getTransaction().commit();
	        
	        //(Read)

	        Department foundDepartment = entityManager.find(Department.class, department.getId());
	        System.out.println("Department: " + foundDepartment.getName());

	        DepartmentEmployee foundDepartmentEmployee = entityManager.find(DepartmentEmployee.class, departmentEmployee.getId());

	        Employee foundEmployee = entityManager.find(Employee.class, employee.getEid());
	        System.out.println("Employee: " + foundEmployee.getEname());

	        System.out.println("Associated Department ID: " + foundDepartmentEmployee.getDepartment().getId());
	        System.out.println("Associated Employee ID: " + foundDepartmentEmployee.getEmployee().getEid());

	        entityManager.close();
	        entityManagerFactory.close();
	    }
	}
