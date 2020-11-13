package model

import objects.CourseStudents
import objects.Students
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Student (
    id: EntityID<Int>
) : Person(id) {
    companion object : IntEntityClass<Student>(Students)
    var name by Students.name
    var group by Students.group

    var course by Course via CourseStudents
}