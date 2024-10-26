import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class DataManager (context: Context) {
    private val db: SQLiteDatabase

    init{
        val helper = CustomSQLiteOpenHelper(context)
        db = helper.writableDatabase
    }

    companion object{
        const val TABLE_ROW_ID ="_id"
        const val TABLE_ROW_NAME= "name"
        const val TABLE_ROW_AGE = "age"

        private const val DB_NAME= "address_book_db"
        private const val DB_VERSION= 1
        private const val TABLE_N_AND_A = "names_and_addresses"
    }

    fun insert(name: String, age: String){
        val query = "INSERT INTO " + TABLE_N_AND_A + " (" +
                TABLE_ROW_NAME + ", " + TABLE_ROW_AGE +
                ") "+ "VALUES (" + "'" + name + "'" + ", " + "'" +
                age + "'" + ");"

        Log.i("insert() = ", query)
        db.execSQL(query)
    }

    fun delete(name: String){
        val query = "DELETE FROM " + TABLE_N_AND_A + " WHERE " +
                TABLE_ROW_NAME + " = '" + name + "';"

        Log.i("delete() = ", query)
        db.execSQL(query)
    }

    fun selectAll(): Cursor{
        return db.rawQuery("SELECT *" + " from " + TABLE_N_AND_A, null)
    }

    fun searchName(name: String): Cursor{
        val query = "SELECT " + TABLE_ROW_ID + ", " + TABLE_ROW_NAME +
                ", " + TABLE_ROW_AGE + " FROM " + TABLE_N_AND_A + " WHERE " +
                TABLE_ROW_NAME + " = '" + name + "';"
        Log.i("searchName() = ", query)
        return db.rawQuery(query, null)
    }
    private inner class CustomSQLiteOpenHelper(
        context: Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION){
            override fun onCreate(db: SQLiteDatabase) {
                val newTableQueryString = ("create table " + TABLE_N_AND_A +
                        " (" + TABLE_ROW_ID + " integer primary key autoincrement not null," +
                        TABLE_ROW_NAME + " text not null," + TABLE_ROW_AGE + " text not null);")
                db.execSQL(newTableQueryString)
            }

            override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int){

            }
        }
}