package yazdaniscodelab.classfourlistview;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst=(ListView)findViewById(R.id.list_xml);

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.item));

        lst.setAdapter(adapter);




        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {

                    case 0:
                        startActivity(new Intent(MainActivity.this,SecondActivity.class));
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"Case Two here",Toast.LENGTH_SHORT).show();
                        break;
                }

                //Toast.makeText(getApplicationContext(),"Clicked on "+i,Toast.LENGTH_LONG).show();
            }
        });




        lst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){

                    case 0:

                        final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);

                        builder.setTitle("Alert Here!");
                        builder.setMessage("Are you sure?");

                        builder.setCancelable(false);

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Toast.makeText(getApplicationContext(),"You Clicked Negative button",Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                startActivity(new Intent(MainActivity.this,SecondActivity.class));

                            }
                        });

                        AlertDialog alertDialog=builder.create();

                        alertDialog.show();



                }

                Toast.makeText(getApplicationContext(),"Long Clicked on "+i,Toast.LENGTH_SHORT).show();

                return true;
            }
        });



    }


}
