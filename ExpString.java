public class ExpString extends Exp
{
	String string;

	public ExpString(String string)
	{
		this.string = string;
		setType(TypeChecker.ExpType.String);
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