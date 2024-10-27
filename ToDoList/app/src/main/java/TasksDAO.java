import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.google.firestore.v1.Cursor;

public class TasksDAO {
    private SQLiteDatabase database;
    private TasksSQLiteHelper dbHelper;
    private String [] allColumns = {
            TasksSQLiteHelper.COLUMN_ID,
            TasksSQLiteHelper.COLUMN_DATE,
            TasksSQLiteHelper.COLUMN_TASK,
            TasksSQLiteHelper.COLUMN_COMPLETED};
    public TasksDAO(Context context){
        dbHelper = new TasksSQLiteHelper(context);
    }
    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }
    public Task createTask(Task t){
        ContentValues values = new ContentValues();

        int done = 0;
        if(t.getCompleted()){
            done = 1;
        }
        values.put(TasksSQLiteHelper.COLUMN_DATE, t.getdate());
        values.put(TasksSQLiteHelper.COLUMN_TASK, t.getTaskDetails());
        values.put(TasksSQLiteHelper.COLUMN_COMPLETED, done);

        long insertId = database.insert(TasksSQLiteHelper.TABLE_TASKS, null, values);
        Cursor cursor = database.query(TasksSQLiteHelper.TABLE_TASKS, allColumns,
                TasksSQLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
    }
}
