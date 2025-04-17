
import Main.ControlJson
import Main.Movie
import Main.MovieData
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import kotlin.collections.map

fun main() {
    // 1. Declarar la variable fuera del try (puede ser nullable)
    var jsonString: String = ""
    var movies: List<MovieData> = emptyList()
    val controlJson: ControlJson

    try {
        // 2. Asignás dentro del try
        jsonString = File("app/src/main/resources/movies.json").readText()
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
    controlJson = ControlJson(jsonString)
    movies = controlJson.CargaDatosMovies()




    embeddedServer(Netty, port = 8080, host = "0.0.0.0") { module(movies) }
        .start(wait = true)
}

fun Application.module(movies: List<MovieData>) {
    configureRouting(movies)
}

fun Application.configureRouting(movies: List<MovieData>) {
    routing {
        get("/") {
            call.respondText("${movies.forEach { movie ->
                println(movie.toString())
            }}")
        }
        get("/1") {
            call.respondText("que onda ienvenido a 1")
        }
        get("/2") {
            call.respondText("que onda ienvenido a 2")
        }
    }
}

