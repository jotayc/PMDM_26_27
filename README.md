# UD 2.2 · Spinner

Un desplegable con las provincias de Andalucía: al elegir una, aparece un
mensaje con su nombre. Verás cómo una vista muestra una lista de datos que no
están en el layout, sino que le llegan a través de un **adaptador**.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | **La teoría de toda la unidad.** Layouts, eventos, componentes, recursos, temas y estilos, barra de app y menús, mensajes, actividades e intenciones, menú contextual y fragmentos. |
| 📘 **UD 2.2 · Spinner** | [`recursos/html/UD_2_2_Spinner.html`](recursos/html/UD_2_2_Spinner.html) | Lo de esta rama: el desplegable, el adaptador y el evento de selección. |

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
| **Componentes de la interfaz** | El `Spinner` y el resto de vistas que muestran listas. |
| **Recursos de la interfaz** | De dónde salen las provincias: un `string-array` en `res/values/`. |
| **Eventos de usuario** | Aquí el evento no es un clic, es un cambio de selección. |
| **Mensajes al usuario** | El `Toast` con el que se confirma la provincia elegida. |

## Dónde está en el código

| TODO | Fichero | Qué explica |
|---|---|---|
| 1 | `MainActivity.java` | Declaración del objeto `Spinner` |
| 2 | `MainActivity.java` | `findViewById()`: inicializar el spinner |
| 3 | `MainActivity.java` | Crear el adaptador con `createFromResource()` |
| 4 | `MainActivity.java` | El diseño de cada fila de la lista desplegada |
| 5 | `MainActivity.java` | `setAdapter()`: unir el adaptador con la vista |
| 6 | `MainActivity.java` | `OnItemSelectedListener`: enterarse de la selección |
| 7 | `MainActivity.java` | El método que lanza el `Toast` |
| — | `res/values/array.xml` | La lista de provincias |
| — | `res/layout/activity_main.xml` | El `Spinner` y el título del diseño |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.
