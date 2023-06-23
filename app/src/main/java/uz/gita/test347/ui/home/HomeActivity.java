package uz.gita.test347.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import uz.gita.test347.InfoActivity;
import uz.gita.test347.R;
import uz.gita.test347.repository.SavedResources;
import uz.gita.test347.ui.game.GameActivity;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {
    private Button start;
    private Button info;
    private Button newGame;
    HomePresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        presenter = new HomePresenter(this);

        loadResource();
        loadWidgets();
    }

    @SuppressLint({"ResourceAsColor", "SuspiciousIndentation"})
    private void loadWidgets() {
        start.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, GameActivity.class)));

        newGame.setOnClickListener(view -> {
            presenter.clickNewGame();
            startActivity(new Intent(HomeActivity.this, GameActivity.class));
        });

        info.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, InfoActivity.class)));

    }


    private void loadResource() {
        start = findViewById(R.id.homeStartButton);
        info = findViewById(R.id.homeInfoBUtton);
        newGame = findViewById(R.id.homeNewGame);


        stateContinueButton(presenter.checkOld());
    }

    @Override
    public void stateContinueButton(Boolean bool) {
        start.setEnabled(bool);
        start.setClickable(bool);
        if (bool){
            start.setBackgroundResource(R.drawable.golden);
        }else{
            start.setBackgroundResource(R.drawable.metall);
        }
    }

    @Override
    protected void onRestart() {
        stateContinueButton(presenter.checkOld());
        super.onRestart();
    }
}
