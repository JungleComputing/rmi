/**
 * This is an RMI implementation on top of Ibis.
 * <p>
 * This package and its sub-packages implement an (incomplete)
 * version of Java RMI on top of the Ibis communication layer.
 * <p>
 * The most notable difference with "ordinary" Java RMI applications is that
 * an Ibis RMI application must start its own RMI registry. In addition,
 * the Ibis RMI package is called ibis.rmi and not java.rmi. However,
 * the Ibis rmic takes care of that by rewriting the bytecode, so the user
 * can use java.rmi, as long as the Ibis RMI rmic is used.
 */

package ibis.rmi;
