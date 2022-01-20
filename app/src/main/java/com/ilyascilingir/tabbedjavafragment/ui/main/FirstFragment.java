package com.ilyascilingir.tabbedjavafragment.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ilyascilingir.tabbedjavafragment.R;
import com.ilyascilingir.tabbedjavafragment.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {

    PageViewModel pageViewModel;

    FragmentFirstBinding binding;

    public static FirstFragment newInstance (){
        return new FirstFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Toast.makeText(getActivity().getApplicationContext(), "Aktiviteniz hazır.", Toast.LENGTH_LONG).show();

        //pageViewModel = ViewModelProviders.of(requireActivity()).get(PageViewModel.class);

        //pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);

        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);
        
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_first,container,false);

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.editTextPersonName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                pageViewModel.setName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}