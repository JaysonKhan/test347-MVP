package uz.gita.test347.ui.result;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import uz.gita.test347.R;
import uz.gita.test347.model.TestData;
import uz.gita.test347.repository.AppRepository;
import uz.gita.test347.ui.game.GameContract;
import uz.gita.test347.ui.game.GamePresenter;

public class ResultActivity  extends AppCompatActivity implements ResultContract.View{
    TextView countQuestion, correct, skipped;
    ResultPresenter presenter;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        presenter  = new ResultPresenter(this);

        loadWidgets();
        display();

    }


    public void loadWidgets() {
        container = findViewById(R.id.win_wrongContainer);
        countQuestion = findViewById(R.id.winCountQuestions);
        correct = findViewById(R.id.winCountCorrect);
        skipped = findViewById(R.id.winCountSkipped);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void display() {
        countQuestion.setText("Savollar soni:  " + presenter.getMaxCount());
        correct.setText("To'g'rilari soni:  " + presenter.getCorrect());
        skipped.setText("O'tkazib yuborilganlar soni:  " + presenter.getSkipped());
        List<TestData> wrong = presenter.getWrongs();

        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < wrong.size(); i++) {
            View view  = inflater.inflate(R.layout.item_wrong, container, false);
            view.<TextView>findViewById(R.id.item_question).setText(wrong.get(i).getQuestion());
            view.<TextView>findViewById(R.id.item_correct).setText(wrong.get(i).getAnswer());

            container.addView(view);

        }

    }

    @Override
    public void controlOldActivity() {
        presenter.clearOldList();
    }

    @Override
    protected void onStart() { 
        super.onStart();
    }



    }
