This directory contains a collection of Ibis RMI example programs, organized
into a number of sub-directories.  See the README files in each sub-directory
for more details on the application. The "src/shared" directory contains some
common code for all these applications.

src/rmiBench
    This program can perform various latency and throughput tests.
src/acp
    ACP (the Arc Consistency program) can be used as a first step in solving
    Constraint Satisfaction problems. It eliminates impossible values from
    domains of variables, by repeatedly applying constraints defined on pairs
    of variables.
src/asp_toplass
    All-pairs Shortest Path (ASP).  This program computes the shortest path
    between any two nodes of a given graph.
src/fft
    FFT is a complex 1D Fast Fourier Transform based on code from the SPLASH-2
    suite.
src/leq
    A linear equation solver. Each iteration refines a candidate solution
    vector into a better solution. This is repeated until the difference
    becomes smaller than a specific bound.
src/qr
    A parallel implementation of QR factorization. In each iteration, one
    column, the Householder vector H, is broadcast to all machines, which
    update their columns using H. The current upper row and H are then
    deleted from the data set so that the size of H decreases by 1 in each
    iteration. The vector with maximum norm becomes the householder vector
    for the next iteration.
src/radix
    A histogram-based parallel sort program from the SPLASH-2 suite,
    rewritten in Java+RMI. The program repeatedly performs a local sort phase,
    followed by a histogram merge phase. After this merge phase, some of the
    keys may be moved from one machine to another.
src/sor_grid
    Red/black Successive Over Relaxation (SOR) is an iterative method for
    solving discretized Laplace equations on a grid. This implementation
    distributes the grid row-wise among the CPUs. Each CPU exchanges one row
    of the matrix with its neighbours at the beginning of each iteration. 
src/tsp
    Tsp (travelling salesperson problem) computes the shortest path (roundtrip)
    for a salesperson to visit all cities in a given set exactly once, starting
    in one specific city, and ending up in the same city.
src/water
    Water is an N-body simulation from the SPLASH suite.
    It simulates a collection of water molecules interacting upon each other.
    It is parallelized by distributing the bodies (molecules) among the
    processors. Communication is primarily required to compute interactions
    with bodies assigned to remote machines.

Other files in this directory are:

build.xml
    Ant build file for building Ibis RMI applications.
    "ant build" (or simply: "ant") will build all applications that
    are present in this directory. "ant clean" will remove
    what "ant build" made.

README.txt
    What you are reading now.
