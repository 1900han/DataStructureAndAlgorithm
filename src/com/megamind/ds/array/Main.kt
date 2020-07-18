package com.megamind.ds.array

import com.megamind.algorithm.Student

fun main() {
    val dynamicArray = DynamicArray<Int>()
    for (i in 0 until 10) {
        dynamicArray.addLast(i)
    }
    println(dynamicArray)

    dynamicArray.add(1, 100)
    println(dynamicArray)

    dynamicArray.addFirst(-1)
    println(dynamicArray)

    dynamicArray.remove(2)
    println(dynamicArray)

    dynamicArray.removeElement(4)
    println(dynamicArray)

    println("find 0 : index: ${dynamicArray.find(0)}")

/*    val studentArray = DynamicArray<Student>()
    studentArray.addLast(Student("Alice",100))
    studentArray.addLast(Student("Bob",66))
    studentArray.addLast(Student("Charlie",88))
    println(studentArray)*/
}