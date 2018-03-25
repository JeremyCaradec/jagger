public class Sub extends BinOp
{
	public Sub(Exp rhs, Exp lhs)
	{
		Init(rhs, lhs);
	}
	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
