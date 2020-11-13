package objects

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Students : IntIdTable() {
    override val id: Column<EntityID<Int>> = Grades.integer("id").autoIncrement().entityId() // Column<Int>
    val name = varchar("name", length = 50) // Column<String>
    val group = varchar("group", length = 50) // Column<String>

    override val primaryKey = PrimaryKey(id, name = "PK_STUDENT_ID") // name is optional here
}