package com.scala.sample.project.book.chapter3

import scala.annotation.tailrec

object C3 extends App {

  sealed trait List[+A]

  case object Nil extends List[Nothing]

  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {
    def sum(ints: List[Int]): Int = ints match {
      case Nil         => 0
      case Cons(x, xs) => x + sum(xs)
    }

    def sum2(l: List[Int]) =
      foldRight(l, 0.0)(_ + _)

    def product(ds: List[Double]): Double = ds match {
      case Nil          => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(x, xs)  => x * product(xs)
    }

    def product2(l: List[Double]) =
      foldRight(l, 1.0)(_ * _)

    def apply[A](as: A*): List[A] =
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))

    def foldRight[A, B](l: List[A], z: B)(f: (A, B) => B): B =
      l match {
        case Nil         => z
        case Cons(x, xs) => f(x, foldRight(xs, z)(f))
      }

    def tail[A](l: List[A]): List[A] =
      l match {
        case Nil        => Nil
        case Cons(_, t) => t
      }

    @tailrec
    def drop[A](l: List[A], n: Int): List[A] =
      l match {
        case Nil        => Nil
        case Cons(h, t) => drop(t, n - 1)
      }

    @tailrec
    def dropWhile[A](l: List[A])(f: A => Boolean): List[A] =
      l match {
        case Cons(h, t) if f(h) => dropWhile(t)(f)
        case _                  => l
      }

    def setHead[A](l: List[A], x: A): List[A] =
      l match {
        case Nil        => List(x)
        case Cons(h, t) => Cons(x, t)
      }

    def append[A](a1: List[A], a2: List[A]): List[A] =
      a1 match {
        case Nil        => a2
        case Cons(h, t) => Cons(h, append(t, a2))
      }

    def init[A](l: List[A]): List[A] =
      l match {
        case Nil          => Nil
        case Cons(_, Nil) => Nil
        case Cons(h, t)   => Cons(h, init(t))
      }
  }

  val example = Cons(1, Cons(2, Cons(3, Nil)))
  val example2 = List(1, 2, 3)
  val total = List.sum(example)

}
