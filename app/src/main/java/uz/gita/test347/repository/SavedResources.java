package uz.gita.test347.repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import uz.gita.test347.model.TestData;

public class SavedResources {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static Context context;
    private final String LIST = "LIST";
    private final String WRONG_LIST = "WRONG_LIST";
    private final String CURRECT_POSITION = "CURRECT_POSITION";
    private final String CORRECT_POSITION = "CORRECT_POSITION";
    private final String IS_PLAYING = "IS_PLAYING";
    private final String WRONG = "WRONG";
    private final String SKIPPED = "SKIPPED";
    private final String SIZE = "SIZE";
    public static SavedResources savedResources;

    public static void init(Context x){
        if (savedResources==null){
            context = x;
            savedResources = new SavedResources();
            sharedPreferences = x.getSharedPreferences("SETTINGS", Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
    }
    public static SavedResources getInstance(){
        return savedResources;
    }


    public void setSituation(List<TestData> list,List<TestData> wrongAnswer, int size, int currect, int correct, int skipped) {
        Gson gson = new Gson();
        String json = gson.toJson(list);

        Gson gsonWrong = new Gson();
        String jsonWrong = gson.toJson(wrongAnswer);

        editor.putString(WRONG_LIST, jsonWrong).apply();
        editor.putString(LIST, json).apply();
        editor.putInt(CURRECT_POSITION, (currect-1)).apply();
        editor.putInt(CORRECT_POSITION, correct).apply();
        editor.putInt(SKIPPED, skipped).apply();
        editor.putInt(WRONG, skipped).apply();
        editor.putInt(SIZE, size).apply();
    }
    public List<TestData> getList(){
        List<TestData> oldList;
        Gson gson = new Gson();
        Type type = new TypeToken<List<TestData>>() {}.getType();

        oldList = gson.fromJson(sharedPreferences.getString(LIST, ""), type);
        return oldList;
    }
    public List<TestData> getWrongList(){
        List<TestData> oldWrongList;
        Type type = new TypeToken<List<TestData>>() {}.getType();
        Gson gsonWrong = new Gson();

        oldWrongList = gsonWrong.fromJson(sharedPreferences.getString(WRONG_LIST, ""), type);
        return oldWrongList;
    }

    public boolean hasDataInPref(){
        return !sharedPreferences.getString(LIST, "").isEmpty();
    }


    public int getCorrect(){
        return sharedPreferences.getInt(CORRECT_POSITION, 0);
    }
    public int getCurrect(){
        return sharedPreferences.getInt(CURRECT_POSITION, 0);
    }
    public int getSize(){
        return sharedPreferences.getInt(SIZE, 0);
    }
    public int getSkipped(){
        return sharedPreferences.getInt(SKIPPED, 0);
    }
    public int getWrong(){
        return sharedPreferences.getInt(WRONG, 0);
    }

    public void clear(){
        editor.clear().apply();
    }

    public void setStatus(boolean bool){
        editor.putBoolean(IS_PLAYING, bool).apply();
    }
    public boolean getStatus(){
        return sharedPreferences.getBoolean(IS_PLAYING, false);
    }
}