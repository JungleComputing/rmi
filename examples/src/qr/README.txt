QR is a parallel implementation of QR factorization. In each iteration, one
column, the Householder vector H, is broadcast to all machines, which update
their columns using H. The current upper row and H are then deleted from the data
set so that the size of H decreases by 1 in each iteration. The vector with
maximum norm becomes the householder vector for the next iteration.

The program takes one argument: the vector size.
