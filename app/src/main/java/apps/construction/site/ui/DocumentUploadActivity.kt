package apps.construction.site.ui

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.Gravity
import android.view.View
import apps.construction.site.R
import apps.construction.site.databinding.ActivityDocumentUploadBinding
import apps.construction.site.dialog.ShootingAlbumDialogFragment
import apps.construction.site.uitl.ConstantUtil
import com.bumptech.glide.Glide
import com.zhihu.matisse.Matisse
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.activity.BaseAppBindActivity
import nearby.lib.uikit.widgets.dpToPx
import java.io.File
import java.util.Calendar


class DocumentUploadActivity : BaseAppBindActivity<ActivityDocumentUploadBinding>(),
    View.OnClickListener {

    private var matisseType = 1
    private var dateType = 1

    override fun layoutRes(): Int {
        return R.layout.activity_document_upload
    }


    override fun initialize(savedInstanceState: Bundle?) {
        binding.clRegisterDate.setOnClickListener(this)
        binding.clExpiryDate.setOnClickListener(this)
        binding.ivWork1.setOnClickListener(this)
        binding.ivWork2.setOnClickListener(this)
        binding.button.setOnClickListener(this)

    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(true).setIconLeft(R.drawable.icon_black_left)
            .setBgColor(nearby.lib.base.R.color.white).setTitle(
                title = getString(R.string.document_upload),
                titleColor = nearby.lib.base.R.color.black
            ).build()
    }

    override fun onClick(view: View?) {
        view?.let {
            when (view.id) {
                R.id.cl_register_date -> {
                    dateType = 1
                    toTimePickerDialog()
                }

                R.id.cl_expiry_date -> {
                    dateType = 2
                    toTimePickerDialog()
                }

                R.id.iv_work1 -> {
                    matisseType = 1
                    toMatisse()

                }

                R.id.iv_work2 -> {
                    matisseType = 2
                    toMatisse()
                }

                R.id.button -> {
                    val bitmap = binding.signature.saveSignature()
                    bitmap?.let { bitmap ->
                        binding.ivWork1.setImageBitmap(bitmap)
                        binding.ivWork2.setImageBitmap(bitmap)
                    }
                }

                else -> {}
            }
        }
    }

    private fun toTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val timePickerDialog =
            DatePickerDialog(this, { p0, p1, p2, p3 ->
                println("p0 = $p0 - 年 = $p1 月 = $p2 日 = $p3")
                if (dateType == 1) {
                    binding.registerDateText.text = "$p1/$p2/$p3"
                } else {
                    binding.expiryDateText.text = "$p1/$p2/$p3"
                }

            }, hour, month, day)
        timePickerDialog.show();
    }


    private fun toMatisse() {
        val signOut = ShootingAlbumDialogFragment()
        signOut.setGravity(Gravity.BOTTOM)
        signOut.show(this)

//        Matisse.from(this)
//            .choose(MimeType.ofImage())
//            .countable(true)
//            .maxSelectable(1)
//            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
//            .thumbnailScale(0.85f)
//            .imageEngine(GlideEngine())
//            .showPreview(false) // Default is `true`
//            .capture(true)
//            .captureStrategy(CaptureStrategy(true, "PhotoPicker"))
//            .forResult(ConstantUtil.ALBUM_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (ConstantUtil.ALBUM_REQUEST_CODE == requestCode && resultCode == RESULT_OK) {
            data?.let {
                val photoPath = Matisse.obtainPathResult(it)[0]
                photoPath?.let { photoPath ->
                    val f = File(photoPath)
                    if (matisseType == 1) {
                        Glide.with(this).load(f).into(binding.ivWork1)
                    } else {
                        Glide.with(this).load(f).into(binding.ivWork2)
                    }

                }
            }
        }
    }
}