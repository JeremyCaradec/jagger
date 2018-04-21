public class Var extends Exp
{
	String id;

	public Var(String id)
	{
		this.id = id;
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}

	public String getId()
	{
		return id;
	}
}