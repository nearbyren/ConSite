package apps.construction.site.dialog

import android.os.Bundle
import android.view.View
import apps.construction.site.R
import apps.construction.site.databinding.FragmentShootingAlbumBinding
import nearby.lib.base.dialog.BaseBindDialogFragment

class ShootingAlbumDialogFragment : BaseBindDialogFragment<FragmentShootingAlbumBinding>(),
    View.OnClickListener {
    override fun getLayoutId(): Int {
        return R.layout.fragment_shooting_album
    }


    override fun initialize(view: View, savedInstanceState: Bundle?) {
        binding.clCancel.setOnClickListener(this)
        binding.shooting.setOnClickListener(this)
        binding.selectAlbum.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        view?.let {
            when (it.id) {
                R.id.cl_cancel -> {
                    dismiss()
                }
                R.id.shooting -> {
                    dismiss()
                }
                R.id.select_album -> {
                    dismiss()
                }
            }
        }
    }
}