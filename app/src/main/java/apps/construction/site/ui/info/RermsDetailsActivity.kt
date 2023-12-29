package apps.construction.site.ui.info

import android.os.Bundle
import apps.construction.site.R
import apps.construction.site.databinding.ActivityRermsDetailsBinding
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.activity.BaseAppBindActivity


class RermsDetailsActivity : BaseAppBindActivity<ActivityRermsDetailsBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_rerms_details
    }


    override fun initialize(savedInstanceState: Bundle?) {
    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(true).setIconLeft(R.drawable.icon_black_left)
            .setBgColor(nearby.lib.base.R.color.white).setTitle(title = getString(R.string.info_14), titleColor = nearby.lib.base.R.color.black).build()
    }

}