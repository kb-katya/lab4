package model

import objects.Ratings
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

open class Rating(
    id: EntityID<Int>
) : IntEntity(id) {
    companion object : IntEntityClass<Rating>(Ratings)
    var weight by Ratings.weight

    var course by Course referencedOn Ratings.course
    var student by Student referencedOn Ratings.student
}