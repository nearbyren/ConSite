package apps.construction.site.fragment

import android.os.Bundle
import android.view.View
import apps.construction.site.R
import apps.construction.site.databinding.FragmentIndex3Binding
import apps.construction.site.dialog.SignOutDialogFragment
import apps.construction.site.http.IndexViewModel
import apps.construction.site.ui.info.AboutUsActivity
import apps.construction.site.ui.info.EditPasswordActivity
import apps.construction.site.ui.info.PrivacyPolicyActivity
import apps.construction.site.ui.info.RermsDetailsActivity
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.fragment.BaseAppBVMFragment


class IndexFragment3 : BaseAppBVMFragment<FragmentIndex3Binding, IndexViewModel>(),
    View.OnClickListener {
    override fun createViewModel(): IndexViewModel {
        return IndexViewModel()
    }

    override fun layoutRes(): Int {
        return R.layout.fragment_index_3
    }

    override fun initialize(savedInstanceState: Bundle?) {
        binding.clChangePassword.setOnClickListener(this)
        binding.clContactUs.setOnClickListener(this)
        binding.clPrivacyPolicy.setOnClickListener(this)
        binding.clTermsDetails.setOnClickListener(this)
        binding.quit.setOnClickListener(this)


    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(false)
            .setBgColor(nearby.lib.base.R.color.white)
            .setTitle(
                title = getString(R.string.menu_04),
                titleColor = nearby.lib.base.R.color.black
            ).build()
    }

    override fun onClick(view: View?) {
        view?.let {
            when (it.id) {
                R.id.cl_change_password -> {
                    navigate(EditPasswordActivity::class.java)
                }

                R.id.cl_contact_us -> {
                    navigate(AboutUsActivity::class.java)
                }

                R.id.cl_privacy_policy -> {
                    navigate(PrivacyPolicyActivity::class.java)
                }

                R.id.cl_terms_details -> {
                    navigate(RermsDetailsActivity::class.java)
                }
                R.id.quit -> {
                    val signOut = SignOutDialogFragment()
                    signOut.show(this)
                }
            }
        }

    }
}