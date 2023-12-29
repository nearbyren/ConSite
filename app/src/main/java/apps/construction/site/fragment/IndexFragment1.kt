package apps.construction.site.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import apps.construction.site.R
import apps.construction.site.adapter.ItemMainMenuAdapter
import apps.construction.site.adapter.ItemSwitchProjectAdapter
import apps.construction.site.databinding.FragmentIndex1Binding
import apps.construction.site.http.IndexViewModel
import apps.construction.site.model.MenuDto
import apps.construction.site.model.SwitchDto
import apps.construction.site.ui.CoworkerActivity
import apps.construction.site.ui.DocumentUploadActivity
import apps.construction.site.ui.SelectTabTypeActivity
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
import com.scwang.smart.refresh.layout.listener.OnRefreshListener
import nearby.lib.mvvm.fragment.BaseAppBVMFragment
import nearby.lib.uikit.recyclerview.BaseRecyclerAdapter
import nearby.lib.uikit.recyclerview.SpaceItemDecoration
import nearby.lib.uikit.widgets.dpToPx


class IndexFragment1 :
    BaseAppBVMFragment<FragmentIndex1Binding, IndexViewModel>(), View.OnClickListener {


    var flag = false
    override fun createViewModel(): IndexViewModel {
        return IndexViewModel()
    }

    override fun layoutRes(): Int {
        return R.layout.fragment_index_1
    }

    private var itemMenuData = mutableListOf<MenuDto>()
    private var itemSwitchData = mutableListOf<SwitchDto>()
    private val itemMainMenuAdapter by lazy { ItemMainMenuAdapter() }
    private val itemSwitchProjectAdapter by lazy { ItemSwitchProjectAdapter() }
    override fun initialize(savedInstanceState: Bundle?) {
        itemMenuData.add(MenuDto("表格", R.drawable.ic_item_01))
        itemMenuData.add(MenuDto("通往表格", R.drawable.ic_item_02))
        itemMenuData.add(MenuDto("證件上傳", R.drawable.ic_item_03))
        itemMenuData.add(MenuDto("文件", R.drawable.ic_item_04))
        itemMenuData.add(MenuDto("工友通訊錄", R.drawable.ic_item_05))
        itemMenuData.add(MenuDto("匯總表", R.drawable.ic_item_06))



        itemMainMenuAdapter.setItems(itemMenuData)
        binding.recycleMenu.adapter = itemMainMenuAdapter
        binding.recycleMenu.layoutManager = GridLayoutManager(context, 4)
        binding.recycleMenu.addItemDecoration(SpaceItemDecoration(0, 22.dpToPx, 17.dpToPx))
        binding.recycleMenu.setHasFixedSize(true)
        binding.recycleMenu.itemAnimator = null
        itemMainMenuAdapter.setOnItemClickListener(listener = object :
            BaseRecyclerAdapter.OnItemClickListener<MenuDto> {
            override fun onItemClick(holder: Any, item: MenuDto, position: Int) {
                when (item.text) {
                    "通往表格" -> {
                        navigate(SelectTabTypeActivity::class.java)
                    }

                    "證件上傳" -> {
                        navigate(DocumentUploadActivity::class.java)
                    }
                    "工友通訊錄" -> {
                        navigate(CoworkerActivity::class.java)
                    }
                }
            }
        })

        itemSwitchData.add(SwitchDto("C10513項目", bol = true))
        itemSwitchData.add(SwitchDto("C10515項目"))
        itemSwitchProjectAdapter.setItems(itemSwitchData)
        binding.recycleSwitch.adapter = itemSwitchProjectAdapter
        binding.recycleSwitch.layoutManager = LinearLayoutManager(requireActivity())
        binding.recycleSwitch.addItemDecoration(SpaceItemDecoration(7.dpToPx, 0.dpToPx, 0.dpToPx))
        binding.recycleSwitch.setHasFixedSize(true)
        binding.recycleSwitch.itemAnimator = null
        itemSwitchProjectAdapter.setOnItemClickListener(listener = object :
            BaseRecyclerAdapter.OnItemClickListener<SwitchDto> {
            override fun onItemClick(holder: Any, item: SwitchDto, position: Int) {
                for (items in itemSwitchData) {
                    items.bol = items.text == item.text
                }
                itemSwitchProjectAdapter.notifyDataSetChanged()
                binding.title.text = item.text
                openSwitch()
            }
        })


        binding.topTitle.setOnClickListener(this)


        binding.titleContent.setOnClickListener(this)


        binding.srl.setRefreshHeader(ClassicsHeader(requireActivity()))
        binding.srl.setRefreshFooter(ClassicsFooter(requireActivity()))
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

    override fun onClick(view: View?) {
        view?.let {
            when (it.id) {
                R.id.top_title -> {
                    openSwitch()
                }

                R.id.title_content -> {
                    openSwitch()
                }
            }
        }
    }

    private fun openSwitch() {
        flag = !flag
        binding.titleContent.isVisible = flag
    }
}