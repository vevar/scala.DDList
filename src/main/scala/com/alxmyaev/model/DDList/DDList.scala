package main.scala.com.alxmyaev.model.DDList

import java.util

class DDList[T] {
  private val DEFAULT_MAX_SIZE_BRANCHES = 3

  private var head: Node[SubList[T]] = _
  private var tail: Node[SubList[T]] = _

  private var size: Int = 0

  private var counter: Int = 0

  final class Iterator {

    private var currentBranch: Node[SubList[T]] = _
    private var currentPosition: Node[T] = _

    def isEnd: Boolean = {
      currentPosition == tail.value.tail
    }

    def begin(): Node[T] = {
      currentBranch = head
      if (head != null) {
        currentPosition = head.value.head
      }
      currentPosition
    }

    def end(): Node[T] = {
      currentBranch = tail

      if (head != null) {
        currentPosition = tail.value.tail
      }
      currentPosition
    }

    def next(): Node[T] = {
      if (currentPosition == null || currentBranch == null) {
        currentBranch = head
        currentPosition = currentBranch.value.head
      } else {
        if (currentPosition != currentBranch.value.tail) {
          currentPosition = currentPosition.pointerNext
        } else {
          currentBranch = currentBranch.pointerNext
          currentPosition = currentBranch.value.head
        }
      }

      currentPosition
    }

    def back(): Node[T] = {
      if (currentPosition == null || currentBranch == null) {
        currentBranch = tail
        currentPosition = currentBranch.value.tail
      } else {
        if (currentPosition != currentBranch.value.head) {
          currentPosition = currentPosition.pointerBack
        } else {
          currentBranch = currentBranch.pointerBack
          currentPosition = currentBranch.value.tail
        }
      }

      currentPosition
    }

    def getCurrentBranch: Node[SubList[T]] = {
      currentBranch
    }

    def getCurrentPosition: Node[T] = {
      currentPosition
    }

    def forEach[U](function: T => U): Unit = {
      if (size > 0) {
        function(begin().value)
        while (!isEnd) {
          function(next().value)
        }
      }
    }
  }

  final private def addToHead(node: Node[T]): Unit = {
    head = new Node[SubList[T]](new SubList[T](DEFAULT_MAX_SIZE_BRANCHES))
    head.pointerNext = head
    head.pointerBack = head
    tail = head

    addToCurrentTail(node)
  }

  final private def addToNewTail(node: Node[T]): Unit = {
    val newTail = new Node[SubList[T]](new SubList[T](DEFAULT_MAX_SIZE_BRANCHES))

    tail.pointerNext = newTail
    newTail.pointerBack = tail

    newTail.pointerNext = head
    head.pointerBack = newTail

    tail = newTail

    addToCurrentTail(node)
  }

  final private def addToTail(node: Node[T]): Unit = {
    if (tail.value.getCurrentSize < tail.value.maxSize) {
      addToCurrentTail(node)
    } else {
      addToNewTail(node)
    }
  }

  final private def addToCurrentTail(node: Node[T]): Unit = {
    try {
      tail.value.add(node)
    } catch {
      case exception: MaxSizeSubListException =>
        exception.printStackTrace()
        addToNewTail(node)
    }
  }

  final def getSize: Int = {
    size
  }

  final def add(element: T): Unit = {
    val node: Node[T] = new Node[T](element)
    if (head == null) {
      addToHead(node)
    } else {
      addToTail(node)
    }
    size = size + 1
  }

  final def add(element: T, index: Int): Unit = {
    if (index <= size) {
      if (index == size) {
        add(element)
      } else {
        getNodeByIndexFromBranch(getBranchByIndex(index), index).value = element
      }
    } else {
      throw new ArrayIndexOutOfBoundsException()
    }
  }

  final private def getNodeByIndexFromBranch(currentBranch: Node[SubList[T]], index: Int): Node[T] = {
    var currentNode: Node[T] = currentBranch.value.head

    while (counter < index) {
      currentNode = currentNode.pointerNext
      counter = counter + 1
    }

    currentNode
  }

  final private def getBranchByIndex(index: Int): Node[SubList[T]] = {
    counter = 0
    var currentBranch: Node[SubList[T]] = head
    var sizeCurrentBranch: Int = currentBranch.value.getCurrentSize

    while (counter < index - sizeCurrentBranch) {
      currentBranch = currentBranch.pointerNext
      sizeCurrentBranch = currentBranch.value.getCurrentSize
      counter = counter + sizeCurrentBranch
    }

    currentBranch
  }

  final def get(index: Int): T = {
    if (index < size) {
      getNodeByIndexFromBranch(getBranchByIndex(index), index).value
    } else {
      throw new ArrayIndexOutOfBoundsException()
    }
  }

  final private def removeNode(getCurrentPosition: Node[T]): Unit = {
    val removedNode: Node[T] = getCurrentPosition
    val backNode: Node[T] = removedNode.pointerBack
    val nextNode: Node[T] = removedNode.pointerNext

    backNode.pointerNext = nextNode
    nextNode.pointerBack = backNode

    removedNode.pointerNext = null
    removedNode.pointerBack = null
  }

  final private def removeBranch(getCurrentPosition: Node[SubList[T]]): Unit = {
    val removedNode: Node[SubList[T]] = getCurrentPosition
    val backNode: Node[SubList[T]] = removedNode.pointerBack
    val nextNode: Node[SubList[T]] = removedNode.pointerNext

    backNode.pointerNext = nextNode
    nextNode.pointerBack = backNode

    removedNode.pointerNext = null
    removedNode.pointerBack = null
  }

  final def remove(index: Int): Unit = {
    if (index < size) {
      val removedBranch = getBranchByIndex(index)

      if (removedBranch.value.getCurrentSize == 1) {
        removeBranch(removedBranch)
      } else {
        removeNode(getNodeByIndexFromBranch(removedBranch, index))
      }
    } else {
      throw new ArrayIndexOutOfBoundsException()
    }
  }

  final def forEach[U](function: T => U): Unit = {
    new Iterator().forEach(function)
  }

  def sort(compareFunction: Ordering[T]): DDList[T] = {
    if (compareFunction != null) {
      val sortedList = new DDList[T]()

      val sortList = new util.ArrayList[T]()
      forEach(sortList.add)
      sortList.sort(compareFunction)

      sortList.forEach(sortedList.add)
      sortedList
    } else {
      null
    }
  }
}
