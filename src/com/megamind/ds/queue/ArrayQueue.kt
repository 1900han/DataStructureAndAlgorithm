package com.megamind.ds.queue

import com.megamind.ds.array.DynamicArray
import java.lang.StringBuilder

class ArrayQueue<E> :Queue<E>{
    private val array: DynamicArray<E>

    constructor(capacity: Int) {
        array = DynamicArray(capacity)
    }

    constructor() {
        array = DynamicArray()
    }

    override fun getSize() = array.getSize()

    override fun isEmpty() = array.isEmpty()

    fun getCapacity() = array.getCapacity()

    override fun enqueue(e: E) {
        array.addLast(e)
    }

    override fun dequeue(): E {
        return array.removeFirst()
    }

    override fun getFront(): E {
        return array.getFirst()
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("Queue: ")
        sb.append("front [")
        for (i in 0 until array.getSize()) {
            sb.append(array.get(i))
            if (i != array.getSize() - 1) {
                sb.append(", ")
            }
        }
        sb.append("] tail")
        return sb.toString()
    }
}