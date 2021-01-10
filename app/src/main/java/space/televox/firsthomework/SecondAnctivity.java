package space.televox.firsthomework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondAnctivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button buttonCalendarNext = findViewById(R.id.btn_calendar_next);



        // кнопка перехода на третий уровень - начало
        buttonCalendarNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondAnctivity.this, CalendarActivity.class);
                startActivity(intent); finish();
            }
        });
        // кнопка перехода на третий уровень - конец

    }
}
