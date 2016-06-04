package joonsri.softpeerawit.futsalrefereeguide;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SOFT on 06/04/2016.
 */
public class RulesTABLE {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSQLite, readSQLite;

    public RulesTABLE(Context context) {

        myOpenHelper = new MyOpenHelper(context);
        writeSQLite = myOpenHelper.getWritableDatabase();
        readSQLite = myOpenHelper.getReadableDatabase();

    }//constructor

}//Main class
