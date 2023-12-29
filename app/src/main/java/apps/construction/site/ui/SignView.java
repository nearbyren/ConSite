package apps.construction.site.ui;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class SignView extends View {
    private String TAG = this.getClass().getName();
    private Path mPath = new Path();
    private Paint mPaint = new Paint();
    //位图的绘制内容输出者：画布
    private Canvas mCanvas;
    //用来存放绘制内容的位图
    private Bitmap mCacheBitmap;
    //上下文
    private Context mContext;

    public SignView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mPaint.setStyle(Paint.Style.STROKE);
//        Log.e(TAG, " mPaint.getStrokeWidth() = " + mPaint.getStrokeWidth());//默认描边宽度是0，但是真正绘制时依然有一个像素的宽度
//        mPaint.setStrokeWidth(10);//设置描边宽度，也就是笔迹的粗细
        Log.e(TAG, " mPaint.getStyle() = " + mPaint.getStyle());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCacheBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mCacheBitmap);
        mCanvas.drawColor(Color.WHITE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                mPath.moveTo(event.getX(), event.getY());
                Log.e(TAG, "ACTION_DOWN getX = " + event.getX() + " getY = " + event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(), event.getY());
                Log.e(TAG, "ACTION_MOVE getX = " + event.getX() + " getY = " + event.getY());
                break;
            case MotionEvent.ACTION_UP:
                getParent().requestDisallowInterceptTouchEvent(false);
                Log.e(TAG, "ACTION_UP getX = " + event.getX() + " getY = " + event.getY());
                break;
        }
        //真正负责绘制签名笔迹的画布，在这里接收路径mPath，以及事先定义好的颜料
        mCanvas.drawPath(mPath, mPaint);
        invalidate();
        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw canvas = " + canvas);
        canvas.drawPath(mPath, mPaint);
    }

    /**
     * 清空
     */
    public void clear() {
        Log.e(TAG, "clear()");
        if (mPath != null) {
            Log.e(TAG, "before clear mPath isEmpty => " + mPath.isEmpty());
            mPath.reset();
            mCanvas.drawColor(Color.WHITE);
            Log.e(TAG, "after clear mPath isEmpty => " + mPath.isEmpty());
            invalidate();
        }
    }

    public void save() {
        //创建一个文件用于存放图片
        File file = new File(mContext.getExternalCacheDir() + "testSign.png");
        if (file.exists()) {
            file.delete();
        }
        OutputStream outputStream = null;
        try {
            //输出到这个文件
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "保存异常：" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        //压缩形成输出流
        mCacheBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        Toast.makeText(mContext, "保存成功!", Toast.LENGTH_SHORT).show();
    }

}
