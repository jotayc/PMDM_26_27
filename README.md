# UD 2.3 · Intent

Dos pantallas: en la primera escribes un texto y pulsas un botón; la segunda se
abre y lo muestra. Verás cómo una aplicación pasa de una actividad a otra con
una **intención** y cómo se le envían datos por el camino.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | **La teoría de toda la unidad.** Layouts, eventos, componentes, recursos, temas y estilos, barra de app y menús, mensajes, actividades e intenciones, menú contextual y fragmentos. |
| 📘 **UD 2.3 · Intent** | [`recursos/html/UD_2_3_New_Intent.html`](recursos/html/UD_2_3_New_Intent.html) | Lo de esta rama: varias actividades, la intención explícita, los extras y la pila de actividades. |

Los apuntes de la **UD2** son los de la unidad entera: los vas a usar en este
tema y en todos los que vienen después. Tenlos abiertos mientras trabajas: lo
que aquí se practica, allí se explica.

Ábrelos en el navegador desde tu copia del proyecto: en Android Studio, botón
derecho sobre el fichero → *Open In → Browser* (en GitHub solo se ve su código).
Dentro de cada uno, arriba del índice lateral, tienes los enlaces al resto de
apuntes.

## Qué mirar de la teoría en este tema

| Apartado de la UD2 | Por qué ahora |
|---|---|
| **Actividades e intenciones** | Es el apartado de este tema: qué es una actividad, qué es un `Intent` y cómo se pasan datos. |
| **Componentes de la interfaz** | El `EditText`, que aquí aparece por primera vez. |
| **Recursos de la interfaz** | Los textos de los dos layouts, que deberían salir de `strings.xml`. |

## Dónde está en el código

| TODO | Fichero | Qué explica |
|---|---|---|
| 1-4 | `MainActivity.java` | `onCreate()`, los objetos, `setContentView()` y `findViewById()` |
| 5 | `MainActivity.java` | El listener del botón |
| 6 | `MainActivity.java` | Crear la intención explícita |
| 7 | `MainActivity.java` | Leer el `EditText` y adjuntar el texto con `putExtra()` |
| 8 | `MainActivity.java` | `startActivity()`: abrir la segunda pantalla |
| 9 | `SecondActivity.java` | La constante con el nombre del dato |
| 10-12 | `SecondActivity.java` | El layout propio y sus vistas |
| 13-14 | `SecondActivity.java` | `getIntent()` y `getStringExtra()` |
| 15 | `SecondActivity.java` | `finish()`: cerrar y volver |
| — | `AndroidManifest.xml` | La declaración de `SecondActivity` |
| — | `res/layout/activity_main.xml` | El campo de texto y el botón |
| — | `res/layout/activity_second.xml` | El texto recibido y el botón de volver |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.
