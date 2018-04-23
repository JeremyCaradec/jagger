public class Num extends Exp
{
	private double d;

	public Num(double d)
	{
		this.d = d;
		setType(TypeChecker.ExpType.Double);
	}
	public void accept(Visitor v)
	{
		v.visit(this);
	}
	
	public double getDouble()
	{
	 return d;
	}
}
