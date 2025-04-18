import Main.ControlJson
import Main.FileJson
import Main.MovieData
import Main.MoviesGETUrl
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.contentnegotiation.*


fun main() {
    val pathText: String = "app/src/main/resources/movies.json"
    var movies: List<MovieData> = emptyList()
    val fileJson = FileJson(pathText)
    movies = fileJson.leerJson()
    val moviesGETUrl = MoviesGETUrl(movies)
    moviesGETUrl.runCliente()

}




