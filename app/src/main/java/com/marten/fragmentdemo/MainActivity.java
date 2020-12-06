package com.marten.fragmentdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //UI Object
    private TextView mTvHome;
    private TextView mTvNotes;
    private TextView mTvUser;
    private TextView mTvSettings;

    //Fragment Object
    private MyFragment mFgHome, mFgNotes, mFgUser, mFgSettings;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        initObject();
        mTvHome.performClick();
    }

    private void initObject() {
        mTvHome = findViewById(R.id.tv_home);
        mTvNotes = findViewById(R.id.tv_notes);
        mTvUser = findViewById(R.id.tv_user);
        mTvSettings = findViewById(R.id.tv_settings);

        mTvHome.setOnClickListener(this);
        mTvNotes.setOnClickListener(this);
        mTvUser.setOnClickListener(this);
        mTvSettings.setOnClickListener(this);
    }

    private void setUnselected() {
        mTvHome.setSelected(false);
        mTvNotes.setSelected(false);
        mTvUser.setSelected(false);
        mTvSettings.setSelected(false);
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (mFgHome != null) {
            fragmentTransaction.hide(mFgHome);
        }
        if (mFgNotes != null) {
            fragmentTransaction.hide(mFgNotes);
        }
        if (mFgUser != null) {
            fragmentTransaction.hide(mFgUser);
        }
        if (mFgSettings != null) {
            fragmentTransaction.hide(mFgSettings);
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (v.getId()) {
            case R.id.tv_home:
                setUnselected();
                mTvHome.setSelected(true);
                if (mFgHome == null) {
                    mFgHome = new MyFragment("Home");
                    fragmentTransaction.add(R.id.fl_content, mFgHome);
                } else {
                    fragmentTransaction.show(mFgHome);
                }
                break;
            case R.id.tv_notes:
                setUnselected();
                mTvNotes.setSelected(true);
                if (mFgNotes == null) {
                    mFgNotes = new MyFragment("Notes");
                    fragmentTransaction.add(R.id.fl_content, mFgNotes);
                } else {
                    fragmentTransaction.show(mFgNotes);
                }
                break;
            case R.id.tv_user:
                setUnselected();
                mTvUser.setSelected(true);
                if (mFgUser == null) {
                    mFgUser = new MyFragment("User");
                    fragmentTransaction.add(R.id.fl_content, mFgUser);
                } else {
                    fragmentTransaction.show(mFgUser);
                }
                break;
            case R.id.tv_settings:
                setUnselected();
                mTvSettings.setSelected(true);
                if (mFgSettings == null) {
                    mFgSettings = new MyFragment("Settings");
                    fragmentTransaction.add(R.id.fl_content, mFgSettings);
                } else {
                    fragmentTransaction.show(mFgSettings);
                }
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }
}