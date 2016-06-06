package joonsri.softpeerawit.futsalrefereeguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by SOFT on 06/05/2016.
 */
public class rulesTABLE {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public static final String rules_table = "rulesTABLE";
    public static final String column_id = "id_rules";
    public static final String column_rules = "rules";
    public static final String column_title = "title";
    public static final String column_content = "content";
    public static final String column_image = "image";

    public rulesTABLE(Context context) {
        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();
    }//Constructor

    public long addNewRules(String strRules,
                            String strTitle,
                            String strContent,
                            String strImage) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_rules, strRules);
        contentValues.put(column_title, strTitle);
        contentValues.put(column_content, strContent);
        contentValues.put(column_image, strImage);
        return sqLiteDatabase.insert(rules_table, null, contentValues);
    }


}//main Class
