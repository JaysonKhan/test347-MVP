package uz.gita.test347.ui.game;

public class GamePresenter implements GameContract.Presenter {
    private GameContract.Model model;
    private GameContract.View view;
    private String userAnswer;
    GamePresenter(GameContract.View view) {
        this.model = new GameModel();
        this.view  = view;
        loadNextTest();
    }

    private void loadNextTest() {
        if (model.hasQuestion()) {
            view.clearOldAnswer();
            view.describeTest(model.getNextTest(), model.getCurrectPos(), 10);
        }else{
            view.openResultActivity();
        }
    }
    @Override
    public void clickSkipButton() {
        model.incSkipped();
        loadNextTest();
    }

    @Override
    public void clickNextButton() {
        model.check(userAnswer);
        loadNextTest();
        view.stateNextButton(false);
    }

    @Override
    public void selectUserAnswer(String userAnswer) {
         this.userAnswer = userAnswer;
         view.stateNextButton(true);
    }

    @Override
    public void saveData() {
        model.savaData();
    }

    @Override
    public int currectPosition() {
        return model.getCurrectPos();
    }



    @Override
    public void isPlaying(boolean bool){
        model.savaStatus(bool);
        view.stateNextButton(bool);
}
@Override
      public boolean noMoreQuestion(){
        return !model.hasQuestion();
      }

}
