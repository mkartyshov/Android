package com.mkartyshov.alarmtestsite

import android.app.*
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.PRIORITY_DEFAULT
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class MusicService: Service() {
    private lateinit var ep: ExoPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Start the service in the foreground with a notification
        val notification = createNotification()
        startForeground(1, notification)

        ep = ExoPlayer.Builder(this).build()

        val mediaItem = MediaItem.fromUri("https://nashe1.hostingradio.ru:80/nashe-64.mp3")

        ep.setMediaItem(mediaItem)
        ep.setWakeMode(C.WAKE_MODE_NETWORK)
        ep.playWhenReady = true
        ep.prepare()

        return START_STICKY
    }

    private fun createNotification(): Notification {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "alarm_radio_channel",
                "Alarm Radio Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(channel)
        }

        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            action = Intent.ACTION_MAIN
        }

        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        return NotificationCompat.Builder(this, "alarm_radio_channel")
            .setContentTitle("Test")
            .setContentText("test")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(PRIORITY_DEFAULT)
            .setSilent(true)
            .setContentIntent(pendingIntent)
            .build()
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