package apps.construction.site.ui

import android.os.Bundle
import apps.construction.site.R
import apps.construction.site.databinding.ActivityNotifyDetailBinding
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.activity.BaseAppBindActivity


class NotifyDetailActivity : BaseAppBindActivity<ActivityNotifyDetailBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_notify_detail
    }


    override fun initialize(savedInstanceState: Bundle?) {

    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(true).setIconLeft(R.drawable.icon_black_left)
            .setBgColor(nearby.lib.base.R.color.white).setTitle(title = getString(R.string.notify_detail), titleColor = nearby.lib.base.R.color.black).build()
    }

}