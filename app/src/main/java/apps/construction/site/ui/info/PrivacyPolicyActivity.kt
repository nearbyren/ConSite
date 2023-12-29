package apps.construction.site.ui.info

import android.os.Bundle
import apps.construction.site.R
import apps.construction.site.databinding.ActivityPrivacyPolicyBinding
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.activity.BaseAppBindActivity


class PrivacyPolicyActivity : BaseAppBindActivity<ActivityPrivacyPolicyBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_privacy_policy
    }


    override fun initialize(savedInstanceState: Bundle?) {
    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(true).setIconLeft(R.drawable.icon_black_left)
            .setBgColor(nearby.lib.base.R.color.white).setTitle(title = getString(R.string.info_15), titleColor = nearby.lib.base.R.color.black).build()
    }

}