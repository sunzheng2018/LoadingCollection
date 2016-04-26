package together.art.com.loading;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView tv_text;
    private Button btn_first;
    private Button btn_second;
    private Button btn_third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    public void init() {
        tv_text = (TextView) findViewById(R.id.tv_text);
        btn_first = (Button) findViewById(R.id.btn_first);
        btn_second = (Button) findViewById(R.id.btn_second);
        btn_third = (Button) findViewById(R.id.btn_third);

        btn_first.setOnClickListener(this);
        btn_second.setOnClickListener(this);
        btn_third.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_first:
                intent = new Intent(MainActivity.this, LoadingActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_second:
                intent = new Intent(MainActivity.this, SogoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_third:
                Toast.makeText(MainActivity.this, "hehe", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
