package com.example.exoplayertestsite

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerNotificationManager
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.play)
        val songName: TextView = findViewById(R.id.title)
        val intent = Intent(this, PlayerService::class.java)

        btn.setOnClickListener {
            startService(PlayerService.newIntent(this))
        }

        fun test() = "Hello world"

        /*btn.setOnClickListener {
            if (player.isPlaying) {
                player.stop()
                btn.text = "Play"
            } else {
                player.playWhenReady = true
                startService(intent)
                btn.text = "Stop"
                val songa = player.mediaMetadata.title
                songName.text = songa // doesn't work
            }
        }*/
    }
    override fun onResume() {
        super.onResume()
        // Start the PlayerService

    }

    override fun onDestroy() {
        super.onDestroy()
        // Stop the PlayerService
        stopService(PlayerService.newIntent(this))
    }
}