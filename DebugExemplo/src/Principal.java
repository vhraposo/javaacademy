import java.util.Scanner;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Principal {

	public static void main(String[] args) throws Exception {

		Logger meuLogger = Logger.getLogger("MeuLogger");
		FileHandler fileHandler = new FileHandler("Logtext.txt", true);
		fileHandler.setFormatter(new SimpleFormatter());
		meuLogger.addHandler(fileHandler);
		meuLogger.setLevel(Level.ALL);

		try {
			meuLogger.log(Level.INFO, "\n O programa iniciou a função de calculo!");
		} catch (Exception e) {
			meuLogger.log(Level.SEVERE, "Erro ao iniciar a calculadora!:", e);
			e.printStackTrace();
		}
		try (Scanner leitura = new Scanner(System.in)) {
			Calculadora c = new Calculadora();
			float a = 0, b = 0, resultado = 0;
			String operador;
			System.out.println("Calculadora");
			do {
				System.out.println("Insira o operador +, -, *, /");
				operador = leitura.nextLine();
			} while (!(operador.contains("+") || operador.contains("-") || operador.contains("*")
					|| operador.contains("/")));

			System.out.println("Insira o 1o valor");
			a = leitura.nextFloat();
			System.out.println("Insira o 2o valor");
			b = leitura.nextFloat();

			resultado = c.calcular(a, b, operador.charAt(0));
			System.out.println("O resultado é " + resultado);
			meuLogger.log(Level.INFO, "\n O @user realizou uma operação de cálculo com sucesso!. O Resultado da operação foi " + resultado);
        }
	}
}