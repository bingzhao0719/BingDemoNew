package com.bing.bingdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bing.bingdemo.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public Fragment1() {
    }
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e("wubingzhao", "onAttach Fragment1: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("wubingzhao", "onCreate Fragment1: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("wubingzhao", "onCreateView Fragment1: ");
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("wubingzhao", "onActivityCreated Fragment1: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("wubingzhao", "onStart Fragment1: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("wubingzhao", "onResume Fragment1: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("wubingzhao", "onDestroy Fragment1: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("wubingzhao", "onDetach Fragment1: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("wubingzhao", "onDestroyView Fragment1: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("wubingzhao", "onPause Fragment1: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("wubingzhao", "onStop Fragment1: ");
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i("wubingzhao", "isVisibleToUser Fragment1: "+isVisibleToUser);
    }

    @Override
    public boolean getUserVisibleHint() {
        Log.i("wubingzhao", "getUserVisibleHint Fragment1: ");
        return super.getUserVisibleHint();
    }
}
