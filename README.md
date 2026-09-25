# UD 2.1 · Button

Una pantalla con un texto y un botón que lo cambia al pulsarlo. Verás cómo se
conecta el diseño XML con el código Java (`setContentView`, `findViewById`) y
cómo se responde a una pulsación corta y a una larga con *listeners*.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | **La teoría de toda la unidad.** Layouts, eventos, componentes, recursos, temas y estilos, barra de app y menús, mensajes, actividades e intenciones, menú contextual y fragmentos. |
| 📘 **UD 2.1 · Button** | [`recursos/html/UD_2_1_Button.html`](recursos/html/UD_2_1_Button.html) | Lo de esta rama: el botón, los *listeners* y el ciclo de vida de la actividad. |

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
| **Los layouts** | Entender el XML de `activity_main.xml` antes de tocarlo. |
| **Eventos de usuario** | Es justo lo que hace esta rama: responder a una pulsación. |
| **Componentes de la interfaz** | `TextView` y `Button`, sus atributos y sus métodos. |
| **Recursos de la interfaz** | De dónde sale el texto del botón y por qué no se escribe a mano. |

## Dónde está en el código

| TODO | Fichero | Qué explica |
|---|---|---|
| 1 | `MainActivity.java` | `onCreate()`, el punto de partida de la actividad |
| 2 | `MainActivity.java` | Declaración de los objetos `Button` y `TextView` |
| 3 | `MainActivity.java` | `setContentView()`: conectar el layout con la actividad |
| 4 | `MainActivity.java` | `findViewById()`: inicializar los objetos |
| 5 | `MainActivity.java` | Listeners de clic y de pulsación larga con clases anónimas |
| 6 | `MainActivity.java` | Métodos del ciclo de vida |
| — | `res/layout/activity_main.xml` | El `TextView` y el `Button` del diseño |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.

---

📌 [Cómo usar este repositorio](recursos/html/como_usar.html) ·
🧭 [Guía de Android Studio](recursos/html/guia_android_studio.html) ·
📘 [UD1 · Introducción a Android](recursos/html/UD01_Introduccion_Android.html)
