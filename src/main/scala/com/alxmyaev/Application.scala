package main.scala.com.alxmyaev

import main.scala.com.alxmyaev.DDList.DDList

import scala.util.Random

object Application extends App {

  val ddList = new DDList[Int]()
  val random = new Random()
  for (i <- 0 to 10) {
    ddList.add(random.nextInt(100))
  }

  ddList.forEach(println)
  val ord = new Ordering[Int]() {
    override def compare(x: Int, y: Int): Int = x compare y
  }
  val sortedList = ddList.sort(ord)

  println

  sortedList.forEach(println)
}
