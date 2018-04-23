import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Scope implements Ast
{

	private static List<Scope> scopes = new ArrayList<Scope>();
	public static int curScope = -1;
	private HashMap<String, Exp> map;

	Scope()
	{
		map = new HashMap<String, Exp>();
		enter();
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

	public void enter()
	{
		scopes.add(this);
		curScope++;
	}

	public void exit()
	{
		scopes.remove(curScope);
		curScope--;
	}
}