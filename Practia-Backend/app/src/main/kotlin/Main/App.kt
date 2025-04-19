import Main.FileJson
import Main.MovieData
import Main.MoviesUrl



fun main() {
    val pathText: String = "app/src/main/resources/movies.json"
    var movies: List<MovieData> = emptyList()
    val fileJson = FileJson(pathText)
    movies = fileJson.leerJson()
    val moviesUrl = MoviesUrl(movies)
    moviesUrl.runCliente()

}




