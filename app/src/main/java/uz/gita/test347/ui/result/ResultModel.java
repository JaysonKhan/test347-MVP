package uz.gita.test347.ui.result;

import java.util.List;

import uz.gita.test347.model.TestData;
import uz.gita.test347.repository.AppRepository;
import uz.gita.test347.repository.SavedResources;

public class ResultModel implements ResultContract.Model{
    private AppRepository appRepository;
    SavedResources savedResources;

    public ResultModel() {
        appRepository = AppRepository.getInstance();
        savedResources = SavedResources.getInstance();
    }

    @Override
    public void clear() {
        savedResources.clear();
    }

    @Override
    public int getCurrect() {
        return savedResources.getCurrect();
    }

    @Override
    public int getCorrect() {
        return savedResources.getCorrect();
    }

    @Override
    public int getSkipped() {
        return savedResources.getSkipped();
    }

    @Override
    public int getMaxCount() {
        return savedResources.getSize();
    }

    @Override
    public List<TestData> getWrongQuestions() {
        return savedResources.getWrongList();
    }
}
