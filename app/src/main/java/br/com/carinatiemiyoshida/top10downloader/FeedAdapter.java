package br.com.carinatiemiyoshida.top10downloader;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by CarinaTiemiYoshida on 23/06/2017.
 */

public class FeedAdapter extends ArrayAdapter {
    private static final String TAG = "FeedAdapter";
    private final int layoutResourse;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> applications;

    public FeedAdapter(@NonNull Context context, @LayoutRes int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.layoutResourse = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.applications = applications;
    }
}
