package com.okay.seng449mvvm.Base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.okay.seng449mvvm.R;

public abstract class BaseActivityCompat extends AppCompatActivity {
    private ProgressDialog prg;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutResourceId());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    protected abstract int getLayoutResourceId();

    public void showLoading() {
        try {
            if (prg == null) {
                prg = new ProgressDialog(this);
                prg.setMessage(getString(R.string.please_wait));
                prg.setCancelable(false);
                prg.setIndeterminate(true);
            }
            if (!prg.isShowing())
                prg.show();
        } catch (Exception e) {

        }
    }

    public void hideLoading() {
        if (prg != null)
            if (prg.isShowing())
                prg.dismiss();
    }
}
