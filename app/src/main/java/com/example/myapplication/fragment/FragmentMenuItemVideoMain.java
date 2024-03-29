package com.example.myapplication.fragment;

import android.app.Dialog;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class FragmentMenuItemVideoMain extends BottomSheetDialogFragment {

    @NonNull
    public static FragmentMenuItemVideoMain newInstance(){
        FragmentMenuItemVideoMain fragmentMenuItemVideoMain = new FragmentMenuItemVideoMain();
        return fragmentMenuItemVideoMain;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bt = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_menu_item_video_main, null);
        bt.setContentView(view);
        return bt;
    }
}
