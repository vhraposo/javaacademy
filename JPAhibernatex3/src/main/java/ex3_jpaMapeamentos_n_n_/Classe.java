package ex3_jpaMapeamentos_n_n_;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Classe 
{
   @Id
   @GeneratedValue( strategy = GenerationType.AUTO )
   private int cid;
   private String cnome;

   @ManyToMany(targetEntity=Professor.class)
   private Set professorSet;

   public Classe(){
      super();
   }
   public Classe(int cid, String cnome, Set professorSet) {
      super();
      this.cid = cid;
      this.cnome = cnome;
      this.professorSet = professorSet;
   }
   public int getCid() {
      return cid;
   }
   public void setCid(int cid) {
      this.cid = cid;
   }
   public String getCnome() {
      return cnome;
   }
   public void setCnome(String cnome) {
      this.cnome = cnome;
   }
   public Set getProfessorSet() {
      return professorSet;
   }
   public void setProfessorSet(Set professorSet) {
      this.professorSet = professorSet;
   }  
}