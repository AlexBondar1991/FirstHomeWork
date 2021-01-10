package space.televox.firsthomework;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Switch swtch = findViewById(R.id.switch_unswer_luk);


        Button button = findViewById(R.id.btn_first); // кнопка даилога
        Button buttonTwo = findViewById(R.id.btn_next_lvl);



        CheckBox checkBox_one = findViewById(R.id.ch_box_first);
        CheckBox checkBox_two = findViewById(R.id.ch_box_second);


        final EditText editText = findViewById(R.id.first_edit);
        final TextView textView = findViewById(R.id.view_first);


        textView.setTextColor(Color.parseColor("#FFFFFFFF"));
        textView.setTypeface(null, Typeface.BOLD);

//        LinearLayout linearLayout = findViewById(R.id.lnr_layout);
//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                swtch.setChecked(true);
//            }
//        });


        // команда для checkBox_one - начало
        checkBox_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox_one.isChecked()) {
                    Toast.makeText(MainActivity.this, "И это правильно", Toast.LENGTH_LONG).show();
                }
            }
        });
        // команда для checkBox_one - конец


        // команда для checkBox_two - начало
        checkBox_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox_two.isChecked()) {
                    Toast.makeText(MainActivity.this, "Необходимо посмотреть звездные войны", Toast.LENGTH_LONG).show();
                }
            }
        });
        // команда для checkBox_two - конец


        // команда для кнопки Нажать - начало
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText != null) {
                    textView.setText("Нет, я твой отец, Люк.");
                }
            }
        });
        // команда для кнопки Нажать - начало


        // кнопка перехода на второй уровень - начало
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondAnctivity.class);
                startActivity(intent); finish();
            }
        });
        // кнопка перехода на второй уровень - конец

    }

}
