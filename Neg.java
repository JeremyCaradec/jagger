public class Neg extends Exp
{
	private Exp e;

	public Neg(Exp e)
	{
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
