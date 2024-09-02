import java.util.ArrayList;

class ArvoreSintatica {}

class Exp extends ArvoreSintatica {}

class Digit extends Exp {
 	int digit;
	Digit(int digit){ this.digit = digit; }
}

class Num extends Exp {
 	ArrayList<Digit> digits;
	Num (ArrayList<Digit> digits) {
		this.digits = digits;
	}
}

class Operador extends Exp {
	Exp arg1;
	Exp arg2;
	Operador (Exp a1, Exp a2) { arg1 = a1; arg2 = a2; }
}

class Soma extends Operador {
	Soma (Exp a1, Exp a2) { super(a1,a2); }
}

class Sub extends Operador {
	Sub (Exp a1, Exp a2) { super(a1,a2); }
}

class Mult extends Operador {
	Mult (Exp a1, Exp a2) { super(a1,a2); }
}

class Div extends Operador {
	Div (Exp a1, Exp a2) { super(a1,a2); }
}