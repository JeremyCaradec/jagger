public class Eval implements Visitor
{
	private double result;

	public Eval(Exp e)
	{
		result = 0.0;
		e.accept(this);
	}

	public double result()
	{
		return result;
	}

	public void visit(Add val)
	{
		double tmp;
		val.getLhs().accept(this);
		tmp = result;
		val.getRhs().accept(this);
		result = tmp + result;
	}
	
	public void visit(Mul val)
	{
		double tmp;
		val.getLhs().accept(this);
		tmp = result;
		val.getRhs().accept(this);
		result = tmp * result;
	}

	public void visit(Sub val)
	{
		double tmp;
		val.getLhs().accept(this);
		tmp = result;
		val.getRhs().accept(this);
		result = tmp - result;
	}

	public void visit(Div val)
	{
		double tmp;
		val.getLhs().accept(this);
		tmp = result;
		val.getRhs().accept(this);
		result = tmp / result;
	}

	public void visit(Neg val)
	{
		val.getExp().accept(this);
		result = -result;
	}

	public void visit(Lt val)
	{
		double tmp;
		val.getLhs().accept(this);
		tmp = result;
		val.getRhs().accept(this);
		result = (tmp < result)?1:0;
	}

	public void visit(Le val)
	{
		double tmp;
		val.getLhs().accept(this);
		tmp = result;
		val.getRhs().accept(this);
		result = (tmp <= result)?1:0;
	}

	public void visit(Gt val)
	{
		double tmp;
		val.getLhs().accept(this);
		tmp = result;
		val.getRhs().accept(this);
		result = (tmp > result)?1:0;
	}

	public void visit(Ge val)
	{
		double tmp;
		val.getLhs().accept(this);
		tmp = result;
		val.getRhs().accept(this);
		result = (tmp >= result)?1:0;
	}

	public void visit(Equal val)
	{
		double tmp;
		val.getLhs().accept(this);
		tmp = result;
		val.getRhs().accept(this);
		result = (tmp == result)?1:0;
	}

	public void visit(Nequal val)
	{
		double tmp;
		val.getLhs().accept(this);
		tmp = result;
		val.getRhs().accept(this);
		result = (tmp != result)?1:0;
	}

	public void visit(Num val)
	{
		result = val.getDouble();
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
	}

	public void visit(Var val)
	{
		Scope.getIdValue(val.getId()).accept(this);
	}
}
