package objects

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.`java-time`.date

object Grades : IntIdTable() {
    override val id: Column<EntityID<Int>> = integer("id").autoIncrement().entityId() // Column<Int>
    val value = integer("value") // Column<Int>
    val date = date("date") // Column<Date>

    val student = reference("student", Students)
    val task = reference("task", Tasks)

    override val primaryKey = PrimaryKey(id, name = "PK_GRADE_ID") // name is optional here
}