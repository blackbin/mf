package com.jzhu.study.studyaroutermodule.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.jzhu.study.studyaroutermodule.R;
import com.jzhu.study.studyaroutermodule.R2;
@Route(path = "/studyaroutermodule/webviewTestActivity")
public class WebviewTestActivity extends Activity {

    @BindView(R2.id.webview)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.router_activity_web);
        ButterKnife.bind(this);
        webView.loadUrl(getIntent().getStringExtra("url"));
    }
}
