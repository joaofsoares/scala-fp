package com.fp.scala

import scala.annotation.tailrec

object C2E1 extends App {

  private def fibonacci(n: Int): BigInt = {
    @tailrec
    def go(n: Int, prev: BigInt, next: BigInt): BigInt =
      n match {
        case 0 => prev
        case 1 => next
        case _ => go(n - 1, next, prev + next)
      }

    go(n, 0, 1)
  }

  private def formatFib(n: Int) = s"Fibonacci of $n is ${fibonacci(n)}"

  println(formatFib(20))

}
