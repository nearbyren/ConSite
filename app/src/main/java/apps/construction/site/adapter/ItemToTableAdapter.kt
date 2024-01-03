package apps.construction.site.adapter

import apps.construction.site.R
import apps.construction.site.databinding.ItemCoworkerBookBinding
import apps.construction.site.databinding.ItemToTableBinding
import apps.construction.site.model.CoworkerDto
import apps.construction.site.model.ToTableDto
import nearby.lib.uikit.recyclerview.BaseBindRecyclerAdapter


class ItemToTableAdapter : BaseBindRecyclerAdapter<ItemToTableBinding, ToTableDto>() {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_to_table
    }

    override fun onBindingItem(binding: ItemToTableBinding, item: ToTableDto, position: Int) {
        binding.date.text = "表格 $position"

    }
}