public class Affectation extends Exp
{
	private String s;
	private Exp e;

	public Affectation(String s, Exp e)
	{
		this.s = s;
		this.e = e;
		setType(TypeChecker.ExpType.Void);
	}
	public void accept(Visitor v)
	{
		v.visit(this);
	}
	
	public String getId()
	{
		return s;
	}

	public Exp getExp()
	{
	 	return e;
	}
}
