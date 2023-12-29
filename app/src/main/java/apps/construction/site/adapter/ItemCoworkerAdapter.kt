package apps.construction.site.adapter

import androidx.core.content.ContextCompat
import apps.construction.site.R
import apps.construction.site.databinding.ItemCoworkerBookBinding
import apps.construction.site.databinding.ItemSwitchProjectBinding
import apps.construction.site.dialog.SignOutDialogFragment
import apps.construction.site.model.CoworkerDto
import apps.construction.site.model.SwitchDto
import nearby.lib.uikit.recyclerview.BaseBindRecyclerAdapter


class ItemCoworkerAdapter : BaseBindRecyclerAdapter<ItemCoworkerBookBinding, CoworkerDto>() {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_coworker_book
    }

    override fun onBindingItem(binding: ItemCoworkerBookBinding, item: CoworkerDto, position: Int) {

    }
}