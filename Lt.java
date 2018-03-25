public class Lt extends BinOp
{
	public Lt(Exp rhs, Exp lhs)
	{
		Init(rhs, lhs);
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
