package uz.gita.test347.ui.home;

import uz.gita.test347.ui.game.GameContract;

public class HomePresenter implements HomeContract.Presenter{
    HomeContract.Model model;
    HomeContract.View view;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
        model = new HomeModel();
    }

    @Override
    public void clickNewGame() {
        model.clearOld();
    }

    @Override
    public void clickContinue() {


    }

    @Override
    public void clickInfo() {

    }

    @Override
    public boolean checkOld() {
        return model.getStatus();
    }
}
