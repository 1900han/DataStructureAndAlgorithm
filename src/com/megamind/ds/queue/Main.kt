package com.megamind.ds.queue

import kotlin.random.Random

fun main() {
/*    val queue = ArrayQueue<Int>()
    for (i in 0 until 10) {
        queue.enqueue(i)
        println(queue)
        if (i % 3 == 2) {
            queue.dequeue()
            println(queue)
        }
    }*/

/*    val loopQueue = LoopQueue<Int>()
    for (i in 0 until 10) {
        loopQueue.enqueue(i)
        println(loopQueue)
        if (i % 3 == 2) {
            loopQueue.dequeue()
            println(loopQueue)
        }
    }*/

    val opCount = 1_000_00
    val arrayQueue = ArrayQueue<Int>()
    val time1 = testQueue(arrayQueue, opCount)
    println("ArrayQueue, time: $time1 s")

    val loopQueue = LoopQueue<Int>()
    val time2 = testQueue(loopQueue, opCount)
    println("LoopQueue, time: $time2 s")

    val loopQueue2 = LoopQueue2<Int>()
    val time3 = testQueue(loopQueue2, opCount)
    println("LoopQueue, time: $time3 s")

    val loopQueue3 = LoopQueue3<Int>()
    val time4 = testQueue(loopQueue3, opCount)
    println("LoopQueue, time: $time4 s")
}

fun testQueue(q: Queue<Int>, opCount: Int): Double {
    val startTime = System.nanoTime()
    for (i in 0 until opCount) {
        q.enqueue(Random.nextInt(Int.MAX_VALUE))
    }
    for (i in 0 until opCount) {
        q.dequeue()
    }
    val endTime = System.nanoTime()
    return (endTime - startTime) / 1_000_000_000.0
}