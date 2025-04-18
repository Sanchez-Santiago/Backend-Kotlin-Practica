package Main

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ControlJson() {

    private var json: String = ""
        set(value) {
            field = if (value.isNotBlank()) value else ""
        }

    init {
        this.json = json
    }

    fun CargaDatosMovies(json: String): List<MovieData> {
        val gson = Gson()
        val listType = object : TypeToken<List<MovieData>>() {}.type
        return gson.fromJson(json, listType)
    }
}
