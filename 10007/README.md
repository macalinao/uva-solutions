10007
=====

Status: **Accepted**

To be honest, I gave up after spending some time writing an incorrect recursive solution.

[http://gatecse.in/wiki/Number_of_Binary_trees_possible_with_n_nodes]

I used this formula. Basically, you need to calculate the number of ways the edges can fit on the graph.

The first edge has 2n possibilities, since it can be either a left or a right child. Then you take the product, subtracting 1 each time since there's one less permutation for each edge you find, all the way to n - 2. This yields the answer.

This also has to do with Catalan numbers, which are a sequence of natural numbers that are common in recursively defined objects. The answer would be `C_n n!`.

I should probably read up on these numbers, as combinatorics problems are pretty common in ACM-type competitions.
