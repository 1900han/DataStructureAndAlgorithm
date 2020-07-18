package com.megamind.ds.queue

import java.lang.IllegalArgumentException
import java.lang.StringBuilder

class LoopQueue3<E> : Queue<E> {
    private var front: Int
    private var tail: Int
    private var data: Array<Any?>

    constructor(capacity: Int) {
        data = Array(capacity + 1) {}
        front = 0
        tail = 0
    }

    constructor() : this(10)

    fun getCapacity() = data.size - 1

    override fun isEmpty(): Boolean {
        return front == tail
    }

    override fun getSize(): Int {
        return if (tail >= front) tail - front else tail - front + data.size
    }

    override fun enqueue(e: E) {
        if ((tail + 1) % data.size == front) {
            resize(getCapacity() * 2)
        }
        data[tail] = e
        tail = (tail + 1) % data.size
    }

    override fun dequeue(): E {
        if (isEmpty())
            throw IllegalArgumentException("Can't dequeue from an empty queue.")
        val ret = data[front]
        data[front] = null
        front = (front + 1) % data.size

        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2)
        }
        return ret as E
    }

    override fun getFront(): E {
        if (isEmpty())
            throw IllegalArgumentException("Queue is empty.")
        return data[front] as E
    }

    private fun resize(newCapacity: Int) {
        val newData = Array<Any?>(newCapacity + 1) {}
        val sz = getSize()
        for (i in 0 until sz) {
            newData[i] = data[(i + front) % data.size]
        }
        data = newData
        front = 0
        tail = sz
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("Queue: size = ${getSize()}, capacity = ${getCapacity()}\n")
        sb.append("front [")
        var i = front
        while (i != tail) {
            sb.append(data[i])
            if ((i + 1) % data.size != tail) {
                sb.append(", ")
            }
            i = (i + 1) % data.size
        }
        sb.append("] tail")
        return sb.toString()
    }
}