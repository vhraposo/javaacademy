package ex3_jpaMapeamentos_n_n_;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Professor {
   @Id
   @GeneratedValue( strategy = GenerationType.AUTO )
   private int pid;
   private String pnome;
   private String assunto;

   @ManyToMany(targetEntity=Classe.class)
   private Set clasSet;

   public Professor() {
      super();
   }
   public Professor(int pid, String pnome, String assunto, Set clasSet) {
      super();
      this.pid = pid;
      this.pnome = pnome;
      this.assunto = assunto;
      this.clasSet = clasSet;
   }
   public int getPid() {
      return pid;
   }
   public void setPid(int pid) {
      this.pid = pid;
   }
   
   public String getPnome() {
      return pnome;
   }
   
   public void setPnome(String pnome) {
      this.pnome = pnome;
   }
   
   public String getAssunto() {
      return assunto;
   }
   
   public void setAssunto(String assunto) {
      this.assunto = assunto;
   }
   
   public Set getClasSet() {
      return clasSet;
   }
   
   public void setClasSet(Set clasSet) {
      this.clasSet = clasSet;
   }
}
