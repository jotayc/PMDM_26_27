# UD 3.2 · SQLite

Una pequeña aplicación que guarda ciudades en una base de datos dentro del móvil.
Verás cómo se crea con **SQLiteOpenHelper**, cómo se actualiza con su **número de
versión** y cómo se insertan y se consultan filas con **ContentValues** y **Cursor**.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📘 **UD 3.2 · SQLite** | [`recursos/html/UD_3_2_SQLite.html`](recursos/html/UD_3_2_SQLite.html) | Cuándo usar una base de datos, tablas y filas, las clases de Android, las versiones, insertar, consultar, el cursor y el código de la rama. Con cinco simuladores y comprobaciones. |
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | Para consultar lo que ya has visto. |

Ábrelos en el navegador desde tu copia del proyecto: en Android Studio, botón
derecho sobre el fichero → *Open In → Browser* (en GitHub solo se ve su código).
Dentro de cada uno, arriba del índice lateral, tienes los enlaces al resto de
apuntes.

## Qué repasar de la UD2 para este tema

| Apartado de la UD2 | Por qué ahora |
|---|---|
| **Eventos de usuario** | Los listeners de los dos botones. |
| **Mensajes al usuario → Toast** | Los avisos que da la aplicación. |

## Dónde está en el código

| TODO | Fichero | Qué explica |
|---|---|---|
| 1-3 | `Resources/DBAccess.java` | La clase, la versión y el constructor |
| 4-6 | `Resources/DBAccess.java` | `onCreate()`: crear la tabla |
| 7-8 | `Resources/DBAccess.java` | `onUpgrade()`: el `switch` sin `break` |
| 9-13 | `Resources/DBAccess.java` | Insertar una fila |
| 14-19 | `Resources/DBAccess.java` | Consultar con `query()` y el cursor |
| 20-21 | `Resources/DBAccess.java` | Recorrer todas las filas |
| 22 | `controllers/MainActivity.java` | Crear el acceso a la base de datos |
| 23-24 | `controllers/MainActivity.java` | Insertar desde el botón |
| 25 | `controllers/MainActivity.java` | Mostrar la primera ciudad |
| — | `res/layout/activity_main.xml` | Los campos, con su `inputType` |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.
