# 🎬 Movie API con Ktor

Este proyecto es una API REST desarrollada en Kotlin utilizando el framework **Ktor**, diseñada para gestionar una colección de películas. Permite consultar información sobre películas y realizar operaciones como agregar, editar y eliminar películas a través de diversos endpoints.

## 🚀 Características

- Lectura de un archivo JSON con información de películas
- Endpoints HTTP para realizar operaciones:
  - Consultar todas las películas
  - Consultar una película por ID
  - Consultar películas por género
  - Consultar películas por otros parámetros
- Serialización automática con `kotlinx.serialization`
- Manejo de errores y respuestas personalizadas
- Endpoint `/help` para ver ejemplos de cómo usar las peticiones

## 🧱 Tecnologías utilizadas

- **Kotlin**
- **Ktor (Netty Engine)**
- **kotlinx.serialization**
- **Gson**
- **Gradle**

## 📁 Estructura del proyecto

```
Practia-Backend/
├── app/
│   ├── build/
│   ├── src/
│   │   ├── main/
│   │   │   ├── kotlin/
│   │   │   │   ├── Main/
│   │   │   │   │   ├── MoviesHTTPs/
│   │   │   │   │   │   ├── DeleteMovies.kt
│   │   │   │   │   │   ├── GetMovies.kt
│   │   │   │   │   │   ├── Help.kt
│   │   │   │   │   │   ├── PatchMovies.kt
│   │   │   │   │   │   ├── PostMovies.kt
│   │   │   │   │   │   ├── PutMovies.kt
│   │   │   │   │   ├── App.kt
│   │   │   │   │   ├── ControlJson.kt
│   │   │   │   │   ├── FileJson.kt
│   │   │   │   │   ├── Movie.kt
│   │   │   │   │   ├── MovieData.kt
│   │   │   │   │   ├── MoviesUrl.kt
│   │   │   ├── resources/
│   │   │   │   └── movies.json
│   ├── build.gradle.kts
│   ├── gradle/
├── buildSrc
├── gradle.properties
├── gradlew.bat
├── settings.gradle.kts
```

## 🛠️ Cómo correrlo

1. Cloná el repo:
```bash
https://github.com/Sanchez-Santiago/Backend-Kotlin-Practica
```

2. Corré el servidor:
```bash
./gradlew run
```

3. Accedé desde tu navegador o Postman a:
```
http://localhost:8080/
```

4. Para ver los ejemplos de uso de la API, accedé a:
```
http://localhost:8080/help
```

## 🔗 Endpoints

- `GET /` → Lista todas las películas
- `GET /id/{movieId}` → Devuelve la película con el ID indicado
- `GET /genre/{movieGenre}` → Lista películas que contengan ese género
- `GET /help` → Muestra cómo usar las peticiones disponibles en la API

## 📦 JSON de ejemplo

```json
[
  {
    "id": "1",
    "title": "Inception",
    "genres": ["Action", "Sci-Fi"]
  },
  ...
]
```

## 💡 Ideal para:

- Estudiantes de Kotlin
- Práctica de desarrollo backend con Ktor
- Proyectos educativos o demostrativos

---