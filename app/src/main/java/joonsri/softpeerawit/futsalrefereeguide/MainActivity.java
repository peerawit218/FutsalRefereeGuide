package joonsri.softpeerawit.futsalrefereeguide;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private rulesTABLE rulesTABLE;
    private videoTABLE videoTABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rulesTABLE = new rulesTABLE(this);
        videoTABLE = new videoTABLE(this);


       deleteAllSQLite();

        MySynJSON mySynJSON = new MySynJSON();
        mySynJSON.execute();

        //synJSonSQLite
        synJSonToSQLite();

    }//onCreate



    @Override
    protected void onPostResume() {
        super.onPostResume();
        deleteAllSQLite();
       MySynJSON mySynJSON = new MySynJSON();
        mySynJSON.execute();
    }

    private void synJSonToSQLite() {
        //setUp Policy
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(threadPolicy);
        }//if


    }//synJsonToSQLite

    public class MySynJSON extends AsyncTask<Void, Void, String> {


        @Override
        protected String doInBackground(Void... params) {
            try {

                String strURL = "http://cbwschool.net/soft/videotable_data.php";
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(strURL).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();


            } catch (Exception e) {
                Log.d("soft", "doInBack ==> " + e.toString());
                return null;
            }

        }//doInBack


       @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("soft", "strJSON ==> " + s);
            try {

                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String strName = jsonObject.getString(videoTABLE.column_name);
                    String strVideo = jsonObject.getString(videoTABLE.column_video);
                    videoTABLE.addNewVideo(strName, strVideo);

                }//for
                Toast.makeText(MainActivity.this, "Synchronize mySQL to SQLite Finish", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Log.d("soft", "onPost ==> " + e.toString());
                e.printStackTrace();
            }

        }//onPostExecute
    }//MySynJSON*/

    private void deleteAllSQLite() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name, MODE_PRIVATE, null);
        sqLiteDatabase.delete(videoTABLE.video_table, null, null);

        }


    public void clickStartMain(View view) {
        startActivity(new Intent(MainActivity.this, First.class));
    }//clickStartMain


}//MainClass


