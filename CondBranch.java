public class CondBranch extends TernOp
{
	public CondBranch(Exp e1, Exp e2, Exp e3)
	{
		Init(e1, e2, e3);
	}
	
	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
