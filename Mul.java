public class Mul extends BinOp
{
	public Mul(Exp rhs, Exp lhs)
	{
		Init(rhs, lhs);
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
