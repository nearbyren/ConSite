package apps.construction.site.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.OutputStream

class SignView2(//上下文
    private val mContext: Context, attrs: AttributeSet?
) :
    View(mContext, attrs) {
    private val TAG = this.javaClass.name
    private val mPath: Path? = Path()
    private val mPaint = Paint()

    //位图的绘制内容输出者：画布
    private var mCanvas: Canvas? = null

    //用来存放绘制内容的位图
    private var mCacheBitmap: Bitmap? = null

    init {
        mPaint.style = Paint.Style.STROKE
        //        Log.e(TAG, " mPaint.getStrokeWidth() = " + mPaint.getStrokeWidth());//默认描边宽度是0，但是真正绘制时依然有一个像素的宽度
//        mPaint.setStrokeWidth(10);//设置描边宽度，也就是笔迹的粗细
        Log.e(TAG, " mPaint.getStyle() = " + mPaint.style)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mCacheBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        mCanvas = Canvas(mCacheBitmap!!)
        mCanvas!!.drawColor(Color.WHITE)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                parent.requestDisallowInterceptTouchEvent(true)
                mPath!!.moveTo(event.x, event.y)
                Log.e(TAG, "ACTION_DOWN getX = " + event.x + " getY = " + event.y)
            }

            MotionEvent.ACTION_MOVE -> {
                mPath!!.lineTo(event.x, event.y)
                Log.e(TAG, "ACTION_MOVE getX = " + event.x + " getY = " + event.y)
            }

            MotionEvent.ACTION_UP -> {
                parent.requestDisallowInterceptTouchEvent(false)
                Log.e(TAG, "ACTION_UP getX = " + event.x + " getY = " + event.y)
            }
        }
        //真正负责绘制签名笔迹的画布，在这里接收路径mPath，以及事先定义好的颜料
        mCanvas!!.drawPath(mPath!!, mPaint)
        invalidate()
        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        Log.e(TAG, "onDraw canvas = $canvas")
        canvas.drawPath(mPath!!, mPaint)
    }

    /**
     * 清空
     */
    fun clear() {
        Log.e(TAG, "clear()")
        if (mPath != null) {
            Log.e(TAG, "before clear mPath isEmpty => " + mPath.isEmpty)
            mPath.reset()
            mCanvas!!.drawColor(Color.WHITE)
            Log.e(TAG, "after clear mPath isEmpty => " + mPath.isEmpty)
            invalidate()
        }
    }

    fun save() {
        //创建一个文件用于存放图片
        val file = File(mContext.externalCacheDir.toString() + "testSign.png")
        if (file.exists()) {
            file.delete()
        }
        var outputStream: OutputStream? = null
        try {
            //输出到这个文件
            outputStream = FileOutputStream(file)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            Toast.makeText(mContext, "保存异常：" + e.message, Toast.LENGTH_SHORT).show()
        }
        //压缩形成输出流
        mCacheBitmap!!.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        Toast.makeText(mContext, "保存成功!", Toast.LENGTH_SHORT).show()
    }
}