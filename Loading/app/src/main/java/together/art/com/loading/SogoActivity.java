package together.art.com.loading;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import together.art.com.loading.view.SoGouBrowserLoading;

public class SogoActivity extends Activity implements View.OnClickListener {

    private SoGouBrowserLoading mLoadingView ;
    private Button btn_loading;
    private boolean isRun = false;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sogo_loading);

        mLoadingView = (SoGouBrowserLoading) findViewById(R.id.sogo_loading);
        btn_loading = (Button) findViewById(R.id.btn_loading);

        btn_loading.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_loading:

                break;
        }
    }


}
