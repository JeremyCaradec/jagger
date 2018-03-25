public class Div extends BinOp
{
	public Div(Exp rhs, Exp lhs)
	{
		Init(rhs, lhs);
	}
	public void accept(Visitor v)
	{
		v.visit(this);
	}
}