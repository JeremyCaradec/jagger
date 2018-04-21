public class PrintFunc implements Ast
{
	public PrintFunc(Exp e)
	{
		new PPrinter(e); 
		System.out.print(" = " + new Eval(e).result()+ '\n');
	}
}