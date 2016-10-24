package com.example.android.miwok.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.miwok.R;
import com.example.android.miwok.entities.Word;

import java.util.List;

/**
 * Created by lntormin on 16/10/16.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, List<Word> words) {
        super(context,0,words);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word currentWord = getItem(position);

        ImageView miwokImageView = (ImageView) listItemView.findViewById(R.id.word_photo);
        if (currentWord.hasImage())
            miwokImageView.setImageResource(currentWord.getImageResourceId());
        else
            miwokImageView.setVisibility(View.GONE);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.word_miwok);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.word_english);
        defaultTextView.setText(currentWord.getDefaultTranslation());


        return listItemView;
    }
}
