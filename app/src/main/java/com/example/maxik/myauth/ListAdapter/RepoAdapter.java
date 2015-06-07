package com.example.maxik.myauth.ListAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maxik.myauth.Entity.Repo;
import com.example.maxik.myauth.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by maxik on 07.06.15.
 */
public class RepoAdapter extends BaseAdapter {

    private Context context;
    private List<Repo> repoList;
    private LayoutInflater inflater;

    public RepoAdapter(Context context, List<Repo> repoList) {
        this.context = context;
        this.repoList = repoList;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return repoList.size();
    }

    @Override
    public Object getItem(int position) {
        return repoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.repo_item, parent, false);
        }

        Repo repo = (Repo) getItem(position);

        ((TextView) convertView.findViewById(R.id.textViewRepo)).setText(repo.getName());
//        ((ImageView) convertView.findViewById(R.id.imageViewAvatar)).setImageBitmap(bitmap);

        return convertView;
    }
}
