package apps.construction.site.adapter

import apps.construction.site.R
import apps.construction.site.databinding.ItemChooseToTableBinding
import apps.construction.site.databinding.ItemCoworkerBookBinding
import apps.construction.site.databinding.ItemToTableBinding
import apps.construction.site.model.ChooseToTableDto
import apps.construction.site.model.CoworkerDto
import apps.construction.site.model.ToTableDto
import nearby.lib.uikit.recyclerview.BaseBindRecyclerAdapter


class ItemChooseToTableAdapter :
    BaseBindRecyclerAdapter<ItemChooseToTableBinding, ChooseToTableDto>() {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_choose_to_table
    }

    override fun onBindingItem(
        binding: ItemChooseToTableBinding,
        item: ChooseToTableDto,
        position: Int
    ) {
        binding.name.text = item.name

    }
}