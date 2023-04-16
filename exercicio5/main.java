package exercicio5;

public class main {

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
