class CodeGen{	
	String geraCodigo (ArvoreSintatica arv) {
		return (geraCodigo2(arv) + "PRINT");
	}

	String geraCodigo2 (ArvoreSintatica arv) {
		if (arv instanceof Soma)
			return (geraCodigo2(((Soma) arv).arg1) + 
				geraCodigo2(((Soma) arv).arg2) +
				"SUM\n");
		
		if (arv instanceof Sub)
			return (geraCodigo2(((Sub) arv).arg1) + 
				geraCodigo2(((Sub) arv).arg2) +
				"SUB\n");

		if (arv instanceof Mult)
			return (geraCodigo2(((Mult) arv).arg1) + 
				geraCodigo2(((Mult) arv).arg2) +
				"MULT\n");

		if (arv instanceof Div)
			return (geraCodigo2(((Div) arv).arg1) + 
				geraCodigo2(((Div) arv).arg2) +
				"DIV\n");

		if (arv instanceof Num) {
			Num number = (Num) arv;
			String digitsCode = "";
			for (Digit digit : number.digits) {
				digitsCode += digit.digit;
			}
			return ("PUSH "  + digitsCode + "\n");
		}

		return "";
	}

	void interpretaCodigo (ArvoreSintatica arv) throws Exception  {
		String resultado = interpretaCodigo2(arv) + "";
		System.out.println(resultado);
	}

	int interpretaCodigo2 (ArvoreSintatica arv) throws Exception {
		if (arv instanceof Soma)
			return interpretaCodigo2(((Soma) arv).arg1) + interpretaCodigo2(((Soma) arv).arg2);
		
		if (arv instanceof Sub)
			return interpretaCodigo2(((Sub) arv).arg1) - interpretaCodigo2(((Sub) arv).arg2);

		if (arv instanceof Mult)
			return interpretaCodigo2(((Mult) arv).arg1) * interpretaCodigo2(((Mult) arv).arg2);

		if (arv instanceof Div)
			return interpretaCodigo2(((Div) arv).arg1) / interpretaCodigo2(((Div) arv).arg2);

		if (arv instanceof Num) {
			Num number = (Num) arv;
			String digitsCode = "";
			for (Digit digit : number.digits) {
				digitsCode += digit.digit;
			}
			return Integer.parseInt(digitsCode);
		}

		return 0;
	}
}
