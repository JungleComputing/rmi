All-pairs Shortest Path (ASP).

This program computes the shortest path between any two nodes of a given graph.
It uses a distance table that is distributed row-wise among the CPUs. At the
beginning of each iteration, one machine needs to send a row of the matrix to
all other machines. Since the Java RMI model lacks support for broadcasting,
this communication pattern is expressed using a spanning tree. Each CPU
forwards the message along a binomial tree to two other CPUs, using RMIs
and possibly threads.

The program options are: <n> [-threads] [-thread-pool]
where
    <n> is the number of rows (and columns) in the distance table,
    the option -threads indicates that separate threads should be used for
    communication,
    the option -thread-pool indicates that communication threads should be
    reused when possible and implicates -threads.
