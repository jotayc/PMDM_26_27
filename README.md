# UD 2.7 · Menú simple

Tres colores y una opción de aplicar en la **barra de app**. Pulsar un color lo
deja elegido y *Aplicar* pinta el fondo con él. Verás cómo se describe un menú en
XML, cómo se **infla** y cómo se responde a sus opciones.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | **La teoría de toda la unidad.** Layouts, eventos, componentes, recursos, temas y estilos, barra de app y menús, mensajes, actividades e intenciones, menú contextual y fragmentos. |
| 📘 **UD 2.7 · Menú simple** | [`recursos/html/UD_2_7_menu_simple.html`](recursos/html/UD_2_7_menu_simple.html) | Lo de esta rama: el fichero del menú, `app:showAsAction`, inflar y responder a las opciones. Con un simulador de la barra. |

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
| **Barra de app y menús** | Es el apartado de este tema: la barra, el fichero del menú y los métodos que lo crean y responden. |
| **Recursos de la interfaz** | De dónde salen los iconos: `res/drawable/`. |
| **Mensajes al usuario → Toast** | El aviso que aparece al elegir un color. |

## Dónde está en el código

| TODO | Fichero | Qué explica |
|---|---|---|
| 1-2 | `MainActivity.java` | El layout y el color elegido |
| 3-4 | `MainActivity.java` | `onCreateOptionsMenu()` e inflar el menú |
| 5-6 | `MainActivity.java` | `onOptionsItemSelected()` y el id de la opción |
| 7-8 | `MainActivity.java` | Guardar el color y aplicarlo |
| 9 | `MainActivity.java` | Qué significa devolver `true` |
| — | `res/menu/simple_menu.xml` | Las opciones del menú |
| — | `res/layout/activity_main.xml` | El layout vacío con su id |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.
