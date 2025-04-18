# Backend-Kotlin-Practica
¡Obvio, Santi! Acá te dejo una buena descripción para el `README.md` de tu proyecto en Kotlin con Ktor:

---

# 🎬 Movie API con Ktor

Este proyecto es una API REST desarrollada en Kotlin utilizando el framework **Ktor**, diseñada para servir información sobre películas a partir de un archivo JSON.

Permite consultar datos como títulos, géneros, IDs y más a través de endpoints simples y rápidos, ideal para practicar el manejo de rutas, parámetros y serialización de datos en Kotlin.

## 🚀 Características

- Lectura de un archivo JSON con información de películas
- Endpoints HTTP para consultar:
  - Todas las películas
  - Película por ID
  - Películas por género
- Serialización automática con `kotlinx.serialization`
- Manejo de errores y respuestas personalizadas

## 🧱 Tecnologías utilizadas

- **Kotlin**
- **Ktor (Netty Engine)**
- **kotlinx.serialization**
- **Gson**
- **Gradle**

## 📁 Estructura del proyecto

```
├── app/
│   └── src/
│       └── main/
│           ├── kotlin/
│           │   └── Main/
│           │       ├── ControlJson.kt
│           │       ├── MovieData.kt
│           │       └── Movie.kt
│           └── resources/
│               └── movies.json
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

## 🔗 Endpoints

- `GET /` → Lista todas las películas
- `GET /id/{movieId}` → Devuelve la película con el ID indicado
- `GET /genre/{movieGenre}` → Lista películas que contengan ese género

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

