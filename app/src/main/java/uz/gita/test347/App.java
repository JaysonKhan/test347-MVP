package uz.gita.test347;

import android.app.Application;

import uz.gita.test347.repository.AppRepository;
import uz.gita.test347.repository.SavedResources;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        SavedResources.init(this);
        AppRepository.init(this);

    }
}
