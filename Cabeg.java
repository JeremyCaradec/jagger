/* Generated By:JavaCC: Do not edit this line. Cabeg.java */
public class Cabeg implements CabegConstants {

// Main loop: read expressions on a line until end of file.
// mainloop → (expression <EOL>)* <EOF>
  final public void mainloop() throws ParseException {
  Exp a; Scope s;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LET:
      case PRINT:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      statement();
    }
    jj_consume_token(0);
  }

  final public void statement() throws ParseException {
  Exp e;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LET:
      scope();
      break;
    case PRINT:
      jj_consume_token(PRINT);
      jj_consume_token(LBR);
      e = ternary();
      jj_consume_token(RBR);
                                                 new PrintFunc(e);
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void scope() throws ParseException {
 Scope s;
    jj_consume_token(LET);
    s = declaration();
    jj_consume_token(IN);
    instructions();
    jj_consume_token(END);
                                                                   s.exit();
  }

  final public Scope declaration() throws ParseException {
 Token t; Exp e; Scope s = new Scope();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      jj_consume_token(VAR);
      t = jj_consume_token(ID);
      jj_consume_token(INIT);
      e = expression();
                                                    s.addDeclaration(t.toString(), e);
    }
            {if (true) return s;}
    throw new Error("Missing return statement in function");
  }

  final public void instructions() throws ParseException {
    statement();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      jj_consume_token(COMMA);
      statement();
    }
  }

  final public Exp ternary() throws ParseException {
  Exp a,b,c;
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
        jj_consume_token(IF);
        a = ternary();
        jj_consume_token(THEN);
        b = ternary();
        jj_consume_token(ELSE);
        c = ternary();
                                                          a= new CondBranch(a,b,c);
        break;
      case LBR:
      case NUMBER:
      case ID:
      case STRING:
      case 28:
      case 29:
        a = comp();
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case LBR:
      case NUMBER:
      case ID:
      case STRING:
      case 28:
      case 29:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_4;
      }
    }
                 {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

// Comparisons
// C => E ('<' E | '==' E | etc...)
  final public Exp comp() throws ParseException {
  Exp a,b;
    a = expression();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 22:
    case 23:
    case 24:
    case 25:
    case 26:
    case 27:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 22:
        jj_consume_token(22);
        b = expression();
                                      a = new Lt(a,b);
        break;
      case 23:
        jj_consume_token(23);
        b = expression();
                                a = new Le(a,b);
        break;
      case 24:
        jj_consume_token(24);
        b = expression();
                                a = new Gt(a,b);
        break;
      case 25:
        jj_consume_token(25);
        b = expression();
                                a = new Ge(a,b);
        break;
      case 26:
        jj_consume_token(26);
        b = expression();
                                a = new Equal(a,b);
        break;
      case 27:
        jj_consume_token(27);
        b = expression();
                                a = new Nequal(a,b);
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
                 {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

// Expression (the axiom).
// E -> T ('+'E | '-'E | etc...)?
  final public Exp expression() throws ParseException {
  Exp a,b;
    a = term();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 28:
      case 29:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_5;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 28:
        jj_consume_token(28);
        b = term();
                     a = new Add(a, b);
        break;
      case 29:
        jj_consume_token(29);
        b = term();
                     a = new Sub(a, b);
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
         {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

// Term.
// T -> U ('*'T | '/'T )*
  final public Exp term() throws ParseException {
  Exp a,b;
    a = unary();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 30:
    case 31:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 30:
        jj_consume_token(30);
        b = term();
                     a = new Mul(a, b);
        break;
      case 31:
        jj_consume_token(31);
        b = term();
                     a = new Div(a, b);
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
         {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

// Unary
// U -> '-'F | '+'F | F
  final public Exp unary() throws ParseException {
    Exp a;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 29:
      jj_consume_token(29);
      a = factor();
                                       {if (true) return new Neg(a);}
      break;
    case 28:
      jj_consume_token(28);
      a = factor();
                                           {if (true) return a;}
      break;
    case LBR:
    case NUMBER:
    case ID:
    case STRING:
      a = factor();
                                 {if (true) return a;}
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

// Factor of an expression.
// F -> <NUMBER> | "(" E ")"
  final public Exp factor() throws ParseException {
  Token t; Exp e;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      t = jj_consume_token(NUMBER);
                   {if (true) return new Num(Double.parseDouble(t.toString()));}
      break;
    case LBR:
      jj_consume_token(LBR);
      e = expression();
      jj_consume_token(RBR);
                               {if (true) return e;}
      break;
    case ID:
      t = jj_consume_token(ID);
                {if (true) return new Var(t.toString());}
      break;
    case STRING:
      t = jj_consume_token(STRING);
                    {if (true) return new ExpString(t.toString());}
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public CabegTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[14];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x1100,0x1100,0x800,0x10000,0x30324020,0x30324020,0xfc00000,0xfc00000,0x30000000,0x30000000,0xc0000000,0xc0000000,0x30324000,0x324000,};
   }

  /** Constructor with InputStream. */
  public Cabeg(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Cabeg(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CabegTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Cabeg(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CabegTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Cabeg(CabegTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CabegTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[32];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 14; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 32; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
