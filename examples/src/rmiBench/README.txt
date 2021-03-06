Rmi-bench is a program that can perform various latency and throughput tests.
There is a client thread that sends a number of messages to a server, to which
the server gives a reply.

The program takes to (optional) integer parameters. The first one, <count>,
indicates the number of messages to be sent by the client. The second one,
<size>, indicates the size of each message. The default <count> is 10000, the
default <size> is 0, which, without any other options, gives a latency test.

The possible program options are:

-one-way
    Send data one-way, the server sends empty replies (when sending data, the
    default behavior is that the server sends back the data it receives.

-byte
-int
-float
-double
    Send an array of the type indicated, the total size in bytes is given
    in the <size> parameter. The default type is an array of bytes.

-int2
    Send two integer parameters. Server gives an empty reply.

-int32
    Send an object containing 32 integers. A possible <size> parameter is ignored
    in this case.

-tree
    Send a binary tree with <size> nodes, each node containing 4 integers and a
    "left" and "right" reference.

-cyc
    Send a cyclic linked list of <size> nodes, each node containing a double,
    an int, and a "next" reference.

-warmup <num>
    Do <num> warmup RMIs before starting measurements. The default <num> is 1000.

-registry <name>
    Normal operation is that the server also sets up an RMI registry.
    With this option, another registry can be used.

-client-worker
    Let the client have a compute thread.

-server-worker
    Let the server have a compute thread.
