package com.example.spacetrader.views.maingame.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spacetrader.R;
import com.example.spacetrader.databinding.FragmentBuyBinding;
import com.example.spacetrader.databinding.FragmentInfoBinding;
import com.example.spacetrader.viewmodels.BuyViewModel;
import com.example.spacetrader.viewmodels.InfoViewModel;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class InfoFragment extends Fragment {

    InfoViewModel viewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        FragmentInfoBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_info, parent, false);

        View view = binding.getRoot();

        viewModel = ViewModelProviders.of(this).get(InfoViewModel.class);

        if (savedInstanceState == null) {
            long playerId = this.getArguments().getLong("playerId");
            viewModel.init(playerId, this);
        }

        binding.setViewmodel(viewModel);

        binding.setLifecycleOwner(this);

        return view;

    }

}
