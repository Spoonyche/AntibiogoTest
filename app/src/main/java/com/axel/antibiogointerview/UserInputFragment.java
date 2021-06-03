package com.axel.antibiogointerview;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.axel.antibiogointerview.databinding.InputFragmentBinding;
import com.axel.antibiogointerview.viewmodel.MyViewModel;

public class UserInputFragment extends Fragment {

    private InputFragmentBinding binding;
    private MyViewModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = InputFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(UserInputFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        binding.uppercaseTxtEdit.setText(viewModel.getPhrase());

        binding.uppercaseTxtEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                viewModel.setPhrase(s.toString());
                if (viewModel.isPhraseValid()){
                    binding.editTextNumber.setVisibility(View.VISIBLE);
                    binding.buttonFirst.setVisibility(View.VISIBLE);
                }else{
                    binding.uppercaseTxtLayout.setError("Make sure the firs letter is Uppercase");
                    binding.editTextNumber.setVisibility(View.INVISIBLE);
                    binding.buttonFirst.setVisibility(View.INVISIBLE);
                }
            }
        });
        binding.editTextNumber.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>0) {
                    try {
                        viewModel.setAngle(Integer.parseInt(s.toString()));
                    } catch (NumberFormatException ex) {
                        // please enter a number
                    }
                }
            }
        });

        binding.editTextNumber.setText(""+viewModel.getAngle());


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}