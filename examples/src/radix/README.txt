Radix is a histogram-based parallel sort program from the SPLASH-2 suite,
rewritten in Java+RMI. The program repeatedly performs a local sort phase,
followed by a histogram merge phase. After this merge phase, some of the keys
may be moved from one machine to another.
The program options are:
    -r<num> : <num> = radix for sorting. Must be power of 2.
    -n<num> : <num> = number of keys to sort.
    -s      : Print individual processor timing statistics.
    -t      : Check to make sure all keys are sorted.
    -o      : Print out sorted keys.
    -h      : Print out program options.
The default options are: -r1024 -n1000000
