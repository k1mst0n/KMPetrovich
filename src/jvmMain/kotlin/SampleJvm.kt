import data.Case
import data.Gender
import data.NamePart

fun main() {
    val inflector = Inflector()
    val name = "Иванов"
    val namePart = NamePart.LASTNAME
    val gender = Gender.MALE
    val case = Case.DATIVE
    println(inflector.inflect(name, namePart, gender))
    println(inflector.inflect(name, namePart, gender, case))
}
