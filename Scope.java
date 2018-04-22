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
		scopes.add(this);
		curScope++;
	}

	public void addDeclaration(String s, Exp e)
	{
		map.putIfAbsent(s, e);
	}

	public static Exp getIdValue(String s)
	{		
		Exp e = null;
		for(Scope scope:scopes)
		{
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

	public void exit()
	{
		scopes.remove(curScope);
		curScope--;
	}
}