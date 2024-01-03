package apps.construction.site.uitl.file

object WpsModel {
    const val OPEN_MODE = "OpenMode" // 打开文件的模式。
    const val SEND_SAVE_BROAD = "SendSaveBroad" // 文件保存时是否发送广播。
    const val SEND_CLOSE_BROAD = "SendCloseBroad" // 文件关闭时是否发送广播
    const val THIRD_PACKAGE = "ThirdPackage" // 第三方的包名，关闭的广播会包含该项。
    const val CLEAR_BUFFER = "ClearBuffer" // 关闭文件时是否请空临时文件。
    const val CLEAR_TRACE = "ClearTrace" // 关闭文件时是否删除使用记录。
    const val CLEAR_FILE = "ClearFile" // 关闭文件时是否删除打开的文件。
    const val VIEW_PROGRESS = "ViewProgress" // 文件上次查看的进度。
    const val AUTO_JUMP = "AutoJump" // 是否自动跳转到上次查看的进度。
    const val SAVE_PATH = "SavePath" // 文件保存路径。
    const val VIEW_SCALE = "ViewScale" // 文件上次查看的视图的缩放。
    const val VIEW_SCALE_X = "ViewScrollX" // 文件上次查看的视图的X坐标。
    const val VIEW_SCALE_Y = "ViewScrollY" // 文件上次查看的视图的Y坐标。
    const val USER_NAME = "UserName" // 批注的作者。
    const val HOMEKEY_DOWN = "HomeKeyDown" // 监听home键并发广播
    const val BACKKEY_DOWN = "BackKeyDown" // 监听back键并发广播
    const val ENTER_REVISE_MODE = "EnterReviseMode" // 以修订模式打开文档
    const val CACHE_FILE_INVISIBLE = "CacheFileInvisible" // Wps生成的缓存文件外部是否可见

    object OpenMode {
        const val NORMAL = "Normal" // 只读模式
        const val READ_ONLY = "ReadOnly" // 正常模式
        const val READ_MODE = "ReadMode" // 打开直接进入阅读器模式

        // 仅Word、TXT文档支持
        const val SAVE_ONLY = "SaveOnly" // 保存模式(打开文件,另存,关闭)
        // 仅Word、TXT文档支持
    }

    object ClassName {
        const val NORMAL = "cn.wps.moffice.documentmanager.PreStartActivity2"

        // 普通版
        const val ENGLISH = "cn.wps.moffice.documentmanager.PreStartActivity2"

        // 英文版
        const val ENTERPRISE = "cn.wps.moffice.documentmanager.PreStartActivity2" // 企业版
    }

    object PackageName {
        const val NORMAL = "cn.wps.moffice_eng" // 普通版
        const val ENGLISH = "cn.wps.moffice_eng" // 英文版
    }

    object Reciver {
        const val ACTION_BACK = "com.kingsoft.writer.back.key.down" // 返回键广播
        const val ACTION_HOME = "com.kingsoft.writer.home.key.down" // Home键广播
        const val ACTION_SAVE = "cn.wps.moffice.file.save" // 保存广播
        const val ACTION_CLOSE = "cn.wps.moffice.file.close" // 关闭文件广播
    }
}