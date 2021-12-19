package me.adswt518.image_and_video

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.io.File
import java.util.ArrayList

class ImageActivity : AppCompatActivity() {

    private val pages: MutableList<View> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_image)
        addImage("res:/" + R.drawable.drawableimage)
        val sdcardUri = Uri.fromFile(File("/sdcard/fileimage.jpg")) // For files on device
        addImage(sdcardUri)
        addImage("asset:/assetsimage.jpg")
        addRawImage(R.raw.rawimage)
        addImage("https://t7.baidu.com/it/u=4162611394,4275913936&fm=193&f=GIF")
        val adapter = ViewAdapter()
        adapter.setDatas(pages)
        view_pager.adapter = adapter
    }

    private fun addImage(uri: Uri) {
        val imageView = layoutInflater.inflate(R.layout.activity_fresco_item, null) as SimpleDraweeView
        imageView.setImageURI(uri)
        imageView.hierarchy.actualImageScaleType = ScalingUtils.ScaleType.FIT_CENTER
        pages.add(imageView)
    }

    private fun addImage(path: String) {
        addImage(Uri.parse(path))
    }

    private fun addRawImage(resId: Int) {
        val imageRequest = ImageRequestBuilder.newBuilderWithResourceId(resId).build()
        val controller: DraweeController = Fresco.newDraweeControllerBuilder()
            .setUri(imageRequest.sourceUri)
            .setAutoPlayAnimations(true)
            .build()
        val imageView = layoutInflater.inflate(R.layout.activity_fresco_item, null) as SimpleDraweeView
        imageView.hierarchy.actualImageScaleType = ScalingUtils.ScaleType.FIT_CENTER
        imageView.controller = controller
        pages.add(imageView)
    }
}
