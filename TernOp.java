public abstract class TernOp extends Exp
{
	private Exp e1;
	private Exp e2;
	private Exp e3;

	public void Init(Exp e1, Exp e2, Exp e3)
	{
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;

	}

	public Exp getE1()
	{
		return e1;
	}

	public Exp getE2()
	{
		return e2;
	}

	public Exp getE3()
	{
		return e3;
	}

}