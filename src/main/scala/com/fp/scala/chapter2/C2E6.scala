package com.scala.sample.project.book.chapter2

object C2E6 extends App {

  private def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))

}
