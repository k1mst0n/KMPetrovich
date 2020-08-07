package sample

import Inflector
import data.Gender
import data.NamePart
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class RuleTest {

    private lateinit var inflector: Inflector

    @BeforeTest
    fun setUp() {
        inflector = Inflector()
    }

    @Test
    fun testMeAllCases() {
        val result = inflector.inflect("Ким", NamePart.FIRSTNAME, Gender.MALE)
        assertEquals(result, listOf("Кима", "Киму", "Кима", "Кимом", "Киме"))
    }

    @Test
    fun testMeAndrogynousAllCases() {
        val result = inflector.inflect("Ким", NamePart.FIRSTNAME, Gender.ANDROGYNOUS)
        assertEquals(result, listOf("Кима", "Киму", "Кима", "Кимом", "Киме"))
    }
}
