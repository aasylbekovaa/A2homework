package com.example.a2homework1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.a2homework1.R;
import com.example.a2homework1.databinding.FragmentCreateBinding;

public class CreateTaskFragment extends Fragment {
    private FragmentCreateBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
    }

    private void initClickers() {
        binding.applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendText();
            }
        });
    }

    private void sendText() {
        String text = binding.taskEd.getText().toString();
        String number = binding.edNumber.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("key", text);
        bundle.putString("keu", number);
        Navigation.findNavController(requireView()).navigate(R.id.homeFragment, bundle);
    }
}