package Main.MoviesHTTPs

import Main.MovieData
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.*

class DeleteMovies(private val movies: MutableList<MovieData>) {

    fun Application.configureRouting() {
        routing {
            delete("/{id}") {
                val id = call.parameters["id"]
                val toRemove = movies.filter { it.id == id }

                if (toRemove.isNotEmpty()) {
                    movies.removeAll(toRemove)
                    call.respond(toRemove)
                } else {
                    call.respondText(
                        "No se encontraron películas con el ID: $id",
                        status = HttpStatusCode.NotFound,
                        contentType = ContentType.Text.Plain
                    )
                }
            }

            delete("/{title}") {
                val title = call.parameters["title"]
                val toRemove = movies.filter { it.title == title }

                if (toRemove.isNotEmpty()) {
                    movies.removeAll(toRemove)
                    call.respond(toRemove)
                } else {
                    call.respondText(
                        "No se encontraron películas con el título: $title",
                        status = HttpStatusCode.NotFound,
                        contentType = ContentType.Text.Plain
                    )
                }
            }
        }
    }
}
