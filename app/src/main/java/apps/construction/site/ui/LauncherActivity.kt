package apps.construction.site.ui

import android.os.Bundle
import apps.construction.site.R
import apps.construction.site.databinding.ActivityLauncherBinding
import apps.construction.site.http.IndexViewModel
import nearby.lib.mvvm.activity.BaseAppBVMActivity


class LauncherActivity : BaseAppBVMActivity<ActivityLauncherBinding, IndexViewModel>() {
    override fun createViewModel(): IndexViewModel {
        return IndexViewModel()
    }


    override fun layoutRes(): Int {
        return R.layout.activity_launcher
    }


    override fun initialize(savedInstanceState: Bundle?) {
        viewModel.start()
        viewModel.start.observe(this) {
            if (it) {
                navigate(LoginActivity::class.java)
                finishPage(LauncherActivity@ this)
            }
        }
        intent?.let {
            println("MessagingService intent")
            println("MessagingService ${it.getStringExtra("key1")} - ${it.getStringExtra("key2")}")
        }
    }

}