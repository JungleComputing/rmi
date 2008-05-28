/* $Id$ */

package rmiBench;

public class B extends A implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    int j;
    transient Object tO;
    transient int tI;

    B() {
    }

    B(int i) {
	super(i);
	j = i;
    }
}
