package apps.construction.site.adapter

import androidx.core.content.ContextCompat
import apps.construction.site.R
import apps.construction.site.databinding.ItemMainMenuBinding
import apps.construction.site.model.MenuDto
import nearby.lib.uikit.recyclerview.BaseBindRecyclerAdapter


class ItemMainMenuAdapter : BaseBindRecyclerAdapter<ItemMainMenuBinding, MenuDto>() {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_main_menu
    }

    override fun onBindingItem(binding: ItemMainMenuBinding, item: MenuDto, position: Int) {
        binding.menuIcon.background = ContextCompat.getDrawable(context, item.icon)
        binding.menuText.text = item.text
    }
}