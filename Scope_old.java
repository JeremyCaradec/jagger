/*import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Scopeold extends Exp
{

	private static List<Scope> scopes = new ArrayList<Scope>();

	public static int curScope = -1;
	private HashMap<String, Exp> map;
	private ArrayList<Exp> instr;

	Scopeold()
	{
		setType(TypeChecker.ExpType.Void);
		map = new HashMap<String, Exp>();
		instr = new ArrayList<Exp>();
		enter();
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}

	public void addDeclaration(String s, Exp e)
	{
		Exp newExp = null;
		Eval eval;
		new TypeChecker(e);
		eval = new Eval(e);
		if(e.getType() == TypeChecker.ExpType.Double)
			newExp = new Num(eval.result());
		else if(e.getType() == TypeChecker.ExpType.String)
			newExp = new ExpString(eval.res_str());
		map.putIfAbsent(s, newExp);
	}

	public void addInstruction(Exp e)
	{
		instr.add(e);
	}

	public ArrayList<Exp> getInstructions()
	{
		return instr;
	}

	public HashMap<String, Exp> getDeclarations()
	{
		return map;
	}

	public static void affect(String s, Exp e)
	{
		Scope scope = null;
		for(int i=curScope; i >= 0; i--)
		{
			scope = scopes.get(i);
			if(scope.hasId(s))
			{
				break;
			}
		}
		scope.put(s, e);
	} 


	public static Exp getIdValue(String s)
	{		
		Exp e = null;
		for(int i=curScope; i >= 0; i--)
		{
			Scope scope = scopes.get(i);
			if(scope.hasId(s))
			{
				e = scope.get(s);
				break;
			}
		}
		return e;
	}

	public boolean hasId(String s)
	{
		return map.containsKey(s);
	}

	public Exp get(String s)
	{
		return map.get(s);
	}

	public void put(String s, Exp e)
	{
		map.put(s, e);
	}

	public void enter()
	{
		scopes.add(this);
		curScope++;
	}

	public static void exit()
	{
		scopes.remove(curScope);
		curScope--;
	}


}*/