package uz.gita.test347;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class InfoActivity extends AppCompatActivity {
    AppCompatButton home;
    View telegram,instagram, pinterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        home = findViewById(R.id.buttonHomeInAbout);

        telegram = findViewById(R.id.telegram);
        instagram = findViewById(R.id.instagram);
        pinterest = findViewById(R.id.pinterest);


        home.setOnClickListener(view -> finish());

        telegram.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://t.me/J_khan347");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        instagram.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://www.instagram.com/j_khan347/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        pinterest.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://www.pinterest.com/betta347/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }
}