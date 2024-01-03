package apps.construction.site.adapter

import apps.construction.site.R
import apps.construction.site.databinding.ItemFileDirectoryBinding
import apps.construction.site.databinding.ItemToTableBinding
import apps.construction.site.model.FileDirectoryDto
import apps.construction.site.model.ToTableDto
import nearby.lib.uikit.recyclerview.BaseBindRecyclerAdapter


class ItemFileDirectoryAdapter : BaseBindRecyclerAdapter<ItemFileDirectoryBinding, FileDirectoryDto>() {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_file_directory
    }

    override fun onBindingItem(binding: ItemFileDirectoryBinding, item: FileDirectoryDto, position: Int) {
        binding.date.text = "文件目錄 $position"
    }
}