/**
 * @author Gem Balagtas, Mika Wong, Nicolas Guardado, Michael Ching
 * This is an interface or an abstract class used to declare the visit 
 * operations for all types of visitable classes.
 */
public interface Visitor {
	/**Declaration of the visit methods.*/
	public abstract void visit(BasicRoom basic);
	public abstract void visit(DeluxeRoom deluxe);
	public abstract void visit(SuiteRoom suite);
}
