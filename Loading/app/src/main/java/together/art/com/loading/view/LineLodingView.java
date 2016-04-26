package together.art.com.loading.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/4/25.
 */
public class LineLodingView extends View {

    private Context mContext;
    private int mWidth;
    private int mHeight;
    private Paint mLinePaint;
    private Paint mTextPaint;
    private int mProgress ;

    private float startX;
    private float endX;
    private float step ;
    private int padding = 10;

    public LineLodingView(Context context) {
        super(context);
        init(context);
    }

    public LineLodingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LineLodingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setColor(Color.BLUE);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setColor(Color.BLUE);
        mTextPaint.setTextSize(22);

        mProgress = 0;
        startX = 0;
        endX = 0;
        step = 0;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    public void setProgress(int progress) {
        mProgress = progress;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int height = mHeight/2;
        String progress = mProgress + "%";
        Rect bounds1 = new Rect();
        mTextPaint.getTextBounds(progress, 0, progress.length(), bounds1);
        Paint.FontMetricsInt fontMetrics = mTextPaint.getFontMetricsInt();

        int fontWidth = bounds1.width();
        step = (mWidth - fontWidth - padding * 2) / 100f; // 宽度-字宽 - 距离左边宽度
        startX = mProgress * step;

        float trueStartX = startX + padding;
        endX = trueStartX + fontWidth + padding;

        int baseline = (mHeight - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        canvas.drawText(progress, trueStartX, baseline, mTextPaint); // mWidth / 2 - bounds1.width() / 2
        canvas.drawLine(0, height, startX, height, mLinePaint);
        canvas.drawLine(endX, height, mWidth, height, mLinePaint);
    }
}
