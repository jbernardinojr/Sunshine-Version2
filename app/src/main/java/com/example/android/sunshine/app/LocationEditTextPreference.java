package com.example.android.sunshine.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by root on 30/10/17.
 */

public class LocationEditTextPreference extends EditTextPreference {
    private static final int DEFAULT_MINIMUM_LOCATION_LENGTH = 0;
    private final int mMinLength;

    public LocationEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.LocationEditTextPreference,0,0);

        try {
            mMinLength = a.getInteger(R.styleable.LocationEditTextPreference_minLength,
                    DEFAULT_MINIMUM_LOCATION_LENGTH);
        }finally {
            a.recycle();
        }

    }

    @Override
    protected View onCreateDialogView() {
        Log.d("Bernardino", "minLength = " + mMinLength);
        return super.onCreateDialogView();
    }

    @Override
    protected void showDialog(Bundle state){
        super.showDialog(state);
        EditText et = getEditText();

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Button positiveButton;
                Dialog dialog = getDialog();
                if (dialog instanceof AlertDialog) {
                    AlertDialog alertDialog = (AlertDialog) dialog;
                    positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    if (editable.length() >= mMinLength) {
                        positiveButton.setEnabled(true);
                    } else {
                        positiveButton.setEnabled(false);
                    }
                }
            }
        });
    }
}
