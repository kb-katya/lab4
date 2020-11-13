package objects

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.`java-time`.date

object Tasks : IntIdTable() {
    override val id: Column<EntityID<Int>> = Grades.integer("id").autoIncrement().entityId() // Column<Int>
    var name = varchar("name", length = 50) // Column<String>
    val shortName = varchar("shortName", length = 50) // Column<String>
    var description = varchar("description", length = 50) // Column<String>
    var maxValue = integer("maxValue") // Column<Int>
    var deadline = date("deadline") // Column<Date>

    var type = reference("task", Types)
    var course = reference("course", Courses)

    override val primaryKey = PrimaryKey(id, name = "PK_TASK_ID") // name is optional here
}