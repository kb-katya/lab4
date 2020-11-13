package objects


import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Courses : IntIdTable() {
    override val id: Column<EntityID<Int>> = integer("id").autoIncrement().entityId() // Column<Int>
    var name = varchar("name", length = 50) // Column<String>

    override val primaryKey = PrimaryKey(Grades.id, name = "PK_COURSE_ID") // name is optional here
}