public abstract class Exp implements Ast
{
	public abstract void accept(Visitor v);
}
