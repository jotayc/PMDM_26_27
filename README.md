# UD 3.1 · Preferencias

Una pantalla de ajustes en la que se escribe un email que sigue ahí aunque cierres
la aplicación. Verás cómo se describe en XML, cómo la construye un **fragmento** y
cómo se lee el valor guardado con **SharedPreferences**.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📘 **UD 3.1 · Preferencias** | [`recursos/html/UD_3_1_Preferences.html`](recursos/html/UD_3_1_Preferences.html) | Por qué se pierden los datos, cómo funcionan las preferencias, la pantalla de ajustes en XML, los fragmentos y el código de la rama. Con cuatro simuladores y comprobaciones. |
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | Para consultar lo que ya has visto. |

Ábrelos en el navegador desde tu copia del proyecto: en Android Studio, botón
derecho sobre el fichero → *Open In → Browser* (en GitHub solo se ve su código).
Dentro de cada uno, arriba del índice lateral, tienes los enlaces al resto de
apuntes.

## Qué repasar de la UD2 para este tema

| Apartado de la UD2 | Por qué ahora |
|---|---|
| **Fragmentos** | Qué es un fragmento y qué es una transacción. |
| **Actividades e intenciones** | La intención que abre los ajustes y la pila de actividades. |

## Dónde está en el código

| TODO | Fichero | Qué explica |
|---|---|---|
| 1 | `controllers/MainActivity.java` | Abrir la pantalla de ajustes |
| 2-3 | `fragments/SettingsFragment.java` | El fragmento que construye la pantalla |
| 4-5 | `controllers/SettingActivity.java` | Colocar el fragmento con una transacción |
| 6-7 | `controllers/SettingActivity.java` | La flecha de volver |
| 8 | `controllers/MainActivity.java` | Por qué se carga en `onResume()` |
| 9-11 | `controllers/MainActivity.java` | Leer el valor por su clave |
| — | `res/xml/root_preferences.xml` | Las preferencias |
| — | `app/build.gradle` | La biblioteca de preferencias |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.
