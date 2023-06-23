package uz.gita.test347.ui.game;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

import uz.gita.test347.App;
import uz.gita.test347.R;
import uz.gita.test347.model.TestData;
import uz.gita.test347.ui.result.ResultActivity;

public class GameActivity extends AppCompatActivity implements GameContract.View {
    private GameContract.Presenter presenter;
    private List<RadioButton> radioButtons;
    private List<LinearLayout> cardViews;
    private List<AppCompatTextView> variants;
    private AppCompatTextView questionText;
    private AppCompatTextView currentPosText;
    private AppCompatButton buttonSkip;
    private AppCompatButton buttonNext;
    private AppCompatImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadViews();
        attachClickListener();
        presenter = new GamePresenter(this);
    }

    private void attachClickListener() {
        buttonNext.setOnClickListener(view -> presenter.clickNextButton());
        buttonSkip.setOnClickListener(view ->{
            clearOldAnswer();
            stateNextButton(false
            );
            presenter.clickSkipButton();
        });
        backButton.setOnClickListener(view -> finish());

        for (int i = 0; i < radioButtons.size(); i++) {
            radioButtons.get(i).setTag(i);
            radioButtons.get(i).setOnClickListener(v -> {
                int pos = (int) v.getTag();
                if (radioButtons.get(pos).isChecked()){
                    clearOldAnswer();
                    radioButtons.get(pos).setChecked(true);
                    presenter.selectUserAnswer(variants.get(pos).getText().toString());
                }
            });

        }
        for (int i = 0; i < cardViews.size(); i++) {
            int temp = i;
            cardViews.get(i).setOnClickListener(view -> {
                if (!radioButtons.get(temp).isChecked()){
                    clearOldAnswer();
                    radioButtons.get(temp).setChecked(true);
                    view.setBackgroundResource(R.drawable.green);
                    presenter.selectUserAnswer(variants.get(temp).getText().toString());
                }
            });

        }
        stateNextButton(false);
    }

    private void loadViews() {
        radioButtons = new ArrayList<>(4);
        radioButtons.add(findViewById(R.id.mainRadio1));
        radioButtons.add(findViewById(R.id.mainRadio2));
        radioButtons.add(findViewById(R.id.mainRadio3));
        radioButtons.add(findViewById(R.id.mainRadio4));

        cardViews = new ArrayList<>(4);
        cardViews.add(findViewById(R.id.card1));
        cardViews.add(findViewById(R.id.card2));
        cardViews.add(findViewById(R.id.card3));
        cardViews.add(findViewById(R.id.card4));

        variants = new ArrayList<>(4);
        variants.add(findViewById(R.id.mainRadioText1));
        variants.add(findViewById(R.id.mainRadioText2));
        variants.add(findViewById(R.id.mainRadioText3));
        variants.add(findViewById(R.id.mainRadioText4));

        questionText = findViewById(R.id.mainQuestion);
        currentPosText = findViewById(R.id.mainPointer);
        buttonSkip = findViewById(R.id.mainSkipButton);
        buttonNext = findViewById(R.id.mainNextButton);
        backButton = findViewById(R.id.mainBackButton);


    }



    @SuppressLint("ResourceAsColor")
    @Override
    public void clearOldAnswer() {
        for (int i = 0; i < radioButtons.size(); i++) {
            if (radioButtons.get(i).isChecked()) radioButtons.get(i).setChecked(false);
            cardViews.get(i).setBackgroundResource(R.drawable.variantbutton);
        }

    }

    @Override
    public void describeTest(TestData testData, int curPos, int totCount) {
        currentPosText.setText(curPos + "/"+ totCount);
        questionText.setText(testData.getQuestion());

        variants.get(0).setText(testData.getVariant1());
        variants.get(1).setText(testData.getVariant2());
        variants.get(2).setText(testData.getVariant3());
        variants.get(3).setText(testData.getVariant4());

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void stateNextButton(Boolean bool) {
        if (!bool){
            buttonNext.setBackgroundResource(R.drawable.metall);
            buttonNext.setHintTextColor(R.color.golden);
        }else{
            buttonNext.setBackgroundResource(R.drawable.golden);
            buttonNext.setHintTextColor(R.color.black);
        }
        buttonNext.setEnabled(bool);
    }

    @Override
    public void openResultActivity() {
        presenter.saveData();
        startActivity(new Intent(GameActivity.this, ResultActivity.class));
        Toast.makeText(this, "FINISH!!!! ", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        finish();
        check();
        super.onRestart();
    }

    @Override
    protected void onPause() {
        check();
        super.onPause();
    }
    void check(){
        if (presenter.currectPosition()!=1 && !presenter.noMoreQuestion()){
            presenter.saveData();
            presenter.isPlaying(true);
        }else{
            presenter.isPlaying(false);
        }
    }
}
