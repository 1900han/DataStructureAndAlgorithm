package com.megamind.ds.stack

import com.megamind.ds.array.DynamicArray
import java.lang.StringBuilder

class ArrayStack<E> : Stack<E> {
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

    override fun push(e: E) {
        array.addLast(e)
    }

    override fun pop() = array.removeLast()

    override fun peek() = array.getLast()

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("Stack: ")
        sb.append("[")
        for (i in 0 until array.getSize()) {
            sb.append(array.get(i))
            if (i != array.getSize() - 1) {
                sb.append(", ")
            }
        }
        sb.append("] top")
        return sb.toString()
    }
}