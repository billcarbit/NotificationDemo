package com.notification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.notification.presenter.MainPresenter;
import com.notification.view.IMainView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IMainView {

    private Button btn_send;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initView() {
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(this);
    }

    private void initPresenter() {
        mMainPresenter = new MainPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                if (mMainPresenter != null) {
                    mMainPresenter.sentNotification();
                }
                break;
        }
    }
}
