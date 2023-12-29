package apps.construction.site.fragment

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import apps.construction.site.R
import apps.construction.site.adapter.ItemNotifyMessageAdapter
import apps.construction.site.databinding.FragmentIndex2Binding
import apps.construction.site.http.IndexViewModel
import apps.construction.site.model.MenuDto
import apps.construction.site.ui.NotifyDetailActivity
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
import com.scwang.smart.refresh.layout.listener.OnRefreshListener
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.fragment.BaseAppBVMFragment
import nearby.lib.uikit.recyclerview.BaseRecyclerAdapter
import nearby.lib.uikit.recyclerview.SpaceItemDecoration
import nearby.lib.uikit.widgets.dpToPx



class IndexFragment2 :
    BaseAppBVMFragment<FragmentIndex2Binding, IndexViewModel>() {
    override fun createViewModel(): IndexViewModel {
        return IndexViewModel()
    }

    override fun layoutRes(): Int {
        return R.layout.fragment_index_2
    }

    private var activityItems = mutableListOf<MenuDto>()
    private val indexTagAdapter by lazy { ItemNotifyMessageAdapter() }
    private var layoutManager: LinearLayoutManager? = null
    override fun initialize(savedInstanceState: Bundle?) {
        activityItems.add(MenuDto("", R.drawable.ic_item_01))
        activityItems.add(MenuDto("", R.drawable.ic_item_01))
        activityItems.add(MenuDto("", R.drawable.ic_item_01))
        activityItems.add(MenuDto("", R.drawable.ic_item_01))
        activityItems.add(MenuDto("", R.drawable.ic_item_01))
        activityItems.add(MenuDto("", R.drawable.ic_item_01))
        activityItems.add(MenuDto("", R.drawable.ic_item_01))
        activityItems.add(MenuDto("", R.drawable.ic_item_01))
        activityItems.add(MenuDto("", R.drawable.ic_item_01))
        layoutManager = LinearLayoutManager(context)
        indexTagAdapter.setItems(activityItems)
        binding.recycle.adapter = indexTagAdapter
        binding.recycle.layoutManager = layoutManager
        binding.recycle.addItemDecoration(SpaceItemDecoration(12.dpToPx, 0.dpToPx, 0.dpToPx))
        binding.recycle.setHasFixedSize(true)
        binding.recycle.itemAnimator = null
        indexTagAdapter.setOnItemClickListener(listener = object :
            BaseRecyclerAdapter.OnItemClickListener<MenuDto> {
            override fun onItemClick(holder: Any, item: MenuDto, position: Int) {
            navigate(NotifyDetailActivity::class.java)
            }
        })
        binding.srl.setRefreshHeader(ClassicsHeader(requireActivity()))
        binding.srl.setRefreshFooter( ClassicsFooter(requireActivity()))
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
        return BarHelperConfig.builder().setBack(false)
            .setBgColor(nearby.lib.base.R.color.white)
            .setTitle(title = getString(R.string.menu_02), titleColor = nearby.lib.base.R.color.black).build()
    }
}