package com.jzhu.study.testmodule;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/testmodule/activity")
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R2.id.hello})
    public void onClick(View view) {
        switch (view.getId()){
            case R2.id.hello:
                Log.i("zj","hello");
                break;
        }
    }
}
