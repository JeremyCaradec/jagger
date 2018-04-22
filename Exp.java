public abstract class Exp implements Ast
{
	private TypeChecker.ExpType checked_type;
	public abstract void accept(Visitor v);

	public void setType(TypeChecker.ExpType type)
	{
		checked_type = type;
	}

	public TypeChecker.ExpType getType()
	{
		return checked_type;
	}
}
