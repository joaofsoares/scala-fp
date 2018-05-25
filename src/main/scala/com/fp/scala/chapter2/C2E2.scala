package com.scala.sample.project.book.chapter2

object C2E2 extends App {

  private def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
    val newAsList = as.toList
    if (newAsList.isEmpty) false
    else {
      val newAsSortedList = as.sortWith(gt).toList
      newAsList == newAsSortedList
    }
  }

  println(isSorted(Array(1, 3, 2, 4, 5), (x: Int, y: Int) => x > y))
  println(isSorted(Array(1, 3, 2, 4, 5), (x: Int, y: Int) => x < y))
  println(isSorted(Array(1, 2, 3, 4, 5), (x: Int, y: Int) => x > y))
  println(isSorted(Array(1, 2, 3, 4, 5), (x: Int, y: Int) => x < y))

}
