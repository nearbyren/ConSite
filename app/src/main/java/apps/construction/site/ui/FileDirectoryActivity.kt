package apps.construction.site.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import apps.construction.site.R
import apps.construction.site.adapter.ItemFileDirectoryAdapter
import apps.construction.site.databinding.ActivityFileDirectoryBinding
import apps.construction.site.model.FileDirectoryDto
import apps.construction.site.uitl.file.FileOpen.openFile
import apps.construction.site.uitl.file.WpsModel
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
import com.scwang.smart.refresh.layout.listener.OnRefreshListener
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.activity.BaseAppBindActivity
import nearby.lib.uikit.recyclerview.BaseRecyclerAdapter
import nearby.lib.uikit.recyclerview.SpaceItemDecoration
import nearby.lib.uikit.widgets.dpToPx
import java.io.File


class FileDirectoryActivity : BaseAppBindActivity<ActivityFileDirectoryBinding>() {

    private var itemDirectoryData = mutableListOf<FileDirectoryDto>()
    private val itemFileDirectoryAdapter by lazy { ItemFileDirectoryAdapter() }
    override fun layoutRes(): Int {
        return R.layout.activity_file_directory
    }


    override fun initialize(savedInstanceState: Bundle?) {
        itemDirectoryData.add(FileDirectoryDto())
        itemDirectoryData.add(FileDirectoryDto())
        itemDirectoryData.add(FileDirectoryDto())
        itemDirectoryData.add(FileDirectoryDto())
        itemDirectoryData.add(FileDirectoryDto())
        itemDirectoryData.add(FileDirectoryDto())
        itemDirectoryData.add(FileDirectoryDto())
        itemDirectoryData.add(FileDirectoryDto())
        itemDirectoryData.add(FileDirectoryDto())
        itemDirectoryData.add(FileDirectoryDto())
        itemDirectoryData.add(FileDirectoryDto())
        itemDirectoryData.add(FileDirectoryDto())
        itemDirectoryData.add(FileDirectoryDto())
        itemDirectoryData.add(FileDirectoryDto())
        itemFileDirectoryAdapter.setItems(itemDirectoryData)
        binding.recycle.adapter = itemFileDirectoryAdapter
        binding.recycle.layoutManager = LinearLayoutManager(this)
        binding.recycle.addItemDecoration(SpaceItemDecoration(7.dpToPx, 0.dpToPx, 0.dpToPx))
        binding.recycle.setHasFixedSize(true)
        binding.recycle.itemAnimator = null
        itemFileDirectoryAdapter.setOnItemClickListener(listener = object :
            BaseRecyclerAdapter.OnItemClickListener<FileDirectoryDto> {
            override fun onItemClick(holder: Any, item: FileDirectoryDto, position: Int) {
                val file = File("/mnt/sdcard/工地後台 UI修收.pptx")
                val bundle = Bundle()
                bundle.putString(WpsModel.OPEN_MODE, WpsModel.OpenMode.NORMAL) // 打开模式
                bundle.putBoolean(WpsModel.ENTER_REVISE_MODE, true) // 以修订模式打开文档
                bundle.putBoolean(WpsModel.SEND_CLOSE_BROAD, true) // 文件关闭时是否发送广播
                bundle.putBoolean(WpsModel.SEND_SAVE_BROAD, true) // 文件保存时是否发送广播
                bundle.putBoolean(WpsModel.HOMEKEY_DOWN, true) // 单机home键是否发送广播
                bundle.putBoolean(WpsModel.BACKKEY_DOWN, true) // 单机back键是否发送广播
                bundle.putBoolean(WpsModel.SAVE_PATH, true) // 文件这次保存的路径
                bundle.putString(
                    WpsModel.THIRD_PACKAGE,
                    WpsModel.PackageName.NORMAL
                ) // 第三方应用的包名，用于对改应用合法性的验证
                openFile(this@FileDirectoryActivity, file)
            }
        })
        binding.srl.setRefreshHeader(ClassicsHeader(this))
        binding.srl.setRefreshFooter(ClassicsFooter(this))
        //设置 Footer 为 球脉冲 样式
//        binding.srl.setRefreshFooter(BallPulseFooter(requireActivity()).setSpinnerStyle(SpinnerStyle.Scale));

        binding.srl.setOnRefreshListener(OnRefreshListener { refreshlayout ->
            refreshlayout.finishRefresh(2000 /*,false*/) //传入false表示刷新失败
        })
        binding.srl.setOnLoadMoreListener(OnLoadMoreListener { refreshlayout ->
            refreshlayout.finishLoadMore(2000 /*,false*/) //传入false表示加载失败
        })


        // 设置下拉刷新监听
        binding.srl.setOnRefreshListener { refreshLayout -> // 执行刷新操作
            // 这里可以异步请求数据，刷新完成后调用 refreshLayout.finishRefresh()
            binding.srl.finishRefresh()
        }

        // 设置上拉加载更多监听
        binding.srl.setOnLoadMoreListener { refreshLayout -> // 执行加载更多操作
            // 这里可以异步请求数据，加载完成后调用 refreshLayout.finishLoadMore()
            binding.srl.finishLoadMore()
        }
    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(true).setIconLeft(R.drawable.icon_black_left)
            .setBgColor(nearby.lib.base.R.color.white).setTitle(
                title = getString(R.string.file_directory),
                titleColor = nearby.lib.base.R.color.black
            ).build()
    }

}