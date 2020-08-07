import data.Root
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.nio.file.Files
import java.nio.file.Paths

actual object RulesReader {

    actual fun getRoot(): Root {
        val file = Files.readString(Paths.get(RULES_PATH))
        val json = Json(JsonConfiguration.Stable)
        return json.parse(Root.serializer(), file)
    }
}
