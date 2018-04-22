public class PrintFunc implements Ast
{
	public PrintFunc(Exp e)
	{
		new TypeChecker(e);
		new PPrinter(e); 
		System.out.println(" = " + new Eval(e).res_str());
	}
}