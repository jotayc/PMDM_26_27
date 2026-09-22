# UD 2.1.1 · Button: dos formas de atender un clic

Dos formas de atender el clic de un botón: una clase anónima por botón, o la
actividad implementando `View.OnClickListener` con un único `onClick()` que
distingue los botones por su id.

## 📘 Apuntes del tema

[`recursos/html/UD_2_1_1_Button.html`](recursos/html/UD_2_1_1_Button.html)

Ábrelo en el navegador desde tu copia del proyecto: en Android Studio, botón
derecho sobre el fichero → *Open In → Browser* (en GitHub solo se ve su código).

## Dónde está en el código

| TODO | Fichero | Qué explica |
|---|---|---|
| 1 | `MainActivity.java` | `onCreate()`, el punto de partida de la actividad |
| 2 | `MainActivity.java` | Declaración de los dos `Button` y el `TextView` |
| 3 | `MainActivity.java` | `setContentView()`: conectar el layout con la actividad |
| 4 | `MainActivity.java` | `findViewById()`: inicializar los objetos |
| 5 | `MainActivity.java` | Las dos formas de atender el clic y la pulsación larga |
| 6 | `MainActivity.java` | Métodos del ciclo de vida |
| — | `MainActivity.java` | Método `onClick()` de la actividad (forma 2) |
| — | `res/layout/activity_main.xml` | El `TextView` y los dos botones |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.

---

📌 [Cómo usar este repositorio](recursos/html/como_usar.html) ·
🧭 [Guía de Android Studio](recursos/html/guia_android_studio.html)
