import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class PPrinter implements Visitor
{
	public PPrinter(Exp e)
	{
		System.out.println("");
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
		System.out.print("(-");
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
	public void visit(Nequal val)
	{
		System.out.print('(');
		val.getLhs().accept(this);
		System.out.print(" <> ");
		val.getRhs().accept(this);
		System.out.print(')');
	}
	public void visit(CondBranch val)
	{
		System.out.print("(if ");
		val.getE1().accept(this);
		System.out.print(" then ");
		val.getE2().accept(this);
		System.out.print(" else ");
		val.getE3().accept(this);
		System.out.print(")");

	}

	public void visit(Var val)
	{
		System.out.print(val.getId());
	}

	public void visit(ExpString val)
	{
		System.out.print(val.getString());
	}

	public void visit(PrintFunc val)
	{
		System.out.print("print(");
		val.getExp().accept(this);
		System.out.print(")");
	}

	public void visit(Scope val)
	{
		System.out.print("let");
		HashMap<String, Exp> map = val.getDeclarations();
		for (Map.Entry<String, Exp> entry : map.entrySet())
		{
     		System.out.print(" var "+entry.getKey() + " := ");
     		entry.getValue().accept(this);
		}
		System.out.print(" in ");
		ArrayList<Exp> arr = val.getInstructions();
		arr.get(0).accept(this);
		for(int i=1; i<arr.size(); i++)
		{	
			System.out.print(", ");
			arr.get(i).accept(this);
		}
		System.out.print(" end");
	}

	public void visit(Affectation val)
	{
		System.out.print(val.getId()+" := ");
		val.getExp().accept(this);
	}
}