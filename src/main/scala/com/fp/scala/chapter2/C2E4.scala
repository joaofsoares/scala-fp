package com.scala.sample.project.book.chapter2

object C2E4 extends App {

  private def curry[A, B, C](f: (A, B) => C): A => (B => C) = a => b => f(a, b)

}
