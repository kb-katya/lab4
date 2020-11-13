import objects.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver", user = "root", password = "")

    transaction {
        addLogger(StdOutSqlLogger)

        SchemaUtils.create (Admins, Courses, Grades, Ratings, Students, Tasks, Tutors, Types)


        SchemaUtils.drop (Admins, Courses, Grades, Ratings, Students, Tasks, Tutors, Types)
    }
}