package Main

import Main.MoviesHTTPs.DeleteMovies
import Main.MoviesHTTPs.GetMovies
import Main.MoviesHTTPs.PatchMovies
import Main.MoviesHTTPs.PostMovies
import Main.MoviesHTTPs.PutMovies
import io.ktor.server.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class MoviesUrl(private val movies: List<MovieData>) {

    private val getMovies = GetMovies(movies)
    private val deleteMovies = DeleteMovies(movies as MutableList<MovieData>)
    private val postMovies = PostMovies(movies as MutableList<MovieData>)
    private val putMovies = PutMovies(movies as MutableList<MovieData>)
    private val patchMovies = PatchMovies(movies as MutableList<MovieData>)

    fun runCliente() {
        if (movies.isEmpty()) {
            println("No se encontraron películas disponibles.")
        } else {
            embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
                install(ContentNegotiation) {
                    json(Json { prettyPrint = true })
                }

                // Inicializá las rutas
                with(getMovies) { configureRouting() }
                with(deleteMovies) { configureRouting() }
                with(postMovies) { configureRouting() }
                with(putMovies) { configureRouting() }
                with(patchMovies) { configureRouting() }
            }.start(wait = true)
        }
    }
}
