package com.jzhu.study.studyaroutermodule.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jzhu.study.studyaroutermodule.R;
import com.jzhu.study.studyaroutermodule.R2;
import com.jzhu.study.studyaroutermodule.service.TestService;

@Route(path = "/studyaroutermodule/firstActivity")
public class FirstActivity extends Activity {

    @Autowired
    String name;

    @Autowired
    int age;

    @Autowired
    TestService testService;

    @BindView(R2.id.text)
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.router_activity_first);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);
        String params = String.format("name=%s, age=%s", name, age);
        text.setText(params);
        testService.print("testService");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("name","jzhu");
        setResult(RESULT_OK,intent);
        finish();
    }
}
