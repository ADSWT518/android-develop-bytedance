package me.adswt518.camera

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.hardware.Camera
import android.media.CamcorderProfile
import android.media.MediaMetadataRetriever
import android.media.MediaRecorder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import java.text.SimpleDateFormat
import java.util.*

import android.widget.ImageView
import android.view.MotionEvent

import android.view.View.OnTouchListener
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.util.Log

import android.media.ExifInterface
import android.widget.EditText
import android.widget.TextView
import java.io.*
import java.nio.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    companion object {
        private const val REQUEST_PERMISSIONS = 1
        private const val MEDIA_TYPE_IMAGE = 2
        private const val MEDIA_TYPE_VIDEO = 3
        private const val CAMERA_FACING_FRONT = 4
        private const val CAMERA_FACING_BACK = 5
    }

    private var mSurfaceView: SurfaceView? = null
    private var mSurfaceHolder: SurfaceHolder? = null
    private var mCamera: Camera? = null
    private var mMediaRecorder: MediaRecorder? = null
    private var mFilename: EditText? = null
    private var mDetailInfo: TextView? = null
    private var mShowLastImg: ImageView? = null
    private var mIsRecording = false
    private var cameraId = CAMERA_FACING_BACK


    @SuppressLint("CutPasteId", "ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check permission
        if (!checkPermissionAndStartRecord()) {
            if ((ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                        != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.CAMERA
                )
                        != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.RECORD_AUDIO
                )
                        != PackageManager.PERMISSION_GRANTED)
            ) {
                ActivityCompat.requestPermissions(
                    this@MainActivity, arrayOf(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.RECORD_AUDIO
                    ),
                    REQUEST_PERMISSIONS
                )
            }
        }

        mSurfaceView = findViewById(R.id.surface_view)
        startCamera()

        var startTime: Long = 0
        val longClickDuration = 1000 // for long click to trigger after 1 seconds

        val shutter = findViewById<View>(R.id.shutter) as ImageView
        val flipCamera = findViewById<View>(R.id.flip_camera)
        mFilename = findViewById(R.id.filename)
        mDetailInfo = findViewById(R.id.detailInfo)
        mShowLastImg = findViewById(R.id.album)
        loadLastImgOrVideo()
        shutter.setOnTouchListener(OnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> startTime = System.currentTimeMillis()
                MotionEvent.ACTION_MOVE -> if (!mIsRecording && System.currentTimeMillis() - startTime > longClickDuration) {
                    /* Implement long click behavior here */
                    Toast.makeText(applicationContext, "Recording video", Toast.LENGTH_LONG).show()
                    println("Long Click has happened!")
                    recordVideo()
                    return@OnTouchListener false
                }
                MotionEvent.ACTION_UP -> if (System.currentTimeMillis() - startTime > longClickDuration) {
                    /* Implement long click behavior here */
                    println("Long Click has happened!")
                    if (mIsRecording) {
                        Toast.makeText(
                            applicationContext,
                            "Stop recording video",
                            Toast.LENGTH_SHORT
                        ).show()
                        mMediaRecorder!!.stop()
                        releaseMediaRecorder()
                        mCamera!!.lock()
                        mIsRecording = false
                        loadLastImgOrVideo()
                    }
                    return@OnTouchListener false
                } else {
                    /* Implement short click behavior here or do nothing */
                    println("Short Click has happened...")
                    Toast.makeText(applicationContext, "Taking picture", Toast.LENGTH_SHORT).show()
                    takePicture()
                    return@OnTouchListener true
                }
            }
            true
        })

        flipCamera.setOnClickListener {
//            println(Camera.getNumberOfCameras())
            mCamera!!.stopPreview()
            releaseCamera()
            when (cameraId) {
                CAMERA_FACING_BACK -> {
                    cameraId = CAMERA_FACING_FRONT
                    mCamera = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT)
                }
                CAMERA_FACING_FRONT -> {
                    cameraId = CAMERA_FACING_BACK
                    mCamera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK)
                }
            }
            setCameraDisplayOrientation()
            mCamera!!.setPreviewDisplay(mSurfaceHolder)
            mCamera!!.startPreview()
        }
    }

    // Check permission
    private fun checkPermissionAndStartRecord(): Boolean {
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) && (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            )
                    == PackageManager.PERMISSION_GRANTED) && (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO
            )
                    == PackageManager.PERMISSION_GRANTED)
        ) {
            return true
        }
        return false
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            checkPermissionAndStartRecord()
        }
    }

    private fun startCamera() {
        try {
            when (cameraId) {
                CAMERA_FACING_FRONT -> mCamera = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT)
                CAMERA_FACING_BACK -> mCamera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK)
            }
            setCameraDisplayOrientation()
        } catch (e: Exception) {
            // error
        }
        mSurfaceHolder = mSurfaceView!!.holder
        mSurfaceHolder?.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {
                try {
                    /**
                     *   补充完整缺失代码 C1
                     */
                    mCamera?.setPreviewDisplay(holder)
                    mCamera?.startPreview()
                } catch (e: IOException) {
                    // error
                }
            }

            override fun surfaceChanged(holder: SurfaceHolder, i: Int, i1: Int, i2: Int) {
                try {
                    mCamera!!.stopPreview()
                } catch (e: Exception) {
                    // error
                }
                try {
                    mCamera!!.setPreviewDisplay(holder)
                    mCamera!!.startPreview()
                } catch (e: Exception) {
                    //error
                }
            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {}
        })
    }

    private fun setCameraDisplayOrientation() {
        // info.orientation always returns 90 (CAMERA_FACING_BACK) or 270 (CAMERA_FACING_FRONT) on my Huawei P30
        // Reference: https://stackoverflow.com/questions/13103070/is-the-setdisplayorientation-sample-code-correct
        val rotation = windowManager.defaultDisplay.rotation
        var degrees = 0
        println("rotation: $rotation")
        when (rotation) {
            Surface.ROTATION_0 -> degrees = 0
            Surface.ROTATION_90 -> degrees = 90
            Surface.ROTATION_180 -> degrees = 180
            Surface.ROTATION_270 -> degrees = 270
        }

        val info = Camera.CameraInfo()
        when (cameraId) {
            CAMERA_FACING_BACK -> Camera.getCameraInfo(Camera.CameraInfo.CAMERA_FACING_BACK, info)
            CAMERA_FACING_FRONT -> {
                degrees += 180
                Camera.getCameraInfo(Camera.CameraInfo.CAMERA_FACING_FRONT, info)
            }
        }

        val result = (info.orientation - degrees + 360) % 360

        println("rotation: $rotation, degrees: $degrees, result: $result")
        mCamera!!.setDisplayOrientation(result)
    }

    /**
     *
     * Get the orientation from EXIF
     * @param filepath
     * @return orientation
     */
    fun getExifOrientation(filepath: String?): Int {
        var degree = 0
        var exif: ExifInterface? = null
        try {
            exif = ExifInterface(filepath!!)
        } catch (ex: IOException) {
            Log.e("EXIF info", "cannot read exif", ex)
        }
        if (exif != null) {
            val orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1)
            if (orientation != -1) {
                // We only recognize a subset of orientation tag values.
                when (orientation) {
                    ExifInterface.ORIENTATION_ROTATE_90 -> degree = 90
                    ExifInterface.ORIENTATION_ROTATE_180 -> degree = 180
                    ExifInterface.ORIENTATION_ROTATE_270 -> degree = 270
                }
            }
        } else {
            degree = 1
        }
        Log.i("EXIF info", "Orientation degrees: $degree")
        return degree
    }

    private fun takePicture() {
        mCamera!!.takePicture(null, null, Camera.PictureCallback { bytes, camera ->
            val pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE) ?: return@PictureCallback
            try {
                /**
                 *   补充完整缺失代码 C2
                 */
                val fos = FileOutputStream(pictureFile)
                fos.write(bytes)
                fos.close()
                loadLastImgOrVideo()
            } catch (e: FileNotFoundException) {
                //error
            } catch (e: IOException) {
                //error
            }
            mCamera!!.startPreview()
        })
    }

    @SuppressLint("SimpleDateFormat")
    private fun getOutputMediaFile(type: Int): File? {
        // Android/data/me.adswt518.camera/files/Pictures
        val mediaStorageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        if (!mediaStorageDir!!.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null
            }
        }
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        println("text:${mFilename?.text}")
        return when (type) {
            MEDIA_TYPE_IMAGE -> {
                when (mFilename?.text.toString()) {
                    "" -> File(mediaStorageDir.path + File.separator + "IMG_" + timeStamp + ".jpg")
                    else -> File(mediaStorageDir.path + File.separator + mFilename?.text + ".jpg")
                }
            }
            MEDIA_TYPE_VIDEO -> {
                when (mFilename?.text.toString()) {
                    "" -> File(mediaStorageDir.path + File.separator + "VID_" + timeStamp + ".mp4")
                    else -> File(mediaStorageDir.path + File.separator + mFilename?.text + ".mp4")
                }
            }
            else -> {
                return null
            }
        }
    }

    private fun prepareVideoRecorder(): Boolean {
        mMediaRecorder = MediaRecorder()
        mCamera!!.unlock()
        mMediaRecorder!!.setCamera(mCamera)
        mMediaRecorder!!.setAudioSource(MediaRecorder.AudioSource.CAMCORDER)
        mMediaRecorder!!.setVideoSource(MediaRecorder.VideoSource.CAMERA)
        mMediaRecorder!!.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH))
        mMediaRecorder!!.setOutputFile(getOutputMediaFile(MEDIA_TYPE_VIDEO).toString())
        mMediaRecorder!!.setPreviewDisplay(mSurfaceHolder!!.surface)
        try {
            mMediaRecorder!!.prepare()
        } catch (e: IllegalStateException) {
            releaseMediaRecorder()
            return false
        } catch (e: IOException) {
            releaseMediaRecorder()
            return false
        }
        return true
    }

    private fun recordVideo() {
        if (mIsRecording) {
            mMediaRecorder!!.stop()
            releaseMediaRecorder()
            mCamera!!.lock()
            mIsRecording = false
        } else {
            if (prepareVideoRecorder()) {
                mMediaRecorder!!.start()
                mIsRecording = true
            } else {
                releaseMediaRecorder()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseMediaRecorder()
        releaseCamera()
    }

    private fun releaseMediaRecorder() {
        if (mMediaRecorder != null) {
            mMediaRecorder!!.reset()
            mMediaRecorder!!.release()
            mMediaRecorder = null
            mCamera!!.lock()
        }
    }

    private fun releaseCamera() {
        if (mCamera != null) {
            mCamera!!.release()
            mCamera = null
        }
    }

    private fun loadLastImgOrVideo() {

        val mediaStorageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        if (!mediaStorageDir!!.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.e("camera", "mkdir error")
                return
            }
        }

        var lastModifiedTime: Long = 0
        var lastImg: File? = null

        for (file: File in mediaStorageDir.listFiles()) {
            if (file.lastModified() > lastModifiedTime) {
                lastModifiedTime = file.lastModified()
                lastImg = file
            }
        }

        val fileName: String = lastImg?.name ?: "noFiles"
        var bitmap: Bitmap = Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888)
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = false
        options.inSampleSize = 1

        if (lastImg != null) {
            if (fileName.substring(fileName.length - 4, fileName.length) == ".jpg") {
                bitmap = BitmapFactory.decodeFile(lastImg.absolutePath, options)
            } else if (fileName.substring(fileName.length - 4, fileName.length) == ".mp4") {
                val lastVideo = MediaMetadataRetriever()
                lastVideo.setDataSource(lastImg.absolutePath)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                    bitmap = lastVideo.getScaledFrameAtTime(
                        -1,
                        MediaMetadataRetriever.OPTION_CLOSEST,
                        mShowLastImg!!.width,
                        mShowLastImg!!.height
                    )!!
                }
            }
            val fis = FileInputStream(lastImg)
            val fileSize = getNetFileSizeDescription(fis.channel.size())
            mDetailInfo?.text = fileName + '\n' + fileSize
        }

        mShowLastImg?.setImageBitmap(bitmap)
    }


    private fun getNetFileSizeDescription(size: Long): String {
        val bytes = StringBuffer()
        val format = DecimalFormat("###.0")
        if (size >= 1024 * 1024 * 1024) {
            val i = size / (1024.0 * 1024.0 * 1024.0)
            bytes.append(format.format(i)).append("GB")
        } else if (size >= 1024 * 1024) {
            val i = size / (1024.0 * 1024.0)
            bytes.append(format.format(i)).append("MB")
        } else if (size >= 1024) {
            val i = size / 1024.0
            bytes.append(format.format(i)).append("KB")
        } else if (size < 1024) {
            if (size <= 0) {
                bytes.append("0B")
            } else {
                bytes.append(size.toInt()).append("B")
            }
        }
        return bytes.toString()
    }

}