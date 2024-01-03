package apps.construction.site.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import apps.construction.site.R
import apps.construction.site.adapter.ItemChooseToTableAdapter
import apps.construction.site.adapter.ItemCoworkerAdapter
import apps.construction.site.adapter.ItemMainMenuAdapter
import apps.construction.site.adapter.ItemSwitchProjectAdapter
import apps.construction.site.adapter.ItemToTableAdapter
import apps.construction.site.databinding.ActivityChooseToTableBinding
import apps.construction.site.databinding.ActivityCoworkerBookBinding
import apps.construction.site.databinding.ActivityNotifyDetailBinding
import apps.construction.site.databinding.ActivityToTableBinding
import apps.construction.site.dialog.SignOutDialogFragment
import apps.construction.site.model.ChooseToTableDto
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


class ChooseToTableActivity : BaseAppBindActivity<ActivityChooseToTableBinding>() {

    private var itemChooseToTableData = mutableListOf<ChooseToTableDto>()
    private val itemChooseToTableAdapter by lazy { ItemChooseToTableAdapter() }
    override fun layoutRes(): Int {
        return R.layout.activity_choose_to_table
    }


    override fun initialize(savedInstanceState: Bundle?) {
        itemChooseToTableData.add(ChooseToTableDto("開工前"))
        itemChooseToTableData.add(ChooseToTableDto("開工中"))
        itemChooseToTableData.add(ChooseToTableDto("開工後"))
        itemChooseToTableAdapter.setItems(itemChooseToTableData)
        binding.recycle.adapter = itemChooseToTableAdapter
        binding.recycle.layoutManager = LinearLayoutManager(this)
        binding.recycle.addItemDecoration(SpaceItemDecoration(0.dpToPx, 0.dpToPx, 0.dpToPx))
        binding.recycle.setHasFixedSize(true)
        binding.recycle.itemAnimator = null
        itemChooseToTableAdapter.setOnItemClickListener(listener = object :
            BaseRecyclerAdapter.OnItemClickListener<ChooseToTableDto> {
            override fun onItemClick(holder: Any, item: ChooseToTableDto, position: Int) {

            }
        })
    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(true).setIconLeft(R.drawable.icon_black_left)
            .setBgColor(nearby.lib.base.R.color.white).setTitle(
                title = getString(R.string.to_table),
                titleColor = nearby.lib.base.R.color.black
            ).build()
    }

}