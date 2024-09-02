import java.util.Stack;
import java.io.*;

class MaquinaPilha {
  MaquinaPilha(String caminhoDoExecutavel) {
    executar(caminhoDoExecutavel);
  }

  private void executar(String caminhoDoExecutavel) {
    Stack<Integer> stack = new Stack<>();
    String line = null;
    try (BufferedReader arquivo = new BufferedReader(new FileReader(caminhoDoExecutavel))) {
      do {
        line = arquivo.readLine();
        if (line != null) {
          if (line.startsWith("SUM")) {
            if (stack.size() < 2) throw new Exception("Pilha deve ter pelo dois elementos para realizar a operação de soma.");
            int a = stack.pop();
            int b = stack.pop();
            stack.push(a + b);
          } else if (line.startsWith("SUB")) {
            if (stack.size() < 2) throw new Exception("Pilha deve ter pelo dois elementos para realizar a operação de subtração.");
            int b = stack.pop();
            int a = stack.pop();
            stack.push(a - b);
          } else if (line.startsWith("MULT")) {
            if (stack.size() < 2) throw new Exception("Pilha deve ter pelo dois elementos para realizar a operação de multiplicação.");
            int b = stack.pop();
            int a = stack.pop();
            stack.push(a * b);
          } else if (line.startsWith("DIV")) {
            if (stack.size() < 2) throw new Exception("Pilha deve ter pelo dois elementos para realizar a operação de divisão.");
            int b = stack.pop();
            int a = stack.pop();
            if (b == 0) throw new Exception("Não é permitido divisão por zero.");
            stack.push(a / b);
          } else if (line.startsWith("PUSH")) {
            int v = Integer.parseInt(line.split(" ")[1]);
            stack.push(v);
          } else if (line.startsWith("PRINT")) {
            System.out.println(stack.peek());
          }
        }
      } while (line != null);
    } catch (IOException e) {
      System.out.println("Ocorreu um erro ao escrever o arquivo.");
			e.printStackTrace();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new MaquinaPilha(args[0]);
  }
}