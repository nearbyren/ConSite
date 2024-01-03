package apps.construction.site.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import apps.construction.site.R
import apps.construction.site.adapter.ItemCoworkerAdapter
import apps.construction.site.adapter.ItemMainMenuAdapter
import apps.construction.site.adapter.ItemSwitchProjectAdapter
import apps.construction.site.adapter.ItemToTableAdapter
import apps.construction.site.databinding.ActivityCoworkerBookBinding
import apps.construction.site.databinding.ActivityNotifyDetailBinding
import apps.construction.site.databinding.ActivityToTableBinding
import apps.construction.site.dialog.SignOutDialogFragment
import apps.construction.site.model.CoworkerDto
import apps.construction.site.model.MenuDto
import apps.construction.site.model.SwitchDto
import apps.construction.site.model.ToTableDto
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
import com.scwang.smart.refresh.layout.listener.OnRefreshListener
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.activity.BaseAppBindActivity
import nearby.lib.uikit.recyclerview.BaseRecyclerAdapter
import nearby.lib.uikit.recyclerview.SpaceItemDecoration
import nearby.lib.uikit.widgets.dpToPx


class ToTableActivity : BaseAppBindActivity<ActivityToTableBinding>() {

    private var itemToTableData = mutableListOf<ToTableDto>()
    private val itemToTableAdapter by lazy { ItemToTableAdapter() }
    override fun layoutRes(): Int {
        return R.layout.activity_to_table
    }


    override fun initialize(savedInstanceState: Bundle?) {
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableData.add(ToTableDto())
        itemToTableAdapter.setItems(itemToTableData)
        binding.recycle.adapter = itemToTableAdapter
        binding.recycle.layoutManager = LinearLayoutManager(this)
        binding.recycle.addItemDecoration(SpaceItemDecoration(7.dpToPx, 0.dpToPx, 0.dpToPx))
        binding.recycle.setHasFixedSize(true)
        binding.recycle.itemAnimator = null
        itemToTableAdapter.setOnItemClickListener(listener = object :
            BaseRecyclerAdapter.OnItemClickListener<ToTableDto> {
            override fun onItemClick(holder: Any, item: ToTableDto, position: Int) {
                navigate(ChooseToTableActivity::class.java)
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
                title = getString(R.string.to_table),
                titleColor = nearby.lib.base.R.color.black
            ).build()
    }

}