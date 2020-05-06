package com.oliverch.collection

import scala.reflect.ClassTag

class Stack[T: ClassTag](size: Int) extends IndexedSeq[T] {
  private var data = new Array[T](size)
  private var top = -1;
  override def isEmpty: Boolean = top == -1

  def isFull: Boolean = top == size-1

  def pop() = isEmpty match {
      case true => throw new NoSuchElementException("No element to pop from stack! And Stack is Empty!")
      case false => {
        val result = data(top)
        top -= 1
        result
      }
    }

  def push(t: T) = isFull match{
    case true => throw new RuntimeException("Stack is full!")
    case false => {
      top += 1
      data(top) = t
    }
  }

  def popAll() ={
    for (i <- top until -1 by -1 ) yield data(i)
  }

  override def length: Int = top + 1

  override def apply(i: Int): T = data(i)
}
