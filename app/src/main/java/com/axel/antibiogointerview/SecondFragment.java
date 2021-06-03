package com.axel.antibiogointerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.axel.antibiogointerview.databinding.FragmentSecondBinding;
import com.axel.antibiogointerview.viewmodel.MyViewModel;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private MyViewModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        binding.imageView3.setRotationX(viewModel.getAngle());
        binding.imageView3.setRotation(viewModel.getAngle());
        binding.imageView3.setRotationY(viewModel.getAngle());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}