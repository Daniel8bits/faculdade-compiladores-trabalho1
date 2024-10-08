import java.io.*;

enum TokenType { NUM, SOMA, SUB, MULT, DIV, APar, FPar, EOF}

class Token {
  char lexema;
  TokenType token;

  Token (char l, TokenType t)
 	{ lexema = l;token = t; }	
}

class AnaliseLexica {
	BufferedReader arquivo;
	char previousChar;
	boolean reset;

	AnaliseLexica(String a) throws Exception {
	 	this.arquivo = new BufferedReader(new FileReader(a));
	}

	void reset() throws Exception {
		this.reset = true;
	}

	Token getNextToken() throws Exception {	
		Token token;
		int eof = -1;
		char currchar;
		int currchar1;

		do {

			if (reset) {
				currchar1 = previousChar;
				reset = false;
			} else {
				currchar1 = arquivo.read();
			}

			currchar = (char) currchar1;
			previousChar = currchar;

		} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
		if(currchar1 != eof && currchar1 != 10) {
			if (currchar >= '0' && currchar <= '9')
				return (new Token (currchar, TokenType.NUM));
			else
				switch (currchar) {
					case '(':
						return (new Token (currchar,TokenType.APar));
					case ')':
						return (new Token (currchar,TokenType.FPar));
					case '+':
						return (new Token (currchar,TokenType.SOMA));
					case '-':
						return (new Token (currchar,TokenType.SUB));
					case '*':
						return (new Token (currchar,TokenType.MULT));
					case '/':
						return (new Token (currchar,TokenType.DIV));
					
					default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
				}
		}

		arquivo.close();
			
		return (new Token(currchar,TokenType.EOF));
	}
}
