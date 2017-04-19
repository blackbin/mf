package com.jzhu.study.studyaroutermodule.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jzhu.study.studyaroutermodule.R;
import com.jzhu.study.studyaroutermodule.R2;
import com.jzhu.study.studyaroutermodule.service.TestService;

@Route(path = "/studyaroutermodule/mainActivity")
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.router_activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({ R2.id.with_param, R2.id.with_interceptor, R2.id.with_service, R2.id.with_url, R2.id.with_no_interceptor })
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.with_param) {
            ARouter.getInstance().build("/studyaroutermodule/firstActivity")
                   .withString("name", "jzhu")
                   .withInt("age", 18)
                   .navigation(this, 555);
        }
        else if (id == R.id.with_interceptor) {
            ARouter.getInstance().build("/studyaroutermodule/secondActivity")
                   .navigation(this, new NavigationCallback() {
                       @Override
                       public void onFound(Postcard postcard) {
                           Log.i("zj", "onFound");
                       }

                       @Override
                       public void onLost(Postcard postcard) {
                           Log.i("zj", "onLost");
                       }

                       @Override
                       public void onArrival(Postcard postcard) {

                       }

                       @Override
                       public void onInterrupt(Postcard postcard) {

                       }
                   });
        }
        else if (id == R.id.with_no_interceptor) {
            ARouter.getInstance().build("/studyaroutermodule/secondActivity").greenChannel().navigation();
        }
        else if (id == R.id.with_service) {
//            ((TestService) ARouter.getInstance().build("/service/test").navigation()).print(" from TestService by name");
            ARouter.getInstance().navigation(TestService.class).print("from TestService by type");
        }
        else if (id == R.id.with_url) {
            ARouter.getInstance().build("/studyaroutermodule/webviewTestActivity")
                   .withString("url", "file:///android_asset/schame-test.html")
                   .navigation();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case 555:
                String params = String.format("resultCode=%s, name=%s", resultCode, data.getStringExtra("name"));
                Toast.makeText(this, params, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
