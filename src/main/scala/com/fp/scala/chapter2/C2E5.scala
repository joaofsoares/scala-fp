package com.scala.sample.project.book.chapter2

object C2E5 extends App {

  private def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)

}
