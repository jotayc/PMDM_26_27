# UD 3.4 · AsyncTask

Un contador que va del 0 % al 100 %, un punto por segundo, hecho con una **tarea
asíncrona**. Verás cómo `AsyncTask` reparte el trabajo entre el hilo secundario
(`doInBackground()`) y el principal (`onPreExecute()`, `onProgressUpdate()`,
`onPostExecute()`), cómo se lanza y se cancela, **por qué está obsoleta** desde la API 30
y qué se usa hoy en su lugar: `ExecutorService` y `Handler`.

Al compilar sale el aviso `uses or overrides a deprecated API`. Es por `AsyncTask`, y no
es un error.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📘 **UD 3.4 · AsyncTask** | [`recursos/html/UD_3_4_Asyntask.html`](recursos/html/UD_3_4_Asyntask.html) | Las dos reglas de los hilos, los cuatro métodos y su hilo, los tres tipos, `execute()` y `cancel()`, qué pasa al girar el móvil y cómo se hace hoy. Con dos simuladores y comprobaciones. |
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | Para consultar lo que ya has visto. |

Ábrelos en el navegador desde tu copia del proyecto: en Android Studio, botón
derecho sobre el fichero → *Open In → Browser* (en GitHub solo se ve su código).
Dentro de cada uno, arriba del índice lateral, tienes los enlaces al resto de
apuntes.

## Qué repasar antes

| Dónde | Por qué ahora |
|---|---|
| **UD2 · Eventos de usuario** | Los listeners de los dos botones, con clase anónima. |
| **UD2 · Mensajes al usuario → Toast** | El aviso «Proceso cancelado». |
| **PSP · Hilos** | Qué es un hilo, `sleep()` e `interrupt()`. |

## Dónde está en el código

Todo está en `MainActivity.java`.

| TODO | Qué explica |
|---|---|
| 1 | El atributo con la tarea |
| 2 | Lanzar: una instancia nueva cada vez y `execute()` |
| 3 | Cancelar con `cancel(true)` |
| 4 | La clase y sus tres tipos `<Void, Integer, Void>` |
| 5 | `onPreExecute()`: preparar la pantalla |
| 6-7 | `doInBackground()` y `publishProgress()` |
| 8 | `onProgressUpdate()`: enseñar el progreso |
| 9 | `onCancelled()`: si se ha cancelado |
| 10 | `onPostExecute()`: si ha terminado |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.
