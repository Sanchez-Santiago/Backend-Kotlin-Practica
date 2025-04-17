package Main
import com.google.gson.annotations.SerializedName

data class MovieData(
    val id: String,
    val title: String,
    val year: Int,
    val director: String,
    val duration: Int,
    val poster: String,
    @SerializedName("genre") val genres: Array<String>?,  // Anotación para mapear 'genre' a 'genres'
    val rate: Double
) {
    override fun toString(): String {
        return """
            
        ### Movie ###
        Id: $id
        Title: $title
        Year: $year
        Director: $director
        Duration: $duration min
        Poster: $poster
        Genres: ${genres?.joinToString() ?: "Sin géneros"}
        Rate: $rate
        ------------------
    """.trimIndent()
    }
}