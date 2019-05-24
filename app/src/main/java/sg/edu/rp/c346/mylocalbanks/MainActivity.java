package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewDBS;
    TextView textViewOCBC;
    TextView textViewUOB;
    int mode =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDBS = findViewById(R.id.textViewDBS);
        textViewOCBC = findViewById(R.id.textViewOCBC);
        textViewUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(textViewDBS);
        registerForContextMenu(textViewOCBC);
        registerForContextMenu(textViewUOB);



    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if(v.getId()==R.id.textViewDBS){
            mode = 1;
        }else if(v.getId()==R.id.textViewOCBC){
            mode = 2;
        }else if(v.getId()==R.id.textViewUOB){
            mode = 3;
        }
        Log.d("Test",""+v.getId()+" "+ mode);
    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.ChineseSelection) {
            textViewDBS.setText("星展银行");
            textViewOCBC.setText("华侨银行");
            textViewUOB.setText("大华银行");
            return true;
        } else if (id == R.id.EnglishSelection) {
            textViewDBS.setText("DBS");
            textViewOCBC.setText("OCBC");
            textViewUOB.setText("UOB");


        }return super.onOptionsItemSelected(item);

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId()==0){
            if(mode==1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            }else if(mode==2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            }else if(mode==3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            }

        }
        else if(item.getItemId()==1){
            if(mode==1){
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +1800+1111111));
                startActivity(intent);
            }else if(mode==2){
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +1800+3633333));
                    startActivity(intent);
            }else if(mode==3){
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +1800+2222121));
                    startActivity(intent);
                }
            }return super.onContextItemSelected(item);
        }

    }






