package apps.construction.site.adapter

import apps.construction.site.R
import apps.construction.site.databinding.ItemNotifyMessageBinding
import apps.construction.site.model.MenuDto
import nearby.lib.uikit.recyclerview.BaseBindRecyclerAdapter


class ItemNotifyMessageAdapter : BaseBindRecyclerAdapter<ItemNotifyMessageBinding, MenuDto>() {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_notify_message
    }

    override fun onBindingItem(binding: ItemNotifyMessageBinding, item: MenuDto, position: Int) {
    }
}