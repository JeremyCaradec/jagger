public abstract class BinOp extends Exp
{
	private Exp rhs;
	private Exp lhs;

	public void Init(Exp lhs, Exp rhs)
	{
		this.rhs = rhs;
		this.lhs = lhs;
	}

	public Exp getLhs()
	{
		return lhs;
	}

	public Exp getRhs()
	{
		return rhs;
	}
}