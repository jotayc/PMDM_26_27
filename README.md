# UD 2.4 · Resultado de una actividad

Dos pantallas: la primera abre la segunda, en la segunda escribes un texto y,
al cerrarla, ese texto aparece en la primera. Verás cómo una actividad le
**devuelve un dato** a la que la abrió.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | **La teoría de toda la unidad.** Layouts, eventos, componentes, recursos, temas y estilos, barra de app y menús, mensajes, actividades e intenciones, menú contextual y fragmentos. |
| 📘 **UD 2.4 · Resultado de una actividad** | [`recursos/html/UD_2_4_ActivityForResult.html`](recursos/html/UD_2_4_ActivityForResult.html) | Lo de esta rama: abrir una actividad esperando respuesta, los códigos de petición y de resultado, y cómo se recoge. |

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
| **Actividades e intenciones** | Es el apartado de este tema. El subapartado 9.4, *Obtener un resultado de otra actividad*, explica la forma actual de hacer lo que aquí se hace con la clásica. |
| **Componentes de la interfaz** | El `EditText` donde se escribe el texto que se devuelve. |
| **Recursos de la interfaz** | Los textos de los dos layouts, que deberían salir de `strings.xml`. |

## Dónde está en el código

| TODO | Fichero | Qué explica |
|---|---|---|
| 1-5 | `MainActivity.java` | Los objetos, el código de petición, las vistas y el listener del botón |
| 6 | `MainActivity.java` | La intención de ida, con un saludo como extra |
| 7 | `MainActivity.java` | `startActivityForResult()`: abrir esperando respuesta |
| 8 | `MainActivity.java` | Sobrescribir `onActivityResult()` |
| 9-11 | `MainActivity.java` | Comprobar los dos códigos y leer el texto devuelto |
| 12 | `SecondActivity.java` | Las constantes con los nombres de los datos |
| 13-15 | `SecondActivity.java` | Las vistas y el saludo recibido |
| 16 | `SecondActivity.java` | Leer el `EditText` |
| 17-19 | `SecondActivity.java` | La intención de vuelta y `setResult()` |
| 20 | `SecondActivity.java` | `finish()`: cerrar para entregar el resultado |
| — | `AndroidManifest.xml` | La declaración de `SecondActivity` |
| — | `res/layout/activity_main.xml` | El texto donde aparece la respuesta y el botón |
| — | `res/layout/activity_second.xml` | El saludo, el campo de texto y el botón de volver |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.
