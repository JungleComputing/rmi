Water is another N-body simulation from the SPLASH suite.
It simulates a collection of water molecules interacting upon each other.
It is parallelized by distributing the bodies (molecules) among the processors.
Communication is primarily required to compute interactions with bodies
assigned to remote machines.
Our Java program uses message combining to obtain high performance:
each processor receives all bodies it needs from another machine using
a single RMI. After each operation, updates are also sent using
one RMI per destination machine.
Since Water is an O(N^2) algorithm and we have optimized communication,
the relative communication overhead is low.

There is one program argument: the input file.
There are two in this directory: random.in, for a 343-body problem, and
random.1728, for a 1728-body problem.
Also, a program geninput.c is supplied that generates a new input file.
Its usage is as follows:

cc -o geninput geninput.c -lm
./geninput <timestep-length> <nr_timesteps> <nr_mols> <n_order> <n_print>
