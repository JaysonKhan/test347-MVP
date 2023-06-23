package uz.gita.test347.ui.result;

import java.util.List;

import uz.gita.test347.model.TestData;

public interface ResultContract {
    interface Model{
        void clear();
        int getCurrect();
        int getCorrect();
        int getSkipped();
        int getMaxCount();

        List<TestData> getWrongQuestions();
    }
    interface Presenter{
        int getCurrect();
        int getCorrect();
        int getSkipped();
        int getMaxCount();
        void clearOldList();


        List<TestData> getWrongs();
    }
    interface View{
        void display();
        void controlOldActivity();


    }
}
