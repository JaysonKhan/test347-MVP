package uz.gita.test347.ui.result;

import java.util.List;

import uz.gita.test347.model.TestData;
import uz.gita.test347.ui.game.GameContract;

public class ResultPresenter implements ResultContract.Presenter{
    ResultContract.View activity;
    ResultContract.Model  model;

    public ResultPresenter(ResultActivity resultActivity) {
        model = new ResultModel();
        this.activity = resultActivity;
    }


    @Override
    public int getCurrect() {
        return model.getCurrect();
    }

    @Override
    public int getCorrect() {
        return model.getCorrect();
    }

    @Override
    public int getSkipped() {
        return model.getSkipped();
    }

    @Override
    public int getMaxCount() {
        return model.getMaxCount();
    }

    @Override
    public void clearOldList() {
        model.clear();
    }

    @Override
    public List<TestData> getWrongs() {
        return model.getWrongQuestions();
    }

}
