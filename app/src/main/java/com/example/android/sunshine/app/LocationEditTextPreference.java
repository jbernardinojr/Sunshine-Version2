package com.example.android.sunshine.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

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
}
