import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Compilador {

	public static void main(String[] args) {	
		ArvoreSintatica arv = null;
	
		try {

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
			
			CodeGen backend = new CodeGen();
			//backend.interpretaCodigo(arv);
			String codigo = backend.geraCodigo(arv);
			escreveArquivo(args[1], codigo);
			//System.out.println(codigo);

		} catch(Exception e) {			
			System.out.println("Erro de compilação:\n" + e);
		}
	}

	private static void escreveArquivo(String nome, String conteudo) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nome))) {
				writer.write(conteudo); 
		} catch (IOException e) {
				System.out.println("Ocorreu um erro ao escrever o arquivo.");
				e.printStackTrace();
		}
	}
}
