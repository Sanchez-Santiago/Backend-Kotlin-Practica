package Main.MoviesHTTPs

import Main.MovieData
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.respondText
import io.ktor.server.routing.*

class PostMovies(private val movies: MutableList<MovieData>) {

    fun Application.configureRouting() {
        routing {
            //Crear un nuevo recurso
            post("/") {
                try {
                    val newMovie = call.receive<MovieData>()
                    if (!newMovie.isValid()) {
                        call.respondText("Datos de la película inválidos", status = HttpStatusCode.BadRequest)
                        return@post
                    }

                    if (movies.any { it.id == newMovie.id }) {
                        call.respondText("Ya existe una película con el mismo ID", status = HttpStatusCode.Conflict)
                        return@post
                    }

                    movies.add(newMovie)
                    call.respondText("Película agregada correctamente", status = HttpStatusCode.Created)
                } catch (e: Exception) {
                    call.respondText("Error al procesar la película: ${e.message}", status = HttpStatusCode.BadRequest)
                }
            }
        }
    }

    private fun MovieData.isValid(): Boolean {
        return !id.isNullOrBlank() &&
                !title.isNullOrBlank() &&
                !director.isNullOrBlank() &&
                year > 1800 && year <= 2100 &&
                rate in 0.0..10.0
    }
}
