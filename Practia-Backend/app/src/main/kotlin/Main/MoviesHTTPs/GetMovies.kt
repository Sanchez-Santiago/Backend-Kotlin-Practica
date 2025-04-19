package Main.MoviesHTTPs

import Main.MovieData
import io.ktor.http.ContentType
import io.ktor.server.application.*
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.*


class GetMovies(private val movies: List<MovieData>) {

    fun Application.configureRouting() {
        routing {
            get("/") {
                if (movies.isEmpty()) {
                    call.respondText("No hay películas disponibles", contentType = ContentType.Text.Plain)
                } else {
                    call.respond(movies)
                }
            }
            get("/help") {
                val help = Help().instrucciones.trimIndent()
                call.respondText(help, ContentType.Text.Plain)
            }

            get("/{movieId}") {
                val movieId = call.parameters["movieId"]
                val movie = movies.find { it.id == movieId }

                if (movie != null) {
                    call.respond(movie)
                } else {
                    call.respondText("No se encontró la película con ID: $movieId", ContentType.Text.Plain)
                }
            }

            get("/{movieDirector}") {
                val director = call.parameters["movieDirector"]
                val movie = movies.find { it.director == director }

                if (movie != null) {
                    call.respond(movie)
                } else {
                    call.respondText("No se encontró la película con director: $director", ContentType.Text.Plain)
                }
            }

            get("/{movieGenre}") {
                val genre = call.parameters["movieGenre"]
                val result = movies.filter { it.genres?.contains(genre) == true }

                if (result.isNotEmpty()) {
                    call.respond(result)
                } else {
                    call.respondText("No se encontró la película con el género: $genre", ContentType.Text.Plain)
                }
            }

            get("/{movieTitle}") {
                val title = call.parameters["movieTitle"]
                val movie = movies.find { it.title == title }

                if (movie != null) {
                    call.respond(movie)
                } else {
                    call.respondText("No se encontró la película con título: $title", ContentType.Text.Plain)
                }
            }

            get("/{movieYear}") {
                val year = call.parameters["movieYear"]?.toIntOrNull()

                if (year == null) {
                    call.respondText("Parámetro year inválido", ContentType.Text.Plain)
                    return@get
                }

                val movie = movies.find { it.year == year }

                if (movie != null) {
                    call.respond(movie)
                } else {
                    call.respondText("No se encontró la película con año: $year", ContentType.Text.Plain)
                }
            }

            get("/{movieRate}") {
                val rate = call.parameters["movieRate"]?.toDoubleOrNull()

                if (rate == null) {
                    call.respondText("Parámetro rate inválido", ContentType.Text.Plain)
                    return@get
                }

                val movie = movies.find { it.rate == rate }

                if (movie != null) {
                    call.respond(movie)
                } else {
                    call.respondText("No se encontró la película con rate: $rate", ContentType.Text.Plain)
                }
            }
        }
    }
}
