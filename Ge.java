public class Ge extends BinOp
{
	public Ge(Exp rhs, Exp lhs)
	{
		Init(rhs, lhs);
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
