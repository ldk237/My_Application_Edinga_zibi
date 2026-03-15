package com.example.myapplication

data class Student(
    val name: String,
    val score: Double
) {
    val grade: String get() = calculateGrade(score)
    val mention: String get() = calculateMention(score)
    fun isRecu(): Boolean = score >= 60
    fun format(): String {
        val statut = if (isRecu()) "Reçu" else "Recalé"
        return "$name - $score | Grade $grade | Mention: $mention | $statut"
    }
}

fun calculateGrade(score: Double): String {
    return when {
        score >= 90 -> "A"
        score >= 80 -> "B"
        score >= 70 -> "C"
        score >= 60 -> "D"
        else        -> "F"
    }
}

fun calculateMention(score: Double): String {
    return when {
        score >= 90 -> "Excellent"
        score >= 80 -> "Très Bien"
        score >= 70 -> "Bien"
        score >= 60 -> "Passable"
        else        -> "Insuffisant"
    }
}