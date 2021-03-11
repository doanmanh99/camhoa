package com.example.camhoa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.camhoa.widget.FragmentFavoriteTheme;

import java.util.ArrayList;
import java.util.List;

public class FragmentFavorite extends Fragment {
    RadioGroup radioGroup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new FragmentFavoriteFavorite()).commit();
        radioGroup = view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbFavorite:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentFavoriteFavorite()).commit();
                        break;
                    case R.id.rbTheme:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentFavoriteTheme()).commit();
                        break;
                    default:
                        break;
                }
            }
        });
        return view;
    }

}
