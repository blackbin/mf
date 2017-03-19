package com.jzhu.study.studyaroutermodule.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jzhu.study.studyaroutermodule.R;
import com.jzhu.study.studyaroutermodule.R2;

@Route(path = "/studyaroutermodule/secondActivity")
public class SecondActivity extends Activity {

    @Autowired
    String sex;

    @BindView(R2.id.text)
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.router_activity_second);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);
        String params = String.format("sex=%s", sex);
        text.setText(params);
    }

}
