import data.*

class Inflector {

    companion object {

        private const val KEEP_SYMBOL = "."
        private const val REMOVE_SYMBOL = '-'
    }

    private val root = RulesReader.getRoot()

    fun inflect(name: String, namePart: NamePart, gender: Gender, case: Case): String {
        var result = name
        val mods = findMods(name, namePart, gender)
        if (mods.isNotEmpty()) {
            val mod = mods[case.ordinal]
            result = mod.apply(name)
        }
        return result
    }

    fun inflect(name: String, namePart: NamePart, gender: Gender): List<String> {
        val result = mutableListOf<String>()
        val mods = findMods(name, namePart, gender)
        if (mods.isNotEmpty()) {
            mods.forEach {
                val appliedName = it.apply(name)
                result.add(appliedName)
            }
        } else {
            result.add(name)
        }
        return result
    }

    private fun findMods(name: String, namePart: NamePart, gender: Gender): List<String> {
        val ruleSet = when (namePart) {
            NamePart.LASTNAME -> root.lastName
            NamePart.FIRSTNAME -> root.firstName
            NamePart.MIDDLENAME -> root.middleName
        }
        val exception = ruleSet.exceptionList.findRule(name, gender)
        val suffix = ruleSet.suffixList.findRule(name, gender)
        return exception?.mods ?: suffix?.mods ?: emptyList()
    }

    private fun List<Rule>.findRule(name: String, gender: Gender): Rule? =
        find { rule -> rule.test.any { name.endsWith(it) } && (rule.gender == Gender.ANDROGYNOUS || rule.gender == gender) }

    private fun Mod.apply(name: String): String {
        return if (this != KEEP_SYMBOL) {
            val symbolsToRemove = this.count { it == REMOVE_SYMBOL }
            val n = name.substring(0, name.length - symbolsToRemove)
            val m = this.substring(symbolsToRemove)
            n + m
        } else {
            name
        }
    }
}
