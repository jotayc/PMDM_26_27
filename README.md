# UD 3.3 · Hilos

Un contador que va del 0 % al 100 %, un punto por segundo. Cada segundo de espera hace
el papel de una tarea lenta. Verás por qué una tarea así **congela la aplicación** si la
hace el hilo principal, cómo se lleva a un **hilo secundario** y cómo ese hilo le pide al
principal que cambie la pantalla con **runOnUiThread()**.

El código tiene tres versiones del contador; solo la tercera funciona bien. Las otras dos
están para que veas qué pasa al saltarse cada una de las dos reglas del tema.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📘 **UD 3.3 · Hilos** | [`recursos/html/UD_3_3_Hilos.html`](recursos/html/UD_3_3_Hilos.html) | El hilo principal y su cola, el aviso «no responde», la regla de las vistas, `runOnUiThread()`, la copia `final`, cancelar y `onDestroy()`. Con tres simuladores y comprobaciones. |
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | Para consultar lo que ya has visto. |

Ábrelos en el navegador desde tu copia del proyecto: en Android Studio, botón
derecho sobre el fichero → *Open In → Browser* (en GitHub solo se ve su código).
Dentro de cada uno, arriba del índice lateral, tienes los enlaces al resto de
apuntes.

## Qué repasar antes

| Dónde | Por qué ahora |
|---|---|
| **UD2 · Eventos de usuario** | Los listeners de los dos botones, con clase anónima. |
| **PSP · Hilos** | `Thread`, `Runnable`, `start()`, `sleep()` e `interrupt()`, que aquí se usan igual. |

## Dónde está en el código

Todo está en `MainActivity.java`.

| TODO | Qué explica |
|---|---|
| 1 | El hilo, guardado en un atributo |
| 2 | Los botones al empezar a contar |
| 3-5 | Las tres versiones: se prueba una cada vez |
| 6 | Cancelar con `interrupt()` |
| 7 | Versión 1: `sleep()` en el hilo principal |
| 8 | Versión 2: un hilo secundario que toca la vista |
| 9-13 | Versión 3: el hilo, el `catch`, la copia `final` y `runOnUiThread()` |
| 14 | `onDestroy()`: parar el hilo al destruirse la actividad |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.
