package together.art.com.loading;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import together.art.com.loading.view.LineLodingView;

public class LoadingActivity extends Activity implements View.OnClickListener {

    private LineLodingView mLineLoading;
    private Button btn_loading;
    private Button btn_continue;
    private boolean isRun = true;
    private Thread thread;

    private int mCount = 0;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    mLineLoading.setProgress(mCount);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_loading);

        mLineLoading = (LineLodingView) findViewById(R.id.line_loading);
        btn_loading = (Button) findViewById(R.id.btn_loading);
        btn_continue = (Button) findViewById(R.id.btn_continue);

        btn_loading.setOnClickListener(this);
        btn_continue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_continue:
                if(!isRun) {
                    isRun = true;
                    btn_continue.setText("暂停");
                } else {
                    isRun = false;
                    btn_continue.setText("继续");
                }
                break;

            case R.id.btn_loading:
                if(thread != null) {
                    return;
                }
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            try {
                                if (isRun) {
                                    if (mCount < 96) {
                                        mHandler.sendEmptyMessage(0);
                                        mCount++;
                                        Thread.sleep(500);
                                    } else if (mCount >= 90 && mCount < 100) {
                                        mHandler.sendEmptyMessage(0);
                                        mCount++;
                                        Thread.sleep(1000);
                                    } else {
                                        mCount = 0;
                                    }
                                } else {
                                    Thread.sleep(1000);
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();

                break;
        }
    }


}
