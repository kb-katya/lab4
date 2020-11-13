package objects

import model.Type
import objects.Students.autoIncrement
import objects.Students.entityId
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import repo.ItemTable

object Types : IntIdTable() {
    override val id: Column<EntityID<Int>> = Grades.integer("id").autoIncrement().entityId() // Column<Int>
    val name = varchar("name", 50) // Column<String>
    val shortName = varchar("shortName", 50) // Column<String>

    override val primaryKey = PrimaryKey(id, name = "PK_TYPE_ID")
}