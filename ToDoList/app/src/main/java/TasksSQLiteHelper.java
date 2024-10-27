import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TasksSQLiteHelper {
    public static final String TABLE_TASKS = "tasks";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TASK = "task";
    public static final String COLUMN_COMPLETED = "completed";

    public static final String DATABASE_NAME = "task.db";
    public static final String DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_TASKS + " (" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_DATE + " text not null, "
            + COLUMN_TASK + " text not null, "
            + COLUMN_COMPLETED + " integer not null);";

    public TasksSQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w(TasksSQLiteHelper.class.getName()),
            "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_TASKS);
        onCreate(db);
    }
}
