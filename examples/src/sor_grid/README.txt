Red/black Successive Over Relaxation (SOR) is an iterative method for solving
discretized Laplace equations on a grid.
This implementation is an RMI version. It distributes the grid row-wise among
the CPUs. Each CPU exchanges one row of the matrix with its neighbours at the
beginning of each iteration. 

The program options are: <NROW> <NCOL> <NITERATIONS> <COMMUNICATION>
where
    <NROW> is the number of rows in the array,
    <NCOL> is the number of columns in the array,
    <NITERATIONS> is the number of iterations (when set to zero, the
	number of iterations is determined dynamically, using a threshold for
	the sum of the differences),
    and <COMMUNICATION> is either "async", which means that there are separate threads
	that deal with the communication of border rows, or "sync", which means that the
	computation thread also deals with the communication. The "async" version has
	the advantage that it can do computations on the inner rows while waiting for border
	rows from other CPUs.
