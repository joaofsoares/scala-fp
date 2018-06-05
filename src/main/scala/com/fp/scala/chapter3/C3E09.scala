package com.fp.scala.chapter3

object C3E09 extends App {

  def length[A](xs: List[A]): Int = xs.foldRight(0)((_, n) => n + 1)

}
