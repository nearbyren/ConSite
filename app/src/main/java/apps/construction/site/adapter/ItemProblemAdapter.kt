package apps.construction.site.adapter

import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import apps.construction.site.R
import apps.construction.site.databinding.ItemCommonProblemBinding
import apps.construction.site.model.ProblemDto
import nearby.lib.uikit.recyclerview.BaseBindRecyclerAdapter


class ItemProblemAdapter : BaseBindRecyclerAdapter<ItemCommonProblemBinding, ProblemDto>() {

    private var upDown: Boolean = false
    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_common_problem
    }

    override fun onBindingItem(binding: ItemCommonProblemBinding, item: ProblemDto, position: Int) {
        binding.commonProblemIcon.background = ContextCompat.getDrawable(
            context,
            R.drawable.icon_up
        )
        binding.click.setOnClickListener {
            upDown = !upDown
            if(upDown){
                binding.commonProblemIcon.background = ContextCompat.getDrawable(
                    context,
                    R.drawable.icon_down
                )
                binding.commonProblemTextLeft2.isVisible = true
                binding.commonProblemTextRight2.isVisible = true
                binding.at16.isVisible = true
            }else{
                binding.commonProblemIcon.background = ContextCompat.getDrawable(
                    context,
                    R.drawable.icon_up
                )
                binding.commonProblemTextLeft2.isVisible = false
                binding.commonProblemTextRight2.isVisible = false
                binding.at16.isVisible = false
            }
        }
    }
}