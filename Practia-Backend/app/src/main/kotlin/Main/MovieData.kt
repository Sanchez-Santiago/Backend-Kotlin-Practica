package Main
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
@Serializable
data class MovieData(

    var id: String,
    var title: String,
    var year: Int,
    var director: String,
    var duration: Int,
    var poster: String,
    @SerializedName("genre") var genres: Array<String>?,  // Anotación para mapear 'genre' a 'genres'
    var rate: Double
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