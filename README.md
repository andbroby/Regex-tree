# Regex-tree

__I haven't written tests for it (yet), so it's likely bugs exist.__

I was thinking of ways to do regex matching by using a tree instead of having to construct an NFA/DFA and came across [this](http://morepypy.blogspot.no/2010/05/efficient-and-elegant-regular.html). 


This is an implementation of the algorithm described in the blog with some small adjustments. The construction of the tree is similar to the construction of an NFA using Thompson's construction algorithm. Abstracting the finite automaton as a tree lets us easily match regexes in linear time (we don't have to potentially backtrack after epsilon transitions) and avoids the potential memory wastage from a DFA. I think it's a pretty neat solution, although it might not be as intuitive as an automaton.
