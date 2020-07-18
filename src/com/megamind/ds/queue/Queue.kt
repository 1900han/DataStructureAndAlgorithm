package com.megamind.ds.queue

interface Queue<E> {
    fun enqueue(e: E)
    fun dequeue(): E
    fun getFront(): E
    fun isEmpty(): Boolean
    fun getSize(): Int
}