package uz.gita.test347.ui.home;

public interface HomeContract {
    interface Model{
        void clearOld();
        boolean getStatus();

    }
    interface View{
        void stateContinueButton(Boolean bool);

    }
    interface Presenter{
        void clickNewGame();
        void clickContinue();
        void clickInfo();
        boolean checkOld();
    }
}
