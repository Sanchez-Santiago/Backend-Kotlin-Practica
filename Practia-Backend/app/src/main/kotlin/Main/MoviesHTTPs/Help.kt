package Main.MoviesHTTPs

data class Help(
    val instrucciones: String = "## \uD83D\uDCFD\uFE0F API de Películas – Cómo Usarla\n" +
            "\n" +
            "Esta API permite gestionar una colección de películas. Podés consultarlas, agregarlas, editarlas o eliminarlas según lo necesites. A continuación, te explicamos cómo usar cada tipo de petición:\n" +
            "\n" +
            "---\n" +
            "\n" +
            "### \uD83D\uDD0D **GET** – Consultar películas\n" +
            "\n" +
            "- `GET /`  \n" +
            "    Retorna la lista completa de películas.\n" +
            "    \n" +
            "- `GET /{id}`  \n" +
            "    Busca una película por su ID.\n" +
            "    \n" +
            "- `GET /{title}`  \n" +
            "    Busca películas por título.\n" +
            "    \n" +
            "- `GET /{director}`  \n" +
            "    Busca películas por director.\n" +
            "    \n" +
            "- `GET /{genre}`  \n" +
            "    Muestra películas que pertenecen a un género.\n" +
            "    \n" +
            "- `GET /{year}`  \n" +
            "    Muestra películas lanzadas en un año específico.\n" +
            "    \n" +
            "- `GET /{rating}`  \n" +
            "    Muestra películas con cierta puntuación o más.\n" +
            "    \n" +
            "\n" +
            "---\n" +
            "\n" +
            "### ➕ **POST** – Agregar una nueva película\n" +
            "\n" +
            "- `POST /movies`  \n" +
            "    Cuerpo del JSON que debés enviar:\n" +
            "    \n" +
            "\n" +
            "```json\n" +
            "{\n" +
            "  \"title\": \"Matrix\",\n" +
            "  \"director\": \"Lana Wachowski\",\n" +
            "  \"genre\": \"Ciencia ficción\",\n" +
            "  \"year\": 1999,\n" +
            "  \"duration\": 136,\n" +
            "  \"rating\": 9.0\n" +
            "}\n" +
            "```\n" +
            "\n" +
            "---\n" +
            "\n" +
            "### ✏\uFE0F **PUT** – Reemplazar completamente una película\n" +
            "\n" +
            "- `PUT /{id}`  \n" +
            "    Reemplaza todos los datos de una película por ID. Debés enviar todos los campos.  \n" +
            "    Si omitís alguno, ese campo podría eliminarse o quedar con un valor nulo.\n" +
            "    \n" +
            "\n" +
            "```json\n" +
            "{\n" +
            "  \"id\": 1,\n" +
            "  \"title\": \"Matrix Reloaded\",\n" +
            "  \"director\": \"Lana Wachowski\",\n" +
            "  \"genre\": \"Acción\",\n" +
            "  \"year\": 2003,\n" +
            "  \"duration\": 140,\n" +
            "  \"rating\": 9.5\n" +
            "}\n" +
            "```\n" +
            "\n" +
            "---\n" +
            "\n" +
            "### \uD83E\uDE79 **PATCH** – Actualizar parcialmente una película\n" +
            "\n" +
            "- `PATCH /{id}`  \n" +
            "    Modifica **solo** los campos que envíes. Ideal para cambios pequeños sin afectar el resto de los datos.\n" +
            "    \n" +
            "\n" +
            "```json\n" +
            "{\n" +
            "  \"rating\": 9.5,\n" +
            "  \"duration\": 140\n" +
            "}\n" +
            "```\n" +
            "\n" +
            "> Si no incluís un campo, ese campo se mantiene igual.\n" +
            "\n" +
            "---\n" +
            "\n" +
            "### \uD83D\uDDD1\uFE0F **DELETE** – Eliminar una película\n" +
            "\n" +
            "- `DELETE /{id}`  \n" +
            "    Elimina la película correspondiente al ID indicado.\n" +
            "    \n" +
            "- `DELETE /{title}`  \n" +
            "    Elimina la película correspondiente al título indicado.\n" +
            "    \n" +
            "\n" +
            "---\n" +
            "\n" +
            "### \uD83E\uDDEA Formato general de respuesta\n" +
            "\n" +
            "La API responde con mensajes claros de éxito o error, incluyendo el estado HTTP correspondiente (`200 OK`, `201 Created`, `404 Not Found`, `400 Bad Request`, etc.)."
)
