package me.adswt518.image_and_video

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import me.adswt518.image_and_video.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {

    private val pages: MutableList<View> = ArrayList()
    private lateinit var binding: ActivityImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        addImage("https://wx4.sinaimg.cn/large/006nWT84ly1fcux1o6vxvj303w046747.jpg")
        addImage("https://wx1.sinaimg.cn/large/006nWT84ly1fcux1oakmqj303w046t8k.jpg")
        addImage("https://wx3.sinaimg.cn/large/006nWT84ly1fcux1og198j303w046t8k.jpg")
        addImage("https://pic.greenxf.com/Soft/UploadPic/2019-05/031306292948667.gif")
        addImage("https://n.sinaimg.cn/sinacn20116/102/w422h480/20190419/a79e-hvvuiyn2175537.gif")
        
        val adapter = ViewAdapter()
        adapter.setDatas(pages)
        binding.viewPager.adapter = adapter
    }

    private fun addImage(path: String) {
        val imageView = layoutInflater.inflate(R.layout.activity_image_item, null) as ImageView
        Glide.with(this)
            .load(path)
            .apply(RequestOptions().circleCrop().diskCacheStrategy(DiskCacheStrategy.ALL))
            .error(R.drawable.error)
            .into(imageView)
        pages.add(imageView)
    }
}
