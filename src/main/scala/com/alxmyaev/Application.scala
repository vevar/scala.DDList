package main.scala.com.alxmyaev

import main.scala.com.alxmyaev.DDList.DDList

object Application extends App {
  private val ddList = new DDList[Int]()
  for (i <- 0 to 10){
    ddList.add(i)
  }

  println(ddList.get(5))
  println(ddList.get(10))
  println(ddList.get(0))
}
