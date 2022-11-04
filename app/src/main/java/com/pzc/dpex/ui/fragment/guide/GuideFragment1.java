package com.pzc.dpex.ui.fragment.guide;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pzc.dpex.R;

/**
 * @author 69182
 */
public class GuideFragment1 extends Fragment {

    View view;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_guide1,container,false);
        return view;
    }
}
