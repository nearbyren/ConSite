package apps.construction.site.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import nearby.lib.uikit.widgets.dpToPxF

class SignatureView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private var path = Path()
    private var paint = Paint()
    private var paintFont = Paint(ANTI_ALIAS_FLAG)
    private var signatureBitmap: Bitmap? = null
    private var signatureCanvas: Canvas? = null
    private var fontMetrics: Paint.FontMetrics? = null
    private var text = "簽名區域"

    init {
        setupPaint()
    }

    private fun setupPaint() {
        fontMetrics = Paint.FontMetrics()
        paintFont.textSize = 21.dpToPxF
        paintFont.textAlign = Paint.Align.CENTER
        paintFont.color = Color.parseColor("#999999")

        paint.color = Color.BLACK
        paint.isAntiAlias = true
        paint.strokeWidth = 5f
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeCap = Paint.Cap.ROUND

    }

    override fun onDraw(canvas: Canvas) {
        fontMetrics?.let { metrics ->
            val offset = (metrics.ascent + metrics.descent) / 2
            canvas.drawText(text, (width / 2).toFloat(), height / 2 - offset, paintFont)
        }
        // 绘制保存的位图
        signatureBitmap?.let {
            println("我來了")
            canvas.drawBitmap(it, 0f, 0f, paint)
        }
        // 绘制当前路径
        canvas.drawPath(path, paint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        setSignature(Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888))

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                //告知父類不要攔截事件
                parent.requestDisallowInterceptTouchEvent(true)
//                text = ""
                path.moveTo(x, y)
            }

            MotionEvent.ACTION_MOVE -> {
//
                path.lineTo(x, y)
            }

            MotionEvent.ACTION_UP -> {
                //告知父類攔截事件
                parent.requestDisallowInterceptTouchEvent(false)
                // 将当前路径绘制到位图中

            }
        }
        signatureCanvas?.drawPath(path, paint)
        invalidate()
        return true
    }

    fun clear() {
        // 清除路径和位图
        path.reset()
        signatureBitmap?.eraseColor(Color.TRANSPARENT)
        invalidate()
    }

    fun saveSignature(): Bitmap? {
        return signatureBitmap
    }

    fun setSignature(bitmap: Bitmap) {
        // 设置保存的位图
        signatureBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true)
        signatureCanvas = Canvas(signatureBitmap!!)
    }
}
