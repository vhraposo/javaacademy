package jpaMapeamentos_n_n;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bancojpahibernate3");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Criação dos departamentos
        Department department1 = new Department("Financeiro2", null);
        Department department2 = new Department("Web2", null);
        Department department3 = new Department("Contabilidade2", null);

        entityManager.persist(department1);
        entityManager.persist(department2);
        entityManager.persist(department3);

        // Criação dos department Set
        HashSet<Department> departmentSet1 = new HashSet<Department>();
        departmentSet1.add(department1);

        HashSet<Department> departmentSet2 = new HashSet<Department>();
        departmentSet2.add(department1);
        departmentSet2.add(department2);

        HashSet<Department> departmentSet3 = new HashSet<Department>();
        departmentSet3.add(department3);
        
        //Criação dos funcionários
        Employee employee1 = new Employee();
        employee1.setEname("emp 1_new");
        employee1.setSalary(7000);
        employee1.setDeg("Manager 1");
        employee1.setDepartmentSet(departmentSet1);

        Employee employee2 = new Employee();
        employee2.setEname("emp 2_new");
        employee2.setSalary(8000);
        employee2.setDeg("Manager 2");
        employee2.setDepartmentSet(departmentSet2);
        //neste exemplo o mesmo funcionário possui mais de um departamento

        Employee employee3 = new Employee();
        employee3.setEname("emp 3_new");
        employee3.setSalary(9000);
        employee3.setDeg("Manager 3");
        employee3.setDepartmentSet(departmentSet3);
        //poderia colocar o departmentSet como 1 para que mais de um funcionário pudesse ter o mesmo departamento 

        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
