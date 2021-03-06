import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Scope extends Exp
{

	public Scope parent;
	private HashMap<String, Exp> map;
	private ArrayList<Exp> instr;

	Scope(Scope parent)
	{
		setType(TypeChecker.ExpType.Void);
		map = new HashMap<String, Exp>();
		instr = new ArrayList<Exp>();		
		this.parent = parent;
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}

	public Scope getParent()
	{
		return parent;
	}


	public void addDeclaration(String s, Exp e)
	{
		Exp newExp = null;
		Eval eval;
		new TypeChecker(e, this);
		eval = new Eval(e, this);
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

	public void affect(String s, Exp e)
	{		
		if(hasId(s))
		{
			put(s,e);
			return;
		}
		parent.affect(s, e);
	} 


	public Exp getIdValue(String s)
	{
		Exp e = null;		
		if(hasId(s))
		{
			return map.get(s);
		}
		e = parent.getIdValue(s);
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


}