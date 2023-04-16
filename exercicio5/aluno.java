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
 
 public static void main(String[] args) {
	 aluno aluno1 = new aluno();
	 aluno aluno2 = new aluno("Victor", "victor@gmail.com", "2020200202");
	 aluno aluno3 = new aluno("Monica", "monica@gmail.com", "1010101010");
	 
	 System.out.println("\nInformações do aluno 1: ");
	 aluno1.exibirInformacoes();
	 
	 System.out.println("\nInformações do aluno 2: ");
	 aluno2.exibirInformacoes();
	 
	 System.out.println("\nInformações do Aluno3: ");
	 aluno3.exibirInformacoes();
 }
 
 
}
 
 
