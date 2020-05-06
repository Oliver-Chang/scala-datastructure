package com.oliverch.collection

import scala.reflect.ClassTag

class Queue[T: ClassTag](size: Int) {
  private val length:Int = size + 1
  private var data = new Array[T](length)
  private var front: Int = 0
  private var rear: Int = 0

  def queueLength = size

  def isEmpty: Boolean = (front == rear)

  def isFull: Boolean = (rear + 1) % length == front

  def deQueue(): T = isEmpty match {
    case true  => throw new NoSuchElementException
    case false  => {
      val result = data(front)
      front = (front + 1) %  length
      result
    }
  }

  def enQueue(t: T) =  isFull match {
    case true  => throw new RuntimeException("Queue is full!")
    case false  => {
      data(rear) = t
      rear = (rear + 1) % length
    }
  }
}
