# UD 2.1.1 · Button: dos formas de atender un clic

Dos formas de atender el clic de un botón: una clase anónima por botón, o la
actividad implementando `View.OnClickListener` con un único `onClick()` que
distingue los botones por su id.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | **La teoría de toda la unidad.** Layouts, eventos, componentes, recursos, temas y estilos, barra de app y menús, mensajes, actividades e intenciones, menú contextual y fragmentos. |
| 📘 **UD 2.1.1 · Button** | [`recursos/html/UD_2_1_1_Button.html`](recursos/html/UD_2_1_1_Button.html) | Lo de esta rama: las dos formas de escribir un *listener* y cuándo conviene cada una. |

Los apuntes de la **UD2** son los de la unidad entera: los vas a usar en este
tema y en todos los que vienen después (`UD_2_2_Spinner`, `UD_2_3_New_Intent`…).
Tenlos abiertos mientras trabajas: lo que aquí se practica, allí se explica.

Ábrelos en el navegador desde tu copia del proyecto: en Android Studio, botón
derecho sobre el fichero → *Open In → Browser* (en GitHub solo se ve su código).
Dentro de cada uno, arriba del índice lateral, tienes los enlaces al resto de
apuntes.

## Qué mirar de la teoría en este tema

| Apartado de la UD2 | Por qué ahora |
|---|---|
| **Eventos de usuario** | Es de lo que va esta rama: quién atiende el clic y cómo. |
| **Componentes de la interfaz** | Los dos `Button` y el `TextView` con los que trabajas. |
| **Los layouts** | Cómo se colocan los dos botones en la pantalla. |

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
🧭 [Guía de Android Studio](recursos/html/guia_android_studio.html) ·
📘 [UD1 · Introducción a Android](recursos/html/UD01_Introduccion_Android.html)
