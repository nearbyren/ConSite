package apps.construction.site.adapter

import androidx.core.content.ContextCompat
import apps.construction.site.R
import apps.construction.site.databinding.ItemSwitchProjectBinding
import apps.construction.site.model.SwitchDto
import nearby.lib.uikit.recyclerview.BaseBindRecyclerAdapter


class ItemSwitchProjectAdapter : BaseBindRecyclerAdapter<ItemSwitchProjectBinding, SwitchDto>() {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_switch_project
    }

    override fun onBindingItem(binding: ItemSwitchProjectBinding, item: SwitchDto, position: Int) {
        binding.switchText.text = item.text
        if (item.bol) {
            binding.switchTextIcon.background = ContextCompat.getDrawable(context, item.icon)
        } else {
            binding.switchTextIcon.background = null
        }
    }
}