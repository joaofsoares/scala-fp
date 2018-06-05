package com.fp.scala.chapter3

object C3E11 extends App {

  def length[A](xs: List[A]): Int = xs.foldLeft(0)((n, _) => n + 1)

  def sum[A](xs: List[A])(implicit num: Numeric[A]): A =
    xs.foldLeft(num.zero)(sum(_, _))

  def product[A](xs: List[A])(implicit num: Numeric[A]): A =
    xs.foldLeft(num.one)(times)

  def times[A: Numeric](x: A, y: A): A = {
    val n = implicitly[Numeric[A]]
    n.times(x, y)
  }
}
