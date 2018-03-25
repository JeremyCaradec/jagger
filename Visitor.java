interface Visitor
{
	public void visit(Add v);
	public void visit(Sub v);
	public void visit(Mul v);
	public void visit(Div v);
	public void visit(Num v);
	public void visit(Neg v);
	public void visit(Ge v);
	public void visit(Gt v);
	public void visit(Le v);
	public void visit(Lt v);
	public void visit(Equal v);
}
