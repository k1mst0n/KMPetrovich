import data.Root

const val RULES_PATH = "petrovich-rules/rules.json"

expect object RulesReader {

    fun getRoot(): Root
}
