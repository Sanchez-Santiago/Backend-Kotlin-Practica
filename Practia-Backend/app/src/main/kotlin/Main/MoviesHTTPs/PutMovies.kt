package Main.MoviesHTTPs

import Main.MovieData
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

class PutMovies(private val movies: MutableList<MovieData>) {

    fun Application.configureRouting() {
        routing {
            // Reemplazar todo un recurso existente
            put("/{id}") {
                val id = call.parameters["id"]

                if (id == null) {
                    call.respondText("ID inválido", status = HttpStatusCode.BadRequest)
                    return@put
                }

                val updatedData = call.receive<MovieData>()

                if (!updatedData.isValid()) {
                    call.respondText("Datos inválidos", status = HttpStatusCode.BadRequest)
                    return@put
                }

                val index = movies.indexOfFirst { it.id == id }

                if (index != -1) {
                    // Reemplaza completamente la película existente
                    movies[index] = updatedData
                    call.respond(
                        mapOf(
                            "message" to "Película actualizada correctamente",
                            "data" to updatedData
                        )
                    ) // ← Acá responde con el objeto completo
                } else {
                    call.respondText("Película no encontrada", status = HttpStatusCode.NotFound)
                }
            }
        }
    }

    private fun MovieData.isValid(): Boolean {
        return id.isNotBlank() &&
                title.isNotBlank() &&
                director.isNotBlank() &&
                year in 1800..2100 &&
                rate in 0.0..10.0
    }
}
