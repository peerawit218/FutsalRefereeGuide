package joonsri.softpeerawit.futsalrefereeguide;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SOFT on 06/04/2016.
 */
public class MyOpenHelper extends SQLiteOpenHelper{



    private static final String DATABASE_NAME = "Rules.db";
    private static final int DATABASE_VERSION = 1;
    private static final String RULES_TABLE = "create table rulesTABLE (" +
            "id_rules primary key," +
            "rules text, " +
            "title text, " +
            "content text, " +
            "image text);";
    private static final String VIDEO_TABLE = "create table videoTABLE (" +
            "id_video primary key, " +
            "name text, " +
            "video text);";

    public MyOpenHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }//constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(RULES_TABLE);
        db.execSQL(VIDEO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}//MainClass
