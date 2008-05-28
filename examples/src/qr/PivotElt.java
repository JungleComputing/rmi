/* $Id$ */

package qr;


import java.io.Serializable;

class PivotElt implements Serializable {

    private static final long serialVersionUID = 1L;

    double norm;

    double max_over_max_cols;

    int index;

    int cols;

    int max_cols;
}
