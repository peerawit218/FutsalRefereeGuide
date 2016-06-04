package joonsri.softpeerawit.futsalrefereeguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }//onCreate

    public void clickProvider(View view) {
        startActivity(new Intent(First.this, Provider.class));
    }//clickProvider

    public void clickRefer(View view) {
        startActivity(new Intent(First.this, Refer.class));
    }//clickRefer

}//MainClass
