public class PPrinter implements Visitor
{
	public PPrinter(Exp e)
	{
		e.accept(this);
	}

	public void visit(Num val)
	{
		System.out.print(val.getDouble());
	}
	public void visit(Add val)
	{
		System.out.print('(');
		val.getLhs().accept(this);
		System.out.print(" + ");
		val.getRhs().accept(this);
		System.out.print(')');
	}
	public void visit(Mul val)
	{
		System.out.print('(');
		val.getLhs().accept(this);
		System.out.print(" * ");
		val.getRhs().accept(this);
		System.out.print(')');
	}
	public void visit(Sub val)
	{
		System.out.print('(');
		val.getLhs().accept(this);
		System.out.print(" - ");
		val.getRhs().accept(this);
		System.out.print(')');
	}
	public void visit(Div val)
	{
		System.out.print('(');
		val.getLhs().accept(this);
		System.out.print(" / ");
		val.getRhs().accept(this);
		System.out.print(')');
	}
	public void visit(Neg val)
	{
		System.out.print("-(");
		val.getExp().accept(this);
		System.out.print(')');
	}
	public void visit(Lt val)
	{
		System.out.print('(');
		val.getLhs().accept(this);
		System.out.print(" < ");
		val.getRhs().accept(this);
		System.out.print(')');
	}
	public void visit(Le val)
	{
		System.out.print('(');
		val.getLhs().accept(this);
		System.out.print(" <= ");
		val.getRhs().accept(this);
		System.out.print(')');
	}
	public void visit(Gt val)
	{
		System.out.print('(');
		val.getLhs().accept(this);
		System.out.print(" > ");
		val.getRhs().accept(this);
		System.out.print(')');
	}
	public void visit(Ge val)
	{
		System.out.print('(');
		val.getLhs().accept(this);
		System.out.print(" >= ");
		val.getRhs().accept(this);
		System.out.print(')');
	}
	public void visit(Equal val)
	{
		System.out.print('(');
		val.getLhs().accept(this);
		System.out.print(" == ");
		val.getRhs().accept(this);
		System.out.print(')');
	}
}