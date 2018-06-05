package com.fp.scala.chapter3

object C3E14 extends App {

  sealed trait List[+A]

  case object Nil extends List[Nothing]

  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {

    def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = // Utility functions
      as match {
        case Nil => z
        case Cons(x, xs) => f(x, foldRight(xs, z)(f))
      }

    def append[A](l: List[A], r: List[A]): List[A] =
      foldRight(l, r)(Cons(_, _))

  }

}
