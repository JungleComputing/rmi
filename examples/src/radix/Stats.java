/* $Id$ */

package radix;


import java.io.Serializable;

class Stats implements Serializable {

    private static final long serialVersionUID = 1L;
    
    long sortTime, totalTime, mergeTime, histogramTime, permuteTime;

    Stats() {
        sortTime = 0;
        totalTime = 0;
        mergeTime = 0;
        histogramTime = 0;
        permuteTime = 0;
    }
}
