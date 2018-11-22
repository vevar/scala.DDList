package main.scala.com.alxmyaev.model.DDList

trait IList[T] {
  def add(element: T): Unit

  def add(element: T, index: Int): Unit

  def remove(index: Int): Unit

  def get(index: Int): T

  def sort(compareFunction: Ordering[T]): IList[T]

  def getSize: Int

  def forEach[U](function: T => U): Unit
}
