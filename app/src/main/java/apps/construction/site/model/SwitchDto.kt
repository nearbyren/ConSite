package apps.construction.site.model

import apps.construction.site.R

/**
 * @author: lr
 * @created on: 2023/12/18 9:45 PM
 * @description:
 */
data class SwitchDto(
    var text: String,
    var icon: Int = R.drawable.ic_gou,
    var bol: Boolean = false
)
