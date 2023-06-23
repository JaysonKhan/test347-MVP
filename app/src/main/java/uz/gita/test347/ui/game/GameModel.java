package uz.gita.test347.ui.game;

import java.util.ArrayList;
import java.util.List;

import uz.gita.test347.model.TestData;
import uz.gita.test347.repository.AppRepository;
import uz.gita.test347.repository.SavedResources;

public class GameModel implements GameContract.Model {
    private SavedResources savedResources;
    private int MAX_COUNT = 10;
    private AppRepository repository;
    private List<TestData> test;
    private List<TestData> wrongAnsweredTest;
    private int currentPos;
    private int wrongCount;
    private int correctCount;
    private int skippedCount;
    GameModel(){
        repository = AppRepository.getInstance();
        savedResources = SavedResources.getInstance();

        test = new ArrayList<>();
        wrongAnsweredTest =new ArrayList<>();

        if (savedResources.hasDataInPref()){

            test = savedResources.getList();
            wrongAnsweredTest = savedResources.getWrongList();

            currentPos = savedResources.getCurrect();
            correctCount = savedResources.getCorrect();
            wrongCount = savedResources.getWrong();
            skippedCount = savedResources.getSkipped();
        }else {
            getNeedData();

            skippedCount = correctCount = wrongCount = currentPos = 0;
        }

    }
    private void getNeedData() {
        repository.shuffle();
        test.addAll(repository.getNeedDataByCount(MAX_COUNT));
    }

    @Override
    public void check(String userAnswer) {
        if (test.get(currentPos-1).getAnswer().equals(userAnswer)) {
            ++correctCount;
        } else{
            wrongAnsweredTest.add(test.get(currentPos-1));
            ++wrongCount;
        }
    }
    @Override
    public void incSkipped(){
        ++skippedCount;
    }

    @Override
    public TestData getNextTest() {
        return test.get(currentPos++);
    }

    @Override
    public boolean hasQuestion() {
        return currentPos<MAX_COUNT;
    }

    @Override
    public int getCurrectPos() {
        return currentPos;
    }

    @Override
    public int getCorrectPos() {
        return correctCount;
    }

    @Override
    public void savaData() {
        savedResources.setSituation(test, wrongAnsweredTest, MAX_COUNT, currentPos, correctCount, skippedCount);
    }

    @Override
    public void savaStatus(boolean bool) {
        savedResources.setStatus(bool);
    }

    @Override
    public void clear() {
        savedResources.clear();
    }


}
