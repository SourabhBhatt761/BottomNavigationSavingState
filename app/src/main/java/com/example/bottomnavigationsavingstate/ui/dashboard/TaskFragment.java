package com.example.bottomnavigationsavingstate.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bottomnavigationsavingstate.databinding.FragmentDashboardBinding;

public class TaskFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private static final String TAG = "TaskFragment";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TaskViewModel taskViewModel =
                new ViewModelProvider(this).get(TaskViewModel.class);

        Log.i(TAG,"onCreateView");
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        taskViewModel.setText();

        final TextView textView = binding.textDashboard;
        taskViewModel.getText().observe(getViewLifecycleOwner(), t->{
            textView.setText(t);
            Log.i(TAG,"getting text");
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        Log.i(TAG,"onDestroyView");
    }
}