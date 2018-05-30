package com.scala.sample.project.book.chapter3

object C3E07 extends App {

  sealed trait List[+A]

  case object Nil extends List[Nothing]

  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {

    def product[A, B >: A](xs: List[A])(implicit n: Numeric[B]): B = {
      def continue(x: B, acc: => B): B = {
        if (x == n.zero) x
        else acc
      }
      foldRight(xs)(continue, n.one)(n.times)
    }

    def foldRight[A, B](xs: List[A])(continue: (A, => B) => B, z: B)(f: (A, B) => B): B =
      xs match {
        case Nil        => z
        case Cons(h, t) => continue(h, f(h, foldRight(t)(continue, z)(f)))
      }
  }
}
