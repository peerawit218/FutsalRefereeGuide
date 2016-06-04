package joonsri.softpeerawit.futsalrefereeguide;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by SOFT on 06/04/2016.
 */
public class VideoTABLE {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSQLite, readSQLite;

    public VideoTABLE(Context context) {

        myOpenHelper = new MyOpenHelper(context);
        writeSQLite = myOpenHelper.getWritableDatabase();
        readSQLite = myOpenHelper.getReadableDatabase();

    }//constructor

}//Main Class
