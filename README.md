# UD 2.6 · Toast, diálogos y Snackbar

Tres botones, tres formas de avisar al usuario: un **Toast** que se oculta solo,
un **AlertDialog** que espera una respuesta y un **Snackbar** que puede ofrecer
una acción, como «Deshacer».

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | **La teoría de toda la unidad.** Layouts, eventos, componentes, recursos, temas y estilos, barra de app y menús, mensajes, actividades e intenciones, menú contextual y fragmentos. |
| 📘 **UD 2.6 · Toast, diálogos y Snackbar** | [`recursos/html/UD_2_6_Notificaciones_simples.html`](recursos/html/UD_2_6_Notificaciones_simples.html) | Lo de esta rama: cuándo usar cada aviso, el builder del diálogo y los listeners de sus botones. Con un simulador para compararlos. |

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
| **Mensajes al usuario** | Es el apartado de este tema: Toast, AlertDialog y Snackbar. |
| **Eventos de usuario** | Los listeners y las clases anónimas que usan los botones. |

## Dónde está en el código

| TODO | Fichero | Qué explica |
|---|---|---|
| 1-2 | `MainActivity.java` | Los tres botones |
| 3, 8 | `MainActivity.java` | El Toast y el método `myLongToast()` |
| 4 | `MainActivity.java` | Pedir el diálogo y mostrarlo |
| 5-7 | `MainActivity.java` | El Snackbar y su acción |
| 9-10 | `MainActivity.java` | El builder del diálogo |
| 11 | `MainActivity.java` | Los botones del diálogo |
| 12 | `MainActivity.java` | `create()`: fabricar el diálogo |
| — | `res/layout/activity_main.xml` | Los tres botones |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.
