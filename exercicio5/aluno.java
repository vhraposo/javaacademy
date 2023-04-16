package exercicio5;
import java.util.Scanner;

 public class aluno {
	private String nome;
	private String email;
	private String matricula;
	

 public aluno(String nome, String email, String matricula) {
	this.nome = nome;
	this.email = email;
	this.matricula = matricula;
}
 
 
 public aluno() {
	 Scanner scanner = new Scanner (System.in);
	 System.out.print("Digite o nome do aluno: ");
	 this.nome = scanner.nextLine();
	 System.out.print("Digite o email do aluno: ");
	 this.email = scanner.nextLine();
	 System.out.print("Digite a matrícula do aluno: ");
	 this.matricula = scanner.nextLine();
 
 }
 
 public void exibirInformacoes() {
	 System.out.println("Nome: " + this.nome);
	 System.out.println("Email: " + this.email);
	 System.out.println("Matrícula: " + this.matricula);
 }
 

 
 
}
 
 
