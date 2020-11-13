package objects

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Ratings : IntIdTable() {
    override val id: Column<EntityID<Int>> = integer("id").autoIncrement().entityId() // Column<Int>
    val weight = double("name") // Column<Double>

    val course = reference("course", Courses)
    val student = reference("student", Students)

    override val primaryKey = PrimaryKey(id, name = "PK_RATING_ID") // name is optional here
}