package complexity;

/**
 * Implementations of this class should have names suggesting a particular complexity class, and should implement
 * the {@link #method(int)} and {@link #complexity(int)} complexity methods in a way that corresponds to the class name.
 * E.g. an implementation of this interface called <tt>Linear</tt> should implement {@link #method(int)} such that it
 * has linear (time) complexity (in its parameter <tt>n</tt>), and implement {@link #complexity(int)} such that it
 * implements a linear function of its parameter <tt>n</tt> (the obvious function being f(n)=n).
 * <p>
 * Rather than directly implementing this interface, implementations will normally extend the abstract class
 * {@link Timer}, which provides facilities for timing execution of {@link #method(int)}  and comparing its actual
 * execution time to that specified by the corresponding implementation of {@link #complexity}.
 * </p>
 *
 * @author Hugh Osborne
 * @version March 2020
 */

public interface Method
{
    /**
     * Implementations of <tt>method</tt> should have the complexity appropriate to the implementing class (as indicated by the
     * class's name).  E.g. an implementation of <tt>method</tt> in a class called <tt>Linear</tt> should have linear
     * (time) complexity.
     * @param n the "size" of the call to method
     */
    public void method(int n);

    /**
     * Implementations of <tt>complexity</tt> should implement a function of the parameter <tt>n</tt> that
     * is appropriate to the implementing class (as indicated by the class's name).  E.g. an implementation of
     * <tt>complexity</tt> in a class called <tt>Linear</tt> might implement f(n)=n.
     * @param n the "size" of the "problem"
     * @return a value that grows in line with the complexity class modelled
     */
    public double complexity(int n);
}
