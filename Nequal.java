public class Nequal extends BinOp
{
	public Nequal(Exp rhs, Exp lhs)
	{
		Init(rhs, lhs);
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
