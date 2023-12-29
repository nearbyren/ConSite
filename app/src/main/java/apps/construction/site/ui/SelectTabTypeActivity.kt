package apps.construction.site.ui

import android.os.Bundle
import apps.construction.site.R
import apps.construction.site.databinding.ActivitySelectTabTyoeBinding
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.activity.BaseAppBindActivity


class SelectTabTypeActivity : BaseAppBindActivity<ActivitySelectTabTyoeBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_select_tab_tyoe
    }


    override fun initialize(savedInstanceState: Bundle?) {

    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(true).setIconLeft(R.drawable.icon_black_left)
            .setBgColor(nearby.lib.base.R.color.white).setTitle(title = getString(R.string.select_table_type), titleColor = nearby.lib.base.R.color.black).build()
    }

}