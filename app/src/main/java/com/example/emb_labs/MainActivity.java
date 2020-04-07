package com.example.emb_labs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        EditText el = findViewById(R.id.number);
        TextView a = findViewById(R.id.aRes);
        TextView b = findViewById(R.id.bRes);

        int[] res = new int[2];
        int number = 0;
        try {
            number = Integer.parseInt(el.getText().toString());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        if (number == 0) {
            Toast.makeText(
                    MainActivity.this, "Incorrect input!", Toast.LENGTH_LONG
            ).show();
        } else if (number % 2 == 0) {
            res[0] = 2;
            res[1] = number/2;
            Toast.makeText(
                    MainActivity.this, "Even number!", Toast.LENGTH_LONG
            ).show();
        } else if (Math.sqrt(number) % 1 == 0) {
            res[0] = res[1] = (int)Math.sqrt(number);
            Toast.makeText(
                    MainActivity.this, "Number root!", Toast.LENGTH_LONG
            ).show();
        } else {
            res = factFerma(number);
        }
        a.setText(Integer.toString(res[0]));
        b.setText(Integer.toString(res[1]));
    }

    public int[] factFerma(int num) {
        long start = System.currentTimeMillis();
        int[] resArr = new int[2];
        int x = (int)Math.sqrt(num) + 1;
        while (Math.sqrt(Math.pow(x, 2) - num) % 1 != 0) {
            x ++;
            long finish = System.currentTimeMillis();
            if (3000 <= finish - start) {
                Toast.makeText(
                        MainActivity.this, "Max time reached!", Toast.LENGTH_LONG
                ).show();
                break;
            }
        }
        int y = (int)Math.sqrt(Math.pow(x, 2) - num);
        resArr[0] = x - y;
        resArr[1] = x + y;
        if (resArr[0] == 1) {
            Toast.makeText(
                    MainActivity.this, "Prime number!", Toast.LENGTH_LONG
            ).show();
        }
        return resArr;
    }
}
