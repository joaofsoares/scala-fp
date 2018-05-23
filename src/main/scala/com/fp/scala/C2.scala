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

  private def binarySeach[A](as: Array[A], key: A, gt: (A, A) => Boolean): Int = {
    @tailrec
    def go(low: Int, mid: Int, high: Int): Int = {
      if (low > high) -mid - 1
      else {
        val mid2 = (low + high) / 2
        val a = as(mid2)
        val greater = gt(a, key)
        if (!greater && !gt(key, a)) mid2
        else if (greater) go(low, mid2, mid2 - 1)
        else go(mid2 + 1, mid2, high)
      }
    }

    go(0, 0, as.length - 1)
  }

  println(formatResult("absolute value", -42, abs))
  println(formatResult("factorial", 7, factorial))

  println(formatResult("increment", 7, _ + 1))

}
