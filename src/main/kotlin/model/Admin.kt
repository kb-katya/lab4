package model

import objects.Admins
import objects.Tutors
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Admin(
    id: EntityID<Int>
) : Person(id) {
    companion object : IntEntityClass<Admin>(Admins)
    var name by Tutors.name

    // *** Самописные ***

    // Set course
    fun setCourse(name: String) {
        Course.new {
            this.name = name
        }
    }

    // Set person
    fun setPerson(name: String, type: String = "Student", ext: String = "28-Z") {
        if (type == "Student") {
            Student.new {
                this.name = name
                this.group = ext
            }
        } else if (type == "Tutor") {
            Tutor.new {
                this.name = name
                this.post = ext
            }
        }
    }

    // Set task type
    fun setTaskType(name: String, shortName: String = name.substring(0, 3)) {
        Type.new {
            this.name = name
            this.shortName = shortName
        }
    }
}