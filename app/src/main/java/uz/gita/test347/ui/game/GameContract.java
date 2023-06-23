package uz.gita.test347.ui.game;

import uz.gita.test347.model.TestData;

public interface GameContract {
    interface Model{
        void check(String userAnswer);

        void incSkipped();

        TestData getNextTest();
        boolean hasQuestion();
        int getCurrectPos();
        int getCorrectPos();
        void savaData();
        void savaStatus(boolean bool);
        void clear();
    }
    interface View{
        void clearOldAnswer();
        void describeTest(TestData testData, int curPor, int totCount);
        void stateNextButton(Boolean bool);
        void openResultActivity();
    }
    interface Presenter{
        void clickSkipButton();
        void clickNextButton();
        void selectUserAnswer(String userAnswer);
        void saveData();
        void isPlaying(boolean bool);
        int currectPosition();
//        void clearResources();

        boolean noMoreQuestion();
    }
}
