package apps.construction.site.uitl.file

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.text.TextUtils
import androidx.core.content.FileProvider
import java.io.File
import java.util.Locale


object FileOpen {
    fun openFile(context: Context, file: File) {
        val intent = Intent(Intent.ACTION_VIEW)
        //intent.addCategory(Intent.CATEGORY_DEFAULT);
        val uriForFile: Uri
        if (Build.VERSION.SDK_INT > 23) {
            //Android 7.0之后
            uriForFile =
                FileProvider.getUriForFile(context,  "apps.construction.site.fileProvider", file)
            intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION) //给目标文件临时授权
        } else {
            uriForFile = Uri.fromFile(file)
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) //系统会检查当前所有已创建的Task中是否有该要启动的Activity的Task;
        // 若有，则在该Task上创建Activity；若没有则新建具有该Activity属性的Task，并在该新建的Task上创建Activity。
        intent.setDataAndType(uriForFile, getMimeTypeFromFile(file))
        context.startActivity(intent)
    }

    /**
     * 使用自定义方法获得文件的MIME类型
     */
    private fun getMimeTypeFromFile(file: File): String? {
        var type = "*/*"
        val fName = file.name
        //获取后缀名前的分隔符"."在fName中的位置。
        val dotIndex = fName.lastIndexOf(".")
        if (dotIndex > 0) {
            //获取文件的后缀名
            val end = fName.substring(dotIndex, fName.length).lowercase(Locale.getDefault())
            //在MIME和文件类型的匹配表中找到对应的MIME类型。
            val map: HashMap<String, String> = MyMimeMap.mimeMap
            if (!TextUtils.isEmpty(end) && map.keys.contains(end)) {
                type = map[end].toString()
            }
        }
        return type
    }
}