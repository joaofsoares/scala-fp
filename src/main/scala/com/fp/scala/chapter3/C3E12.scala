package com.fp.scala.chapter3

object C3E12 extends App {

  sealed trait List[+A]

  case object Nil extends List[Nothing]

  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {

    def foldLeft[A, B](xs: List[A], z: B)(f: (B, A) => B): B =
      xs match {
        case Nil => z
        case Cons(h, t) => f(h, foldLeft(t, z)(f))
      }

    def reverse[A](xs: List[A]): List[A] =
      foldLeft(xs, List[A]())((acc, h) => Cons(h, acc))

  }

}
