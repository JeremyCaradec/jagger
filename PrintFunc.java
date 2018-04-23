public class PrintFunc extends Exp
{
	private Exp e;

	public PrintFunc(Exp e)
	{
		setType(TypeChecker.ExpType.Void);
		this.e = e;
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}

	public Exp getExp()
	{
		return e;
	}
}