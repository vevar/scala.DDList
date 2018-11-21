package main.scala.com.alxmyaev.model.DDList

final class SubList[sT](var maxSize: Int) {

  var head: Node[sT] = _
  var tail: Node[sT] = _

  private var currentSize: Int = 0

  def getCurrentSize: Int = {
    currentSize
  }

  def remove(index: Int): Unit = {

    var currentPosition: Node[sT] = head
    var counter = 0
    while (counter < index) {
      currentPosition = currentPosition.pointerNext
      counter = counter + 1
    }

    val removedNode: Node[sT] = currentPosition
    val backNode: Node[sT] = removedNode.pointerBack
    val nextNode: Node[sT] = removedNode.pointerNext

    backNode.pointerNext = nextNode
    nextNode.pointerBack = backNode

    if (removedNode == head) {
      head = nextNode
    } else if (removedNode == tail) {
      tail = backNode
    }

    currentSize = currentSize - 1
  }

  def add(node: Node[sT]): Unit = {
    if (currentSize < maxSize && node != null) {
      if (head == null) {
        addToHead(node)
      } else {
        addToTail(node)
      }
      currentSize = currentSize + 1
    } else {
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
