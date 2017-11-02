# Algorith-MX Group - Session 7

## Topic: Recursion

### Overview

In mathematics, _Recursion (Recursivity, Recursiveness)_ is when a concept is defined in terms of itself or of its type and depends on smaller instances of the same concept (as opposed to iteration) following two properties:

* A **base case** -  a scenario when the definition ends and does not use recursion to produce an answer.

* A **set of rules** - logic to reduce all the cases (except the simplest) toward the base case.

 This means that, by definition, recursive solutions are built off of **solutions to subproblems**. Problems to _compute the nth_ , i.e. *f(n)*, are often good candidates for recursion. 


>"The power of recursion evidently lies in the possibility of defining an infinite set of objects by a finite statement. In the same manner, an infinite number of computations can be described by a finite recursive program, even if this program contains no explicit repetitions." — Wirth, Niklaus


### Implementations

A recursive algorithm can be very space inefficient. Since all recursive algorithms can be implemented iteratively, it's sometimes better to implement a recursive algorithm **iteratively**. 

Recursion can be implemented in mathematic operations such as factorial, Fibonacci series and more complex situations using *functional programming* to improve performance and maintainability to the code.

Divide-and-conquer approach to solve big problems by dividing them in small pieces that in this case, simplify the logic to call *x* times *y* code.

#### Mathematics
There are some math functions that can be implemented by recursion:

##### Natural numbers

```
0 is N
if n is in N, then n + 1 is in N
```

##### Fibonacci series

Compute the *nth* Fibonacci number.

```
For all integers n > 1, Fib(n) := Fib(n - 1) + Fib(n - 2).
```

```java
int fibonacci(int n) {
    if(n==0)
        return 0;
    if(n==1)
        return 1;
    
    else return fibonacci(n-1) + fibonacci(n-2);
}

```

**What is the runtime?**

Try drawing the code paths as a tree. The leaves `fib(0)` and `fig(1)` represent the base cases.

**How many nodes are in the tree?**

Each node has two children. Do this for **n** and gives us a runtime of roughly *O(2^n)*, i.e. exponential runtime.


##### Factorial

```
n! = { 1                  if n = 0  
       (n - 1)! x n       if n > 0
```

```javascript
/** -------------------- NO RECURSION -------------------- **/

function factorial(num)
{
    // If the number is less than 0, reject it.
    if (num < 0) {
        return -1;
    }
    // If the number is 0, its factorial is 1.
    else if (num == 0) {
        return 1;
    }
    var acc = num;
    while (num-- > 2) {
        acc *= num;
    }
    return acc;
}

var result = factorial(8);

// Output: 40320
```

```javascript
/** ------------------- USING RECURSION ------------------- **/

function factorial(num)
{
    // If the number is less than 0, reject it.
    if (num < 0) {
        return -1;
    }
    // If the number is 0, its factorial is 1.
    else if (num == 0) {
        return 1;
    }
    // Otherwise, call this recursive procedure again.
    else {
        return (num * factorial(num - 1));
    }
}

var result = factorial(8);

// Output: 40320
```

### Problems

Given a nested array, write a function to flatten it.

```
definition:   array[] = [1,2,[3,[4,5],6],7];
output:        // [1,2,3,4,5,6,7]
```

#### [Inverted Binary Tree](https://leetcode.com/problems/invert-binary-tree/description/)
>Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off. — Max Howell
[@mxcl](https://twitter.com/mxcl/status/608682016205344768)



### Extra Problem

As an Oxxo worker, I need to determine the number of ways
in which I can return change. I will be given the amount to
be returned and the denominations of the coins.

Sample Input and Output
```
amount: 4
coins : [1,2]
output: 3 ([1,1,1,1],[1,1,2],[2,2])
```
