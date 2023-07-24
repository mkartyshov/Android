package com.mkartyshov.alarmtestsite

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.PRIORITY_DEFAULT
import androidx.core.app.NotificationCompat.PRIORITY_MIN
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource

class MusicService: Service() {
    private lateinit var ep: ExoPlayer

    override fun onCreate() {
        super.onCreate()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Start the service in the foreground with a notification
        ep = ExoPlayer.Builder(this).build()
        createNotification()

        // Set up the player
//        val dataSource = DefaultHttpDataSource.Factory()
  //      val stream = MediaItem.fromUri("https://nashe1.hostingradio.ru:80/nashe-64.mp3")
    //    val mediaSource = ProgressiveMediaSource.Factory(dataSource).createMediaSource(stream)

        val mediaItem = MediaItem.fromUri("https://nashe1.hostingradio.ru:80/nashe-64.mp3")

        ep.setMediaItem(mediaItem)
        ep.setWakeMode(C.WAKE_MODE_NETWORK)
        ep.playWhenReady = true
        ep.prepare()

        startService(intent)

        return START_STICKY
    }

    private fun createNotification() {
        val channelId =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel("my_service", "My Background Service")
            } else {
                ""
            }

        val notificationBuilder = NotificationCompat.Builder(this, channelId)

        val notification = notificationBuilder.setOngoing(true)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setPriority(PRIORITY_DEFAULT)
            .setCategory(Notification.CATEGORY_SERVICE)
            .setSilent(true)
            .setOnlyAlertOnce(true)
            .build()

        startForeground(1, notification)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(channelId: String, channelName: String): String {
        val chan = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
        chan.lightColor = Color.BLUE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        service.createNotificationChannel(chan)
        return channelId
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MusicService::class.java)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        ep.stop()
        ep.release()
    }
}