package com.fp.scala

import scala.annotation.tailrec

object C2 extends App {

  private def formatResult(name: String, n: Int, f: Int => Int): String = {
    s"the $name of $n is ${f(n)}"
  }

  private def abs(n: Int): Int = if (n < 0) -n else n

  private def factorial(n: Int): Int = {
    @tailrec
    def go(n: Int, acc: Int): Int = if (n <= 0) acc else go(n - 1, n * acc)

    go(n, 1)
  }

  println(formatResult("absolute value", -42, abs))
  println(formatResult("factorial", 7, factorial))

}
