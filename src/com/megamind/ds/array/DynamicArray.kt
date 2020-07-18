package com.megamind.ds.array

import java.lang.IllegalArgumentException
import java.lang.StringBuilder

class DynamicArray<T>(capacity: Int) {
    private var data: Array<Any?> = Array(capacity) { null }
    private var size: Int = 0

    constructor() : this(10)

    fun getSize() = size

    fun getCapacity() = data.size

    fun isEmpty() = size == 0

    fun addLast(e: T) {
        add(size, e)
    }

    fun addFirst(e: T) {
        add(0, e)
    }

    fun add(index: Int, e: T) {
        if (index < 0 || index > size) {
            throw IllegalArgumentException("Add failed. Require index >=0 and <= size")
        }
        if (size == data.size) {
            resize(2 * data.size)
        }

        for (i in size - 1 downTo index) {
            data[i + 1] = data[i]
        }
        data[index] = e
        size++
    }

    private fun resize(newCapacity: Int) {
        val newData = Array<Any?>(newCapacity) { null }
        for (i in 0 until size) {
            newData[i] = data[i]
        }
        data = newData
    }

    fun get(index: Int): T {
        if (index < 0 || index >= size) {
            throw IllegalArgumentException("Get failed. Index is illegal")
        }
        return data[index] as T
    }

    fun getLast() = get(size - 1)

    fun getFirst() = get(0)

    fun set(index: Int, e: T) {
        if (index < 0 || index >= size) {
            throw IllegalArgumentException("Set failed. Index is illegal")
        }
        data[index] = e
    }

    fun contains(e: T): Boolean {
        for (i in 0 until size) {
            if (data[i] == e) {
                return true
            }
        }
        return false
    }

    fun find(e: T): Int {
        for (i in 0 until size) {
            if (data[i] == e) {
                return i
            }
        }
        return -1
    }

    fun remove(index: Int): T {
        if (index < 0 || index >= size) {
            throw IllegalArgumentException("Remove Set failed. Index is illegal")
        }
        val ret = data[index]
        for (i in index + 1 until size) {
            data[i - 1] = data[i]
        }
        size--
        data[size] = null
        if (size == (data.size / 4) && (data.size / 2) != 0) {
            resize(data.size / 2)
        }
        return ret as T
    }

    fun removeFirst(): T {
        return remove(0)
    }

    fun removeLast(): T {
        return remove(size - 1)
    }

    fun removeElement(e: T) {
        val index = find(e)
        if (index != -1) {
            remove(index)
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("Array: size = $size, capacity = ${data.size}\n")
        sb.append("[")
        for (i in 0 until size) {
            sb.append(data[i])
            if (i != size - 1) {
                sb.append(", ")
            }
        }
        sb.append("]")
        return sb.toString()
    }
}