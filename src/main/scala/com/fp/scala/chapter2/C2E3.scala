package com.scala.sample.project.book.chapter2

object C2E3 extends App {

  private def partial1[A, B, C](a: A, f: (A, B) => C): B => C = (b: B) => f(a, b)

}
