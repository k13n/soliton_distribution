Soliton Distribution
====================

This small Java project implements a random number generator according to the
[soliton distribution](http://en.wikipedia.org/wiki/Soliton_distribution).
The distribution, introduced by Michael Luby in his paper "LT Codes", has two
forms, one known as the **ideal soliton distribution** and the other being the
**robust soliton distribution**. Both distributions are implemented in this
project.


Ideal Soliton Distribution
---------------------------

The ideal soliton distribution has only one parameter, namely the number of
blocks of a file. The following small piece of Java code shows how to set up a
random number generator according to this distribution.

```java
int nrBlocks = 1000;
SolitonGenerator srng = new IdealSolitonGenerator(nrBlocks);
srng.next();
```


Robust Soliton Distribution
---------------------------

This distribution is implemented by the class ```RobustSolitonGenerator```
and has two ways of creating random numbers. In the original definition
the robust soliton distribution has three parameters:

* number of blocks
* the admissible failure probability
* a strictly positive constant c

The constant **c** influences the position of a spike in the distribution.
Altough any value for c is possible, it is recommended to use values
smaller than 1. The admissible failure probability ranges from 0 to 1,
usually smaller values like 1% or 5% make sense. It follows a small example
on how to use the distribution in Java:

```java
int nrBlocks = 1000;
double failureProbability = 0.01;
double c = 0.2;
SolitonGenerator srng = new RobustSolitonGenerator(nrBlocks, c, failureProbability);
srng.next();
```

The other definition yields an equivalent distribution, however the
parameters differ slightly:

* number of blocks
* the admissible failure probability
* the position of the spike

Instead of passing the constant c one can use the more intuitive parameter
**spike** which describes the position of the spike in the distribution.

```java
int nrBlocks = 1000;
double failureProbability = 0.01;
int spike = 40;
SolitonGenerator srng = new RobustSolitonGenerator(nrBlocks, spike, failureProbability);
srng.next();
```
