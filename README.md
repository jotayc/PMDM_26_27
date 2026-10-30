# UD 2.8 · Menú de acción

Mantienes pulsado un botón y la barra de arriba se transforma: ofrece tres
colores para ese botón y, al elegir uno, vuelve a ser la de siempre. Verás cómo
se abre esta barra temporal, el **modo de acción**, y qué métodos llama Android
mientras está abierta.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | **La teoría de toda la unidad.** Layouts, eventos, componentes, recursos, temas y estilos, barra de app y menús, mensajes, actividades e intenciones, menú contextual y fragmentos. |
| 📘 **UD 2.8 · Menú de acción** | [`recursos/html/UD_2_8_action_menu.html`](recursos/html/UD_2_8_action_menu.html) | Lo de esta rama: el menú de acción, la pulsación larga y los cuatro métodos del Callback. Con un simulador que enseña cada llamada. |

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
| **Menú contextual → Menú de acción** | Es el apartado de este tema: el Callback, sus cuatro métodos y en qué se diferencia del menú contextual. |
| **Barra de app y menús** | Qué es la barra de app, a la que sustituye este menú, y cómo se define un menú en XML. |
| **Eventos de usuario** | Los listeners y las clases anónimas, que aquí aparecen de una forma nueva. |

## Dónde está en el código

| TODO | Fichero | Qué explica |
|---|---|---|
| 1 | `MainActivity.java` | El atributo que recuerda si hay uno abierto |
| 2-3 | `MainActivity.java` | La pulsación larga y abrir el menú |
| 4 | `MainActivity.java` | El Callback en un atributo |
| 5 | `MainActivity.java` | `onCreateActionMode()`: crear las opciones |
| 6 | `MainActivity.java` | `onPrepareActionMode()` |
| 7-8 | `MainActivity.java` | `onActionItemClicked()` y `finish()` |
| 9 | `MainActivity.java` | `onDestroyActionMode()`: dejarlo listo |
| — | `res/menu/action_menu.xml` | Las opciones del menú |
| — | `res/layout/activity_main.xml` | Los dos botones |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.
