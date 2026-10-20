# UD 2.4.1 · El lanzador de resultados

Dos pantallas: la primera abre la segunda, en la segunda escribes un texto y,
al cerrarla, ese texto aparece en la primera. Verás la forma actual de que una
actividad le **devuelva un dato** a la que la abrió: un **lanzador** registrado
con `registerForActivityResult()`.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | **La teoría de toda la unidad.** Layouts, eventos, componentes, recursos, temas y estilos, barra de app y menús, mensajes, actividades e intenciones, menú contextual y fragmentos. |
| 📘 **UD 2.4.1 · El lanzador de resultados** | [`recursos/html/UD_2_4_1_registerForActivity.html`](recursos/html/UD_2_4_1_registerForActivity.html) | Lo de esta rama: el lanzador, su contrato y su callback, por qué se registra como atributo y cómo se prepara y se recoge el resultado. |

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
| **Actividades e intenciones** | Es el apartado de este tema. El subapartado 9.4, *Obtener un resultado de otra actividad*, explica lo mismo que esta rama, con el callback escrito como lambda. |
| **Componentes de la interfaz** | El `EditText` donde se escribe el texto que se devuelve. |
| **Recursos de la interfaz** | Los textos de los dos layouts, que deberían salir de `strings.xml`. |

## Dónde está en el código

| TODO | Fichero | Qué explica |
|---|---|---|
| 1 | `MainActivity.java` | Los objetos de la pantalla |
| 2 | `MainActivity.java` | El lanzador, registrado como atributo |
| 3 | `MainActivity.java` | El contrato: qué tipo de petición es |
| 4 | `MainActivity.java` | El callback: el código que recibe el resultado |
| 5-6 | `MainActivity.java` | Comprobar la respuesta y leer el texto devuelto |
| 7-10 | `MainActivity.java` | El layout, las vistas, el botón y la intención de ida con un saludo |
| 11 | `MainActivity.java` | `launch()`: abrir la segunda actividad con el lanzador |
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
