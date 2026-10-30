# UD 2.9 · Menú contextual flotante

Mantienes pulsado un botón y aparece junto al dedo un menú con colores; al
elegir uno, el botón cambia. Verás cómo se **registra** una vista para que tenga
menú contextual y qué métodos llama Android al abrirlo, al elegir y al cerrarlo.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | **La teoría de toda la unidad.** Layouts, eventos, componentes, recursos, temas y estilos, barra de app y menús, mensajes, actividades e intenciones, menú contextual y fragmentos. |
| 📘 **UD 2.9 · Menú contextual flotante** | [`recursos/html/UD_2_9_floating_menu.html`](recursos/html/UD_2_9_floating_menu.html) | Lo de esta rama: el registro de la vista, el recorrido del menú y los tres métodos. Con un simulador que enseña cada llamada. |

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
| **Menú contextual** | Es el apartado de este tema: el registro y los métodos que crean y atienden el menú. |
| **Barra de app y menús → Crear un menú** | Cómo se define un menú en XML y qué significa cada atributo. |

## Dónde está en el código

| TODO | Fichero | Qué explica |
|---|---|---|
| 1 | `MainActivity.java` | Registrar la vista |
| 2-3 | `MainActivity.java` | `onCreateContextMenu()`: crear las opciones |
| 4-5 | `MainActivity.java` | `onContextItemSelected()`: responder a la opción |
| 6 | `MainActivity.java` | `onContextMenuClosed()`: saber que se ha cerrado |
| — | `res/menu/floating_menu.xml` | Las opciones del menú |
| — | `res/layout/activity_main.xml` | Los dos botones |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.
