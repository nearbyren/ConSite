package apps.construction.site.dialog

import android.os.Bundle
import android.view.View
import apps.construction.site.R
import apps.construction.site.databinding.FragmentSignOutBinding
import nearby.lib.base.dialog.BaseBindDialogFragment
import nearby.lib.base.uitl.AppManager

class SignOutDialogFragment : BaseBindDialogFragment<FragmentSignOutBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_sign_out
    }

    override fun initialize(view: View, savedInstanceState: Bundle?) {
        binding.confirm.setOnClickListener {
            AppManager.getInstance().finishActivity()
            dismiss()
        }
        binding.cancel.setOnClickListener { dismiss() }
    }
}