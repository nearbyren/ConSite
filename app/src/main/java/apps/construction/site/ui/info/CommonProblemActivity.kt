package apps.construction.site.ui.info

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import apps.construction.site.R
import apps.construction.site.databinding.ActivityCommonProblemBinding
import apps.construction.site.model.ProblemDto
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.activity.BaseAppBindActivity
import nearby.lib.uikit.recyclerview.SpaceItemDecoration
import nearby.lib.uikit.widgets.dpToPx


class CommonProblemActivity : BaseAppBindActivity<ActivityCommonProblemBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_common_problem
    }

    private var activityItems = mutableListOf<ProblemDto>()
    private val itemProblemAdapter by lazy { apps.construction.site.adapter.ItemProblemAdapter() }
    private var upDown: Boolean = false
    override fun initialize(savedInstanceState: Bundle?) {
        activityItems.add(
            ProblemDto(
                "这是一个常见问题的问题描述?",
                "这是一个常见问题的回答，一般情况下两行如果可以展示出来的话就展示两行。"
            )
        )
        activityItems.add(
            ProblemDto(
                "这是一个常见问题的问题描述?",
                "这是一个常见问题的回答，一般情况下两行如果可以展示出来的话就展示两行。"
            )
        )
        activityItems.add(
            ProblemDto(
                "这是一个常见问题的问题描述?",
                "这是一个常见问题的回答，一般情况下两行如果可以展示出来的话就展示两行。"
            )
        )
        itemProblemAdapter.setItems(activityItems)
        binding.recycle.adapter = itemProblemAdapter
        binding.recycle.layoutManager = LinearLayoutManager(this)
        binding.recycle.addItemDecoration(SpaceItemDecoration(12.dpToPx, 0.dpToPx, 0.dpToPx))
        binding.recycle.setHasFixedSize(true)
        binding.recycle.itemAnimator = null
    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(true).setIconLeft(R.drawable.icon_black_left)
            .setBgColor(nearby.lib.base.R.color.white).setTitle(title = getString(R.string.info_11), titleColor = nearby.lib.base.R.color.black).build()
    }

}