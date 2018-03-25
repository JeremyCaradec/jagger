public class Equal extends BinOp
{
	public Equal(Exp rhs, Exp lhs)
	{
		Init(rhs, lhs);
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
