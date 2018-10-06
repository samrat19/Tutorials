package com.example.samrat.tutorials;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class StoreLoader extends AsyncTaskLoader<List<StoreList>> {

    private String storageUrl;

    public StoreLoader(Context context, String url){

        super(context);
        storageUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<StoreList> loadInBackground() {
        if(storageUrl == null){
            return null;
        }

        List<StoreList> storeLists = QueryUtils.fetchStoragedata(storageUrl);

        return storeLists;
    }
}
