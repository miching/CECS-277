/**
 * @author Gem Balagtas, Mika Wong, Nicolas Guardado, Michael Ching
 * The Visitable interface allows for classes to be visited by the cleaning visitor. 
 * This is the entry point which enables an object to be “visited” by the visitor object.
 */
public interface Visitable {
	/**Declaration of the accept operation which will be the entry point for the visitor. */
	public abstract void accept(CleaningVisitor visitor);
}
