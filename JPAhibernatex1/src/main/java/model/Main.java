package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import connection.Connection;

public class Main {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("bancojpahibernate1");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void main(String[] args) {

		// INSERT
		/*
		 * Address endereco = new Address();
		 * endereco.setCity("ABC");
		 * endereco.setCountry("asd");
		 * endereco.setStreet("ruaX");
		 * 
		 * entityManager.getTransaction().begin();
		   entityManager.persist(endereco);
		 * entityManager.getTransaction().commit();
		 * 
		 * User user = new User(); user.setName("Vitin");
		   user.setAddress(endereco);
		 * entityManager.getTransaction().begin(); entityManager.persist(user);
		 * entityManager.getTransaction().commit();
		 */

		//*
		
		//User user = entityManager.find(User.class, 1);
		//System.out.println("Nome da pessoa:" + user.getName());
		//System.out.println("Endereço da pessoa:" + user.getAddress().toString());
		
		
		// UPDATE
		/*
		 user.setName("Lucas");
		 entityManager.getTransaction().begin();
		 entityManager.merge(user);
		 entityManager.getTransaction().commit();
		 
		 System.out.println("Nome da pessoa:" + user.getName()); 
		 */
		
		// DELETE
		/*
		User user = entityManager.find(User.class, 1);
		entityManager.getTransaction().begin();
		entityManager.remove(user);
		entityManager.getTransaction().commit();
		*/
		 
		entityManager.close();
		entityManagerFactory.close();

	}
}