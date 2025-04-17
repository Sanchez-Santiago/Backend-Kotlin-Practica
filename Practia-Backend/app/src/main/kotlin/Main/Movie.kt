package Main
import java.net.URL

class Movie(
    id: String,
    title: String,
    year: Int,
    director: String,
    duration: Int,
    poster: URL?,
    genres: Array<String>,
    rate: Float
) {

    private var id: String = ""
        set(value) {
            field = if (value.isNotBlank()) value else ""
        }

    private var title: String = ""
        set(value) {
            field = if (value.isNotBlank()) value else ""
        }

    private var year: Int = 0
        set(value) {
            field = if (value > 1900) value else 1900
        }

    private var director: String = ""
        set(value) {
            field = if (value.isNotBlank()) value else ""
        }

    private var duration: Int = 0
        set(value) {
            field = if (value > 30) value else 0
        }

    private var posterUrl: URL? = null
        set(value) {
            field = value
        }

    private var genresArray: Array<String> = emptyArray()
        set(value) {
            field = if (value.isNotEmpty()) value else emptyArray()
        }

    private var rate: Float = 0f
        set(value) {
            field = if (value > 0f) value else 0f
        }

    // Constructor primario
    init {
        this.id = id
        this.title = title
        this.year = year
        this.director = director
        this.duration = duration
        this.posterUrl = poster
        this.genresArray = genres
        this.rate = rate
    }

    // Constructor vacío
    constructor() : this(
        "",
        "",
        1900,
        "",
        0,
        URL("https://default-poster.jpg"),
        arrayOf(""),
        0.0f
    )

    // Getters-------------------------------------------
    fun getId() = id
    fun getTitle() = title
    fun getYear() = year
    fun getDirector() = director
    fun getDuration() = duration
    fun getPosterUrl() = posterUrl
    fun getGenre() = genresArray
    fun getRate() = rate

    //Seters-----------------------------------------------
    fun customSetId(id: String) {
        this.id = id
    }
    fun customSetTitle(title: String) {
        this.title = title
    }
    fun customSetYear(year: Int) {
        this.year = year
    }
    fun customSetDirector(director: String) {
        this.director = director
    }
    fun customSetDuration(duration: Int) {
        this.duration = duration
    }
    fun customSetPosterUrl(posterUrl: URL) {
        this.posterUrl = posterUrl
    }
    fun customSetGenresArray(genresArray: Array<String>) {
        this.genresArray = genresArray
    }
    fun customSetRate(rate: Float) {
        this.rate = rate
    }

    //toString-----------------------------------------------------------
    override fun toString(): String {
        return """
        ###Movie###
        Id= $id,
        Title= $title,
        Year= $year,
        Director= $director,
        Duration= $duration,
        Poster= $posterUrl,
        Genres= ${genresArray.joinToString(", ")},
        Rate= $rate
        ------------------
    """.trimIndent()
    }
}
