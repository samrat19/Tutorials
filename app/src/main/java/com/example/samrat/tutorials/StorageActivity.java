package com.example.samrat.tutorials;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;
import java.util.List;

public class StorageActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<StoreList>>{

    private static  final String movieUrl="https://www.jasonbase.com/things/y01E.json";
    private static final int EARTHQUAKE_LOADER_ID = 1;
    private StorageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        ListView listView = findViewById(R.id.storagelist);

        mAdapter = new StorageAdapter(this, new ArrayList<StoreList>());
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          //      Intent intent = new Intent(getApplicationContext(),FirebaseVideo.class);
          //      StoreList movieList = mAdapter.getItem(position);
          //      String url = movieList.getTopiclink();
           //     String type = movieList.getType1();
            //    intent.putExtra("URL",url);
             //   intent.putExtra("TYPE",type);
              //  startActivity(intent);

                StoreList storeList = mAdapter.getItem(position);
                String url = storeList.getTopiclink();
                String type = storeList.getType1();
                if(type.length()==3){
                    Intent intent = new Intent(getApplicationContext(), PDFActivity.class);
                    intent.putExtra("LINK",url);
                    startActivity(intent);
                }else if(type.length()==5){
                    Intent intent = new Intent(getApplicationContext(), FirebaseVideo.class);
                    intent.putExtra("URL",url);
                    startActivity(intent);
                }
            }
        });

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);
        } else {
            // View loadingIndicator = findViewById(R.id.loading_indicator);
            //  loadingIndicator.setVisibility(View.GONE);
            // mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
    }


    @Override
    public Loader<List<StoreList>> onCreateLoader(int i, Bundle bundle) {
        return new StoreLoader(this, movieUrl);
    }

    @Override
    public void onLoadFinished(Loader<List<StoreList>> loader, List<StoreList> movieLists) {
        // View loadingIndicator = findViewById(R.id.loading_indicator);
        //  loadingIndicator.setVisibility(View.GONE);
        //  mEmptyStateTextView.setText(R.string.no_earthquakes);

        mAdapter.clear();
        if (movieLists != null && !movieLists.isEmpty()) {
            mAdapter.addAll(movieLists);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<StoreList>> loader) {
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }
}
