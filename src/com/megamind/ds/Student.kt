package com.megamind.ds

data class Student(val name: String, val score: Int) : Comparable<Student> {
    override fun compareTo(other: Student): Int {
        return score - other.score
    }

//    override fun toString(): String {
//        return "Student(name: $name, score: $score)"
//    }
}