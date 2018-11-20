package main.scala.com.alxmyaev.model.DDList

class MaxSizeSubListException extends Exception{

  val message : String = "SubList have max size"

  override def getMessage: String = message
}
