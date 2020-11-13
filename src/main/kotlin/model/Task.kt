package model

import objects.Tasks
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Task(
    id: EntityID<Int>
) : IntEntity(id) {
    companion object : IntEntityClass<Task>(Tasks)
    var name by Tasks.name
    var shortName by Tasks.shortName
    var deadline by Tasks.deadline
    var description by Tasks.description
    var maxValue by Tasks.maxValue

    var type by Type referencedOn Tasks.type
    var course by Course referencedOn Tasks.course

    // *** Самописные ***

    // Add task rating
    fun addRating(weight: Double) {
        val students = Grade.all().map { it.student }.distinct()
        students.forEach { student ->
            getMaxGrade(student.name)?.let { grade ->
                Rating.new {
                    this.student = student
                    this.course = this@Task.course
                    this.weight = weight
                }
            }
        }
    }

    fun getMaxGrade(studentName: String): Grade? {
        return Grade.all()
            .filter { it.student.name == studentName }
            .maxByOrNull { it.value }
    }
}