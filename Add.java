public class Add extends BinOp
{
	public Add(Exp rhs, Exp lhs)
	{
		Init(rhs, lhs);
	}
	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
