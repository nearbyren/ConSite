package apps.construction.site.http

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay
import nearby.lib.mvvm.vm.BaseAppViewModel


class IndexViewModel : BaseAppViewModel() {

    val start = MutableLiveData<Boolean>()
    fun start() {
        launchOnUI {
            delay(2000)
            start.value = true
        }
    }

}