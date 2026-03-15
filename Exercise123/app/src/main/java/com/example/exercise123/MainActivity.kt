package com.example.exercise123

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        exercice1()
        exercice2()
        exercice3()
    }

    fun exercice1() {
        fun processList(
            numbers: List<Int>,
            predicate: (Int) -> Boolean
        ): List<Int> = numbers.filter { predicate(it) }

        val nums = listOf(1, 2, 3, 4, 5, 6)
        val even = processList(nums) { it % 2 == 0 }
        Log.d("EX1", "Résultat : $even")
    }

    fun exercice2() {
        val words = listOf("apple", "cat", "banana", "dog", "elephant")
        words
            .associateWith { it.length }
            .filter { (_, length) -> length > 4 }
            .forEach { (word, length) ->
                Log.d("EX2", "$word has length $length")
            }
    }

    fun exercice3() {
        data class Person(val name: String, val age: Int)

        val people = listOf(
            Person("Alice", 25),
            Person("Bob", 30),
            Person("Charlie", 35),
            Person("Anna", 22),
            Person("Ben", 28)
        )

        val average = people
            .filter { it.name.startsWith("A") || it.name.startsWith("B") }
            .map { it.age }
            .average()

        Log.d("EX3", "Moyenne : ${"%.1f".format(average)}")
    }
}