package com.fp.scala.chapter3

object C3E13 extends App {

  def foldRight[A, B](xs: List[A], y: B)(f: (A, B) => B): B =
    xs.foldLeft(identity[B] _)((z, x) => z compose ((y: B) => f(x, y)))(y)

  def foldLeft[A, B](xs: List[A], z: B)(f: (B, A) => B): B =
    xs.foldRight(identity[B] _)((x, z) => z compose ((y: B) => f(y, x)))(z)

}
