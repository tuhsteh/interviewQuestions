# interviewQuestions
Contains programming solutions to a variety of interview questions, as well as some experiments.  Many though not all of these are my own answers (Factorial, Fibonacci, isPrime, orderedAndBalanced, and a few others), and code I wrote to solve them.  The sorting algorithms are definitely not mine, nor the tree traversals.

Over the years, whenever I would participate in interviewing a candidate for SDET or for a Java Developer position, 
I got into the habit of saving their answers, or at least the algorithms.  This way I could:
 * learn from their ways of thinking about various problems
 * learn from mistakes they made during the interview or on the board
 * sometimes try out their algorithm to see why it even worked at all
 * to better understand the question we interviewers were asking
 
Some of the problems still aren't completely clear to me, like how some of the sorting algorithms really work (HeapSort for instance), or how the Level-Order Tree Traversal worked.  But I have a better understanding of some of the most important parts.

Also in this repository are some experiments I put together, or some algorithm comparisons I wanted to try out.  

## Java Tests

This is a Maven project, so a recent release of Maven3, along with JDK 8 if you can still get it, will be all you need to get things running.

`mvn clean install`

## Now with Cypress.io

Also included here are a handful of tests that operate in Cypress framework for JavaScript-based web app testing.

Install dependencies first for your platform:

`yarn install`

Then run tests:

`yarn cypress open`

or 

`yarn cypress run`


