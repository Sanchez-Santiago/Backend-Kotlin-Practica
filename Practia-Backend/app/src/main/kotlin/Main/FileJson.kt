package Main
import java.io.File


class FileJson(pathText: String) {
    var path: String = ""
    var jsonString: String = ""
    val controlJson = ControlJson()
    var movies: List<MovieData> = emptyList()

    init {
        this.path = pathText
    }

    fun leerJson(): List<MovieData> {
        try {
            // Intentar leer el archivo JSON
            jsonString = File(path).readText()
        } catch (e: Exception) {
            println("Error al leer el archivo JSON: ${e.message}")
        }

        if (jsonString.isNotEmpty()) {
            try {
                movies = controlJson.CargaDatosMovies(jsonString)
                return movies
            } catch (e: Exception) {
                println("Error al procesar los datos JSON: ${e.message}")
            }
        } else {
            println("El archivo JSON está vacío o no se pudo cargar.")
        }
        return emptyList()
    }
}