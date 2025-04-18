package Main

import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.serialization.json.Json

class MoviesGETUrl(movies: List<MovieData>) {

    var movies: List<MovieData> = emptyList()

    init {
        this.movies = movies
    }

    fun runCliente(){
        // Iniciar servidor solo si hay datos cargados
        if (movies.isEmpty()) {
            println("No se encontraron películas disponibles.")
        } else {
            embeddedServer(Netty, port = 8080, host = "0.0.0.0") { module(movies) }
                .start(wait = true)
        }
    }


    fun Application.module(movies: List<MovieData>) {
        install(ContentNegotiation) {
            json(Json { prettyPrint = true })  // Configura la serialización de JSON
        }
        configureRouting(movies)
    }
    fun Application.configureRouting(movies: List<MovieData>) {
        routing {
            get("/") {
                // Si no hay películas, devolver mensaje de error
                if (movies.isEmpty()) {
                    call.respondText("No hay películas disponibles", contentType = ContentType.Text.Plain)
                } else {
                    try {
                        call.respond(movies)  // Responde con la lista de películas en formato JSON
                    } catch (e: Exception) {
                        call.respondText("Error al enviar los datos: ${e.message}", contentType = ContentType.Text.Plain)
                    }
                }
            }
            get("/id/{movieId}") {
                val movieId = call.parameters["movieId"]

                if (movieId == null) {
                    call.respondText("Falta el parámetro movieId", contentType = ContentType.Text.Plain)
                    return@get
                }

                val movieAux = movies.find { it.id == movieId }

                if (movieAux != null) {
                    call.respond(movieAux)
                } else {
                    call.respondText("No se encontró la película con ID: $movieId", contentType = ContentType.Text.Plain)
                }
            }

            get("/genre/{movieGenre}") {
                val movieGenre = call.parameters["movieGenre"]

                if (movieGenre == null) {
                    call.respondText("Falta el parámetro movieId", contentType = ContentType.Text.Plain)
                    return@get
                }

                //val movieAux = movies.find { movie -> movie.id == movieGenre }
                val movieAux = movies.filter { movie ->
                    movie.genres?.contains(movieGenre) ?: false
                }

                if (movieAux != null) {
                    call.respond(movieAux)
                } else {
                    call.respondText("No se encontró la película con el genero: $movieGenre", contentType = ContentType.Text.Plain)
                }
            }
        }
    }
}