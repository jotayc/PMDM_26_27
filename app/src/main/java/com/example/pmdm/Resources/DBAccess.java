package com.example.pmdm.Resources;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

//Todo 1. Se hereda de SQLiteOpenHelper, la clase que crea la base de datos y la mantiene al día
public class DBAccess extends SQLiteOpenHelper {

    //Database name
    private static final String DB_NAME = "db_dam";

    //Table name
    private static final String DB_TABLE_NAME = "db_ciudades";

    //Todo 2. La versión debe ser >= 1. Se sube cada vez que cambia la estructura de las tablas
    private static final int DB_VERSION = 3;

    //Columns
    private static final String CITY_COLUMN = "cityName";

    private static final String POBLATION_COLUMN = "poblation";

    private static final String SURFACE_COLUMN = "surface";

    /**
     * Constructor de la base de datos. Crearlo no abre nada todavía: la base de datos se crea o se
     * actualiza la primera vez que se pide acceso a ella.
     * @param context Contexto de la aplicación
     */
    public DBAccess(Context context) {
        //Todo 3. Se le indica a la clase padre el nombre y la versión de la base de datos
        super(context, DB_NAME, null, DB_VERSION);
    }

    //Todo 4. Se sobrescribe onCreate, que solo se ejecuta si la base de datos no existe todavía.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Todo 5. Tiene que crear las tablas en su última versión, porque lo ejecutan los usuarios
        //Todo -> nuevos. Los comentarios enseñan cómo era en las versiones anteriores

        // Version 1
        //String CREATE_USER_TABLE = "CREATE TABLE " + DB_TABLE_NAME + "("
        //        + CITY_COLUMN + " TEXT)";

        // Version 2
        //String CREATE_USER_TABLE = "CREATE TABLE " + DB_TABLE_NAME + "("
        //        + CITY_COLUMN + " TEXT,"
        //        + POBLATION_COLUMN + " INTEGER)";

        // Version 3
        String CREATE_USER_TABLE =  "CREATE TABLE " +DB_TABLE_NAME+ "("
                +CITY_COLUMN+ " TEXT,"
                 + POBLATION_COLUMN + " INTEGER,"
                + SURFACE_COLUMN + " REAL" + ")";

        //Todo 6. execSQL ejecuta una sentencia SQL que no devuelve resultados
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);

        // Los mensajes de Log sirven para que el programador, durante el desarrollo, pueda recibir
        // mensajes técnicos sobre el funcionamiento del programa sin que el usuario los vea.
        // Aparecen en la pestaña Logcat de Android Studio.
        Log.d("DB", "Tablas creadas");
    }

    //Todo 7. Se sobrescribe onUpgrade, que se ejecuta si la versión instalada es menor que DB_VERSION
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.d("DB", "onUpgrade desde la versión " + oldVersion);

        //Todo 8. Cada usuario puede venir de una versión distinta. Por eso el switch empieza en la
        //Todo -> que tiene y NO lleva break: sigue por los case siguientes hasta la última versión.
        //Todo -> Quien tiene la versión 1 pasa por los dos case; quien tiene la 2, solo por el segundo
        switch(oldVersion){
            case 1:
                sqLiteDatabase.execSQL("ALTER TABLE " + DB_TABLE_NAME  +" ADD COLUMN " + POBLATION_COLUMN +" INTEGER");
                Log.i("DB", "BBDD actualizada a la versión 2");
            case 2:
                sqLiteDatabase.execSQL("ALTER TABLE " + DB_TABLE_NAME  +" ADD COLUMN " + SURFACE_COLUMN +" REAL");
                Log.i("DB", "BBDD actualizada a la versión 3");
        }
    }

    public void getVersionDB(){
        Log.d("DB", "Versión de la base de datos: " + this.getReadableDatabase().getVersion());
    }

    //Todo 9. Método para insertar una fila. Devuelve el número de fila, o -1 si ha fallado
    public long insert(String city, int poblation, float superficie){

        //Todo 10. Se pide acceso de escritura a la base de datos
        SQLiteDatabase db = this.getWritableDatabase();
        long result = -1;

        //Todo 11. ContentValues guarda los datos como pares columna-valor
        ContentValues values = new ContentValues();

        values.put(CITY_COLUMN, city);
        values.put(POBLATION_COLUMN, poblation);
        values.put(SURFACE_COLUMN, superficie);

        //Todo 12. Parámetros de insert: la tabla; una columna que pueda quedar a null si values
        //Todo -> viniese vacío (aquí no hace falta); y los valores
        result = db.insert(DB_TABLE_NAME,null,values);

        //Todo 13. Al terminar se cierra la conexión
        db.close();

        return result;
    }

    //Todo 14. Método para recuperar datos: aquí, la primera ciudad de la tabla
    public String getFirstCity(){

        String result = null;

        //Todo 15. Se pide acceso de lectura
        SQLiteDatabase db = this.getReadableDatabase();

        //Todo 16. Las columnas que se quieren. Los cinco null de query son las partes opcionales
        //Todo -> de la consulta: WHERE, sus argumentos, GROUP BY, HAVING y ORDER BY
        String[] cols = new String[]{ CITY_COLUMN };

        //Todo 17. Un cursor es un objeto que se mueve por las filas que devuelve una consulta.
        //Todo -> Empieza antes de la primera: moveToFirst la alcanza, o devuelve false si no hay filas
        Cursor cursor = db.query(DB_TABLE_NAME,cols,null,null,null,null,null);
        if(cursor.moveToFirst()) {
            //Todo 18. Se lee la columna por su posición dentro de cols, empezando en 0
            result = cursor.getString(0);
        }

        //Todo 19. Al terminar se cierran el cursor y la base de datos, en ese orden
        cursor.close();
        db.close();

        return result;
    }


    //Todo 20. Método para recuperar todas las filas. No se usa en la pantalla: es para practicar
    public ArrayList<String> getAllCities(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> resultCities = new ArrayList<>();

        String[] cols = new String[]{ CITY_COLUMN };

        //Para filtrar, cada ? se sustituye por los valores del array, en orden de aparición:
        //String selection = CITY_COLUMN + "=? AND " + POBLATION_COLUMN + ">?";
        //String[] args = new String[]{"Jerez", "100"};

        Cursor cursor = db.query(DB_TABLE_NAME,cols,null,null,null,null,null);

        //Todo 21. Se va al primer elemento y, mientras haya más, se avanza con moveToNext
        if(cursor.moveToFirst()){
            do{
                resultCities.add(cursor.getString(0));
            }while(cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return resultCities;
    }
}
