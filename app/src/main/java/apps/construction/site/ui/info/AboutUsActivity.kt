package apps.construction.site.ui.info

import android.os.Bundle
import apps.construction.site.R
import apps.construction.site.databinding.ActivityAboutUsBinding
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.activity.BaseAppBindActivity


class AboutUsActivity : BaseAppBindActivity<ActivityAboutUsBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_about_us
    }


    override fun initialize(savedInstanceState: Bundle?) {

    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(true).setIconLeft(R.drawable.icon_black_left)
            .setBgColor(nearby.lib.base.R.color.white).setTitle(title = getString(R.string.info_13), titleColor = nearby.lib.base.R.color.black).build()
    }

}