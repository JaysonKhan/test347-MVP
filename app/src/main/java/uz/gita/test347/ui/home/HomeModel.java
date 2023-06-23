package uz.gita.test347.ui.home;

import uz.gita.test347.repository.AppRepository;
import uz.gita.test347.repository.SavedResources;

public class HomeModel implements HomeContract.Model{
    SavedResources savedResources;

    public HomeModel() {
        savedResources = SavedResources.getInstance();
    }

    @Override
    public void clearOld() {
        savedResources.clear();
    }

    @Override
    public boolean getStatus() {
        return savedResources.getStatus();
    }
}
