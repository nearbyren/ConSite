package nearby.lib.uikit.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import nearby.lib.uikit.widgets.singleClick

/**
 * @description: 基于DataBinding的RecyclerView Adapter封装
 * @since: 1.0.0
 */
abstract class BaseBindRecyclerAdapter<B : ViewDataBinding, T> : BaseRecyclerAdapter<T>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding: B = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            getLayoutId(viewType),
            parent,
            false
        )
        context = parent.context
        return BaseViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        onBindItem(holder, getItems()!![position], position)
    }

    override fun onBindItem(holder: BaseViewHolder, item: T, position: Int) {
        val binding: B = DataBindingUtil.getBinding(holder.itemView)!!
        onBindingItem(binding, getItems()!![position], position)
        binding.executePendingBindings()
        getItemClickListener()?.let { listener ->
            holder.itemView.singleClick {
                listener.onItemClick(
                    binding,
                    getItems()!![position],
                    position
                )
            }
        }
    }

    abstract fun onBindingItem(binding: B, item: T, position: Int)
}