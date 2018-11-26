package main.scala.com.alxmyaev.model.DDList

final class Node[T](var value : T ) extends Serializable {
  var pointerNext : Node[T] = _
  var pointerBack : Node[T] = _

}
