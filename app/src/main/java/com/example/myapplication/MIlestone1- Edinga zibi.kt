package com.example.myapplication

fun processStudents(students: List<Student>, action: (Student) -> Unit) {
    students.forEach { action(it) }
}

fun main() {
    val students = listOf(
        Student("Louise", 50.0),
        Student("Armelle", 77.0),
        Student("Francis", 96.0)
    )

    // Fonction d'ordre supérieur avec lambda
    processStudents(students) { s ->
        println(s.format())
    }

    // filter - étudiants reçus
    val recus = students.filter { it.isRecu() }
    println("Reçus : ${recus.map { it.name }}")

    // map - liste des grades
    val grades = students.map { it.grade }
    println("Grades : $grades")
}