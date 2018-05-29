package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    private static final String IMAGE_ID_LIST = "image_id_list";
    private static final String LOG_TAG = BodyPartFragment.class.getName();
    private static final String LIST_INDEX = "list_index";

    public BodyPartFragment() { }

    private List<Integer> mImageIds;
    private int mListIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part,container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.img_view_body_part);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListIndex < mImageIds.size() - 1){
                    mListIndex++;
                } else {
                    mListIndex = 0;
                }
                imageView.setImageResource(mImageIds.get(mListIndex));
            }
        });

        if(mImageIds != null){
            imageView.setImageResource(mImageIds.get(mListIndex));
        } else {
            Log.wtf(LOG_TAG, "This fragment has a null list of image id's");
        }

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        outState.putInt(LIST_INDEX, mListIndex);
    }

    public void setImageIds(List<Integer> imageIds){
        mImageIds = imageIds;
    }

    public void setLastIndex(int index){
        mListIndex = index;
    }
}
