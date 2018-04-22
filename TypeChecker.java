public class TypeChecker implements Visitor
{
    public enum ExpType
    {
    	Double, String, Void;
    }
    private ExpType type;

	public TypeChecker(Exp e)
	{
		e.accept(this);
	}

	public void typeError(Exp e) throws TypeError
	{
		System.out.println("Incorrect types in the following expression:");
		new PPrinter(e);
		throw new TypeError("");
	}

	public ExpType type()
	{
		return type;
	}

	public void visit(Add val)
	{
		ExpType type_tmp;
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		lhs.accept(this);
		type_tmp = type;
		rhs.accept(this);
		if(type_tmp == ExpType.Double && type == ExpType.Double || type_tmp == ExpType.String && type == ExpType.String)
			val.setType(type);
		else
			typeError(val);		
	}
	
	public void visit(Mul val)
	{
		ExpType type_tmp;
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		lhs.accept(this);
		type_tmp = type;
		rhs.accept(this);
		if(type_tmp == ExpType.Double && type == ExpType.Double)
			val.setType(type);
		else
			typeError(val);
	}

	public void visit(Sub val)
	{
		ExpType type_tmp;
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		lhs.accept(this);
		type_tmp = type;
		rhs.accept(this);
		if(type_tmp == ExpType.Double && type == ExpType.Double)
			val.setType(type);
		else
			typeError(val);
	}

	public void visit(Div val)
	{
		ExpType type_tmp;
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		lhs.accept(this);
		type_tmp = type;
		rhs.accept(this);
		if(type_tmp == ExpType.Double && type == ExpType.Double)
			val.setType(type);
		else
			typeError(val);
	}

	public void visit(Neg val)
	{
		val.getExp().accept(this);
		if(type == ExpType.Double)
			val.setType(type);
		else
			typeError(val);
	}

	public void visit(Lt val)
	{		
		ExpType type_tmp;
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		lhs.accept(this);
		type_tmp = type;
		rhs.accept(this);
		if(type_tmp == ExpType.Double && type == ExpType.Double || type_tmp == ExpType.String && type == ExpType.String)
		{
			val.setType(ExpType.Double);	
			type = ExpType.Double;
		}
		else
			typeError(val);
	}

	public void visit(Le val)
	{
		ExpType type_tmp;
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		lhs.accept(this);
		type_tmp = type;
		rhs.accept(this);
		if(type_tmp == ExpType.Double && type == ExpType.Double || type_tmp == ExpType.String && type == ExpType.String)
			{val.setType(ExpType.Double);
						type = ExpType.Double;}
		else
			typeError(val);
	}

	public void visit(Gt val)
	{
		ExpType type_tmp;
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		lhs.accept(this);
		type_tmp = type;
		rhs.accept(this);
		if(type_tmp == ExpType.Double && type == ExpType.Double || type_tmp == ExpType.String && type == ExpType.String){
					val.setType(ExpType.Double);
					type = ExpType.Double;}
		else
			typeError(val);
	}

	public void visit(Ge val)
	{
		ExpType type_tmp;
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		lhs.accept(this);
		type_tmp = type;
		rhs.accept(this);
		if(type_tmp == ExpType.Double && type == ExpType.Double || type_tmp == ExpType.String && type == ExpType.String)
			{val.setType(ExpType.Double);
						type = ExpType.Double;}
		else
			typeError(val);
	}

	public void visit(Equal val)
	{
		ExpType type_tmp;
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		lhs.accept(this);
		type_tmp = type;
		rhs.accept(this);
		if(type_tmp == ExpType.Double && type == ExpType.Double || type_tmp == ExpType.String && type == ExpType.String)
			{val.setType(ExpType.Double);
						type = ExpType.Double;}
		else
			typeError(val);
	}

	public void visit(Nequal val)
	{
		ExpType type_tmp;
		Exp lhs = val.getLhs();
		Exp rhs = val.getRhs();
		lhs.accept(this);
		type_tmp = type;
		rhs.accept(this);
		if(type_tmp == ExpType.Double && type == ExpType.Double || type_tmp == ExpType.String && type == ExpType.String)
		{
			val.setType(ExpType.Double);
			type = ExpType.Double;
		}
		else
			typeError(val);
	}

	public void visit(Num val)
	{
		type = ExpType.Double;
	}

	public void visit(CondBranch val)
	{
		ExpType type_tmp;
		val.getE1().accept(this);
		if(type == ExpType.String)
			typeError(val);

		val.getE2().accept(this);
		type_tmp = type;
		
		val.getE3().accept(this);
		
		if(type_tmp == ExpType.Double && type == ExpType.Double || type_tmp == ExpType.String && type == ExpType.String)
			val.setType(type);
		else
			typeError(val);
	}

	public void visit(Var val)
	{
		Scope.getIdValue(val.getId()).accept(this);
		val.setType(type);
	}

	public void visit(ExpString val)
	{
		type = ExpType.String;
	}
}
