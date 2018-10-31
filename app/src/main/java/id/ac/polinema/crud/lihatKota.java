package id.ac.polinema.crud;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class lihatKota extends AppCompatActivity {
    Cursor cursor;
    DataHelper dbHelper;
    Button kembali;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_kota);
        dbHelper = new DataHelper(this);
        text1 = findViewById(R.id.textView1);
        text2 = findViewById(R.id.textView2);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM kota WHERE nama = '"+getIntent().getStringExtra("nama")+"'",null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
        }
        kembali = findViewById(R.id.btnKembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}
