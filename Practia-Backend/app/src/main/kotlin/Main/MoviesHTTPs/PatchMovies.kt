package Main.MoviesHTTPs

import Main.MovieData
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

class PatchMovies(private val movies: MutableList<MovieData>) {

    @Serializable
    data class MoviePatchRequest(
        val title: String? = null,
        val year: Int? = null,
        val director: String? = null,
        val duration: Int? = null,
        val poster: String? = null,
        val genres: Array<String>? = null,
        val rate: Double? = null
    )

    @Serializable
    data class MovieResponse(
        val message: String,
        val data: MovieData? = null
    )

    @Serializable
    data class ErrorResponse(
        val message: String,
        val error: String
    )

    fun Application.configureRouting() {
        routing {
            patch("/{id}") {
                try {
                    val id = call.parameters["id"]
                    val partialData = call.receive<MoviePatchRequest>()
                    val movie = movies.find { it.id == id }

                    if (movie != null) {
                        // Actualizar solo los campos que no son nulos
                        partialData.title?.let { if (it.isNotBlank()) movie.title = it }
                        partialData.director?.let { if (it.isNotBlank()) movie.director = it }
                        partialData.year?.let { if (it > 0) movie.year = it }
                        partialData.rate?.let { if (it >= 0) movie.rate = it }
                        partialData.genres?.let { if (it.isNotEmpty()) movie.genres = it }
                        partialData.duration?.let { if (it > 0) movie.duration = it }
                        partialData.poster?.let { if (it.isNotBlank()) movie.poster = it }

                        call.respond(MovieResponse(
                            message = "Película actualizada correctamente",
                            data = movie
                        ))
                    } else {
                        call.respond(HttpStatusCode.NotFound, MovieResponse(
                            message = "Película no encontrada"
                        ))
                    }
                } catch (e: Exception) {
                    println("Error en PATCH: ${e.message}")
                    e.printStackTrace()
                    call.respond(HttpStatusCode.BadRequest, ErrorResponse(
                        message = "Error al procesar la solicitud",
                        error = e.message ?: "Unknown error"
                    ))
                }
            }
        }
    }
}