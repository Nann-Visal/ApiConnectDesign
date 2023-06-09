package com.example.apiconnectdesign.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.apiconnectdesign.databinding.FragmentHomeBinding;
import com.example.apiconnectdesign.databinding.FragmentSearchBinding;

public class SearchFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Create obj binding for call layout-view
        com.example.apiconnectdesign.databinding.FragmentSearchBinding binding = FragmentSearchBinding.inflate(inflater, container, false);

        //Call layout-view by biding obj
        return binding.getRoot();
    }
}
