# UD 2.5 · RecyclerView

Una lista de películas, cada una con su cartel, su título y una descripción.
Verás cómo se muestra una lista larga sin gastar memoria: el **RecyclerView**
solo crea las filas que se ven y las va **reciclando** al desplazar, con un
**adaptador** que las rellena con los datos.

## 📘 Apuntes

| Apuntes | Fichero | Para qué |
|---|---|---|
| 📗 **UD2 · La interfaz de usuario** | [`recursos/html/UD02_Interfaz_Usuario.html`](recursos/html/UD02_Interfaz_Usuario.html) | **La teoría de toda la unidad.** Layouts, eventos, componentes, recursos, temas y estilos, barra de app y menús, mensajes, actividades e intenciones, menú contextual y fragmentos. |
| 📘 **UD 2.5 · RecyclerView** | [`recursos/html/UD_2_5_RecyclerView.html`](recursos/html/UD_2_5_RecyclerView.html) | Lo de esta rama, pieza a pieza: el modelo, el molde de la fila, el ViewHolder, el adaptador y el LayoutManager. Con simuladores para ver el reciclado por dentro. |

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
| **Componentes de la interfaz → RecyclerView** | Es el apartado de este tema: el reciclado, el adaptador y sus tres métodos. |
| **Componentes de la interfaz → Controles de selección** | El adaptador del Spinner, que ya conoces, es la misma idea en pequeño. |
| **Recursos de la interfaz** | De dónde salen las imágenes de las películas: `res/drawable/` y sus constantes en `R`. |

## Dónde está en el código

| TODO | Fichero | Qué explica |
|---|---|---|
| 1 | `Controllers/MainActivity.java` | Declarar el RecyclerView y el adaptador |
| 2-3 | `Adapters/RecyclerAdapter.java` | La clase ViewHolder y su constructor |
| 4 | `Adapters/RecyclerAdapter.java` | La clase del adaptador |
| 5-6 | `Adapters/RecyclerAdapter.java` | `onCreateViewHolder()` y el inflado de la fila |
| 7 | `Adapters/RecyclerAdapter.java` | `onBindViewHolder()`: rellenar una fila |
| 8 | `Adapters/RecyclerAdapter.java` | `getItemCount()` |
| 9 | `Controllers/MainActivity.java` | Inicializar el RecyclerView y el adaptador |
| 10 | `Controllers/MainActivity.java` | El método que fabrica los datos |
| 11-12 | `Controllers/MainActivity.java` | El LayoutManager y unir las piezas |
| — | `Models/Pelicula.java` | El modelo: los datos de cada película |
| — | `res/layout/custom_item_list.xml` | El molde de cada fila |
| — | `res/layout/activity_main.xml` | El RecyclerView a pantalla completa |

La ventana **TODO** de Android Studio (*View → Tool Windows → TODO*) los lista
todos: un clic en uno te lleva a su línea.
