package nearby.lib.base.exts

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.*
import androidx.core.content.ContextCompat

/**
 * @description: 资源相关
 * @since: 1.0.0
 */


/**
 * 根据资源id获取颜色
 */
@ColorInt
fun @receiver:ColorRes Int.toColor(context: Context): Int {
    return ContextCompat.getColor(context, this)
}

/**
 * 根据资源id获取字符串
 */
fun @receiver:StringRes Int.toStr(context: Context): String {
    return context.getString(this)
}

/**
 * 根据资源id获取dimen
 */
fun @receiver:DimenRes Int.toDimen(context: Context): Float {
    return context.resources.getDimension(this)
}

/**
 * 根据资源id获取dimen，单位为px
 */
fun @receiver:DimenRes Int.toDimenPx(context: Context): Int {
    return context.resources.getDimensionPixelSize(this)
}

/**
 * 根据资源id获取drawable
 */
fun @receiver:DrawableRes Int.toDrawable(context: Context): Drawable? {
    return ContextCompat.getDrawable(context, this)
}
