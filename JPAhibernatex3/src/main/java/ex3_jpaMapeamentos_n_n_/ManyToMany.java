package ex3_jpaMapeamentos_n_n_;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToMany {
   public static void main(String[] args) {
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("bancojpahibernate4");
      EntityManager entitymanager = emfactory.createEntityManager();
      entitymanager.getTransaction().begin();

      //Criação das turmas
      Classe turma1 = new Classe(0, "Primeira", null);
      Classe turma2 = new Classe(0, "Segunda", null);
      Classe turma3 = new Classe(0, "Terceira", null);

      //Persistência das turmas
      entitymanager.persist(turma1);
      entitymanager.persist(turma2);
      entitymanager.persist(turma3);
      
      //Criação dos class Set
      Set<Classe> classSet1 = new HashSet();
      classSet1.add(turma1);
      classSet1.add(turma2);
      classSet1.add(turma3);

      Set<Classe> classSet2 = new HashSet();
      classSet2.add(turma3);
      classSet2.add(turma1);
      classSet2.add(turma2);

      Set<Classe> classSet3 = new HashSet();
      classSet3.add(turma2);
      classSet3.add(turma3);
      classSet3.add(turma1);

      //Criação dos professores
      Professor prof1 = new Professor(0, "Pedro","JavaScript", classSet1);
      Professor prof2 = new Professor(0, "Lucas","HTML/CSS", classSet2);
      Professor prof3 = new Professor(0, "Victor","Angular", classSet3);

      //Persistência dos professores
      entitymanager.persist(prof1);
      entitymanager.persist(prof2);
      entitymanager.persist(prof3);

      entitymanager.getTransaction().commit();
      entitymanager.close();
      emfactory.close();
   }
}
