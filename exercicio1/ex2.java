package exercicio1;
import java.util.Scanner;


public class ex2 {

	public static void main(String[] args) {
		pessoa p = new pessoa();
		System.out.println("O nome  é " + p.nome);
		Scanner leitura = new Scanner(System.in);
		
		
		System.out.println("Insira o nome");
		String nome = leitura.nextLine();
		System.out.println("Insira o email");
		String email = leitura.nextLine();
		System.out.println("Insira o cpf");
		String cpf = leitura.nextLine();
		
		

		System.out.println("O nome é " + nome + "o email é "+ email + "o cpf é " + cpf);
	}

}








