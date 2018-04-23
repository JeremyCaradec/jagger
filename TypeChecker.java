import java.util.ArrayList;

public class TypeChecker implements Visitor
{
    public enum ExpType
    {
    	Double, String, Void;
    }
    private ExpType type;
    private Scope scope;

    public TypeChecker(Exp e, Scope scope)
	{
		this.scope = scope;
		e.accept(this);
	}

	public TypeChecker(Exp e)
	{
		this(e, null);
	}

	public void setScope(Scope s)
	{
		scope =s ;
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
		type = val.getType();
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
		scope.getIdValue(val.getId()).accept(this);
	}

	public void visit(ExpString val)
	{
		type = val.getType();
	}

	public void visit(PrintFunc val)
	{
		val.getExp().accept(this);
	}

	public void visit(Scope val)
	{
		scope = val;
		ArrayList<Exp> arr = val.getInstructions();
		for(Exp e:arr)
			e.accept(this);
		scope = scope.getParent();
	}

	public void visit(Affectation val)
	{
		val.getExp().accept(this);
		if(val.getType() != ExpType.Void && val.getType() != type)
			typeError(val);
	}
}
