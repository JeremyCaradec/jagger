import java.util.ArrayList;

public class Eval implements Visitor
{
	private double result;
	private String res_str;
	public Scope scope;

	public Eval(Exp e, Scope scope)
	{
		result = 0.0;
		res_str = "";
		this.scope = scope;
		e.accept(this);
	}

	public Eval(Exp e)
	{
		this(e, null);
	}

	public double result()
	{
		return result;
	}

	public String res_str()
	{
		return res_str;
	}

	public void setScope(Scope s)
	{
		scope =s ;
	}

	public void visit(Add val)
	{
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		if(val.getType() == TypeChecker.ExpType.String)
		{
			String tmp;
			lhs.accept(this);
			tmp = res_str;
			rhs.accept(this);
			res_str = "\"" + tmp.replace("\"", "") + res_str.replace("\"", "") + "\"";
		}
		else if(val.getType() == TypeChecker.ExpType.Double)
		{
			double tmp;
			lhs.accept(this);
			tmp = result;
			rhs.accept(this);
			result = tmp + result;
			res_str = Double.toString(result);
		}
	}
	
	public void visit(Mul val)
	{
		double tmp;
		val.getLhs().accept(this);
		tmp = result;
		val.getRhs().accept(this);
		result = tmp * result;
		res_str = Double.toString(result);
	}

	public void visit(Sub val)
	{
		double tmp;
		val.getLhs().accept(this);
		tmp = result;
		val.getRhs().accept(this);
		result = tmp - result;
		res_str = Double.toString(result);
	}

	public void visit(Div val)
	{
		double tmp;
		val.getLhs().accept(this);
		tmp = result;
		val.getRhs().accept(this);
		result = tmp / result;
		res_str = Double.toString(result);

	}

	public void visit(Neg val)
	{
		val.getExp().accept(this);
		result = -result;
		res_str = Double.toString(result);

	}

	public void visit(Lt val)
	{
		
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		if(lhs instanceof ExpString && rhs instanceof ExpString)
		{
			String tmp;
			lhs.accept(this);
			tmp = res_str;
			rhs.accept(this);
			result = (tmp.compareTo(res_str) < 0)?1:0;
		}
		else
		{	
			double tmp;
			lhs.accept(this);
			tmp = result;
			rhs.accept(this);
			result = (tmp < result)?1:0;
		}
		res_str = Double.toString(result);
	}

	public void visit(Le val)
	{
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		if(lhs instanceof ExpString && rhs instanceof ExpString)
		{
			String tmp;
			lhs.accept(this);
			tmp = res_str;
			rhs.accept(this);
			result = (tmp.compareTo(res_str) <= 0)?1:0;
		}
		else
		{
			double tmp;
			lhs.accept(this);
			tmp = result;
			rhs.accept(this);
			result = (tmp <= result)?1:0;
		}
		res_str = Double.toString(result);
	}

	public void visit(Gt val)
	{
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		if(lhs instanceof ExpString && rhs instanceof ExpString)
		{
			String tmp;
			lhs.accept(this);
			tmp = res_str;
			rhs.accept(this);
			result = (tmp.compareTo(res_str) > 0)?1:0;
		}
		else
		{
			double tmp;
			lhs.accept(this);
			tmp = result;
			rhs.accept(this);
			result = (tmp > result)?1:0;
		}
		res_str = Double.toString(result);
	}

	public void visit(Ge val)
	{
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		if(lhs instanceof ExpString && rhs instanceof ExpString)
		{
			String tmp;
			lhs.accept(this);
			tmp = res_str;
			rhs.accept(this);
			result = (tmp.compareTo(res_str) >= 0)?1:0;
		}
		else
		{
			double tmp;
			lhs.accept(this);
			tmp = result;
			rhs.accept(this);
			result = (tmp >= result)?1:0;
		}
		res_str = Double.toString(result);
	}

	public void visit(Equal val)
	{
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		if(lhs instanceof ExpString && rhs instanceof ExpString)
		{
			String tmp;
			lhs.accept(this);
			tmp = res_str;
			rhs.accept(this);
			result = (tmp.compareTo(res_str) == 0)?1:0;
		}
		else
		{
			double tmp;
			lhs.accept(this);
			tmp = result;
			rhs.accept(this);
			result = (tmp == result)?1:0;
		}
		res_str = Double.toString(result);
	}

	public void visit(Nequal val)
	{
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		if(lhs instanceof ExpString && rhs instanceof ExpString)
		{
			String tmp;
			lhs.accept(this);
			tmp = res_str;
			rhs.accept(this);
			result = (tmp.compareTo(res_str) != 0)?1:0;
		}
		else
		{
			double tmp;
			lhs.accept(this);
			tmp = result;
			rhs.accept(this);
			result = (tmp != result)?1:0;
		}
		res_str = Double.toString(result);
	}

	public void visit(Num val)
	{
		result = val.getDouble();
		res_str = Double.toString(result);
	}

	public void visit(CondBranch val)
	{
		val.getE1().accept(this);
		if(result != 0)
		{
			val.getE2().accept(this);
		}
		else
		{
			val.getE3().accept(this);
		}

		if(val.getType() == TypeChecker.ExpType.Double)
			res_str = Double.toString(result);
	}

	public void visit(Var val)
	{
		scope.getIdValue(val.getId()).accept(this);
		if(val.getType() == TypeChecker.ExpType.Double)
			res_str = Double.toString(result);
	}

	public void visit(ExpString val)
	{
		res_str = val.getString();
	}

	public void visit(PrintFunc val)
	{
		val.getExp().accept(this);
		if(val.getExp().getType() == TypeChecker.ExpType.Double)
			res_str = Double.toString(result);
		System.out.print(" = " + res_str);
	}

	public void visit(Scope val)
	{
		scope = val;
		ArrayList<Exp> arr = val.getInstructions();
		arr.get(0).accept(this);
		for(int i=1; i<arr.size(); i++)
			arr.get(i).accept(this);
		scope = scope.getParent();

	}

	public void visit(Affectation val)
	{
		val.getExp().accept(this);
		if(val.getExp().getType() == TypeChecker.ExpType.Double)
			scope.affect(val.getId(), new Num(result));
		else if(val.getExp().getType() == TypeChecker.ExpType.String)
			scope.affect(val.getId(), new ExpString(res_str));
	}
}
