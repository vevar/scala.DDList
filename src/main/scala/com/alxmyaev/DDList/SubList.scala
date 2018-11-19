package main.scala.com.alxmyaev.DDList

final class SubList[sT](var maxSize: Int) {

  var head: Node[sT] = _
  var tail: Node[sT] = _

  private var currentSize: Int = 0

  def getCurrentSize: Int = {
    currentSize
  }


  def add(node: Node[sT]): Unit = {
    if (currentSize < maxSize && node != null) {
      if (head == null) {
        addToHead(node)
      } else {
        addToTail(node)
      }
      currentSize = currentSize + 1
    }else{
      throw new MaxSizeSubListException()
    }

  }

  def addToTail(node: Node[sT]): Unit = {
    tail.pointerNext = node
    node.pointerBack = tail

    node.pointerNext = head
    head.pointerBack = node

    tail = node

  }

  def addToHead(node: Node[sT]): Unit = {
    head = node
    head.pointerNext = head
    head.pointerBack = head
    tail = head
  }
}
