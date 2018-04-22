public class ExpString extends Exp
{
	String string;

	public ExpString(String string)
	{
		this.string = string;
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}

	public String getString()
	{
		return string;
	}
}