package joonsri.softpeerawit.futsalrefereeguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;

/**
 * Created by SOFT on 06/05/2016.
 */
public class videoTABLE {

    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public static final String video_table = "videoTABLE";
    public static final String column_id = "id_video";
    public static final String column_name = "name";
    public static final String column_video = "video";


    public videoTABLE(Context context) {
        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();
    }//Constructor

    public long addNewVideo(String strName,
                            String strVideo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_name, strName);
        contentValues.put(column_video, strVideo);
        return sqLiteDatabase.insert(video_table, null, contentValues);
    }


}//Main Class
