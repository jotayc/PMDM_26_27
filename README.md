# UD 3.5 · Peticiones REST

Una lista con los nombres de 100 pokémon que la aplicación pide a un servicio de internet,
**PokeAPI** (`https://pokeapi.co`). Verás cómo se hace una **petición HTTP** desde Android
con `HttpURLConnection`, por qué tiene que ir en un **hilo secundario** (aquí, con la
`AsyncTask` de la rama 3.4), cómo se lee la respuesta en formato **JSON** y cómo se pasan
los datos a la lista.

Necesitas conexión a internet en el emulador o en el móvil. Al compilar sale el aviso
`Some input files use or override a deprecated API`. Es por `AsyncTask`, y no es un error.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📘 **UD 3.5 · Peticiones REST** | [`recursos/html/UD_3_5_REST.html`](recursos/html/UD_3_5_REST.html) | Cliente y servidor, la URL, métodos y códigos de respuesta, JSON y cómo leerlo en Java, el permiso, el hilo secundario y `HttpURLConnection`, y cómo se hace hoy. Con tres simuladores y comprobaciones. |
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | Para consultar lo que ya has visto. |

Ábrelos en el navegador desde tu copia del proyecto: en Android Studio, botón
derecho sobre el fichero → *Open In → Browser* (en GitHub solo se ve su código).
Dentro de cada uno, arriba del índice lateral, tienes los enlaces al resto de
apuntes.

## Qué repasar antes

| Dónde | Por qué ahora |
|---|---|
| **Rama 3.4 · AsyncTask** | La petición se hace con una tarea asíncrona: `doInBackground()` y `onPostExecute()`. |
| **Rama 2.2 · Spinner** | La lista usa un `ArrayAdapter`, el mismo adaptador del Spinner. |
| **UD2 · Mensajes al usuario → Toast** | Los avisos cuando algo falla. |

## Dónde está en el código

| TODO | Fichero | Qué explica |
|---|---|---|
| 1 | `AndroidManifest.xml` | El permiso para usar internet |
| 2-3 | `io/HttpConnectPokemon.java` | La URL base y el endpoint |
| 4-4.4 | `io/HttpConnectPokemon.java` | La petición GET: abrir la conexión, comprobar el código 200, leer la respuesta y cerrar |
| 5 | `io/HttpConnectPokemon.java` | La petición POST (no se usa: PokeAPI solo permite consultar) |
| 6-7 | `MainActivity.java` | La lista con su adaptador y lanzar la petición |
| 8 | `io/ConnectionTask.java` | Por qué hace falta un hilo secundario y los tres tipos de la tarea |
| 9 | `io/ConnectionTask.java` | El constructor: lo que la tarea recibe de la actividad |
| 10 | `io/ConnectionTask.java` | `doInBackground()`: la petición |
| 11-14 | `io/ConnectionTask.java` | `onPostExecute()`: leer el JSON, avisar al adaptador y los errores |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.

## Apuntes comunes

| Apuntes | Fichero |
|---|---|
| 📌 **Cómo usar este repositorio** | [`recursos/html/como_usar.html`](recursos/html/como_usar.html) |
| 🧭 **Guía de Android Studio** | [`recursos/html/guia_android_studio.html`](recursos/html/guia_android_studio.html) |
