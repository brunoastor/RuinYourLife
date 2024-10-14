package com.example.ruthless

import android.content.Context
import android.media.AudioManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text

import android.media.MediaPlayer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

class MainActivity : ComponentActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mediaPlayer = MediaPlayer.create(this, R.raw.som)

        mediaPlayer?.setVolume(1.0f, 1.0f)

        //val audioManager = this.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        //val maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        //audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, 0)

        mediaPlayer?.start()

        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                Text("Reproduzindo som...")
            }
        }
    }

    override fun onResume() {
        super.onResume()

        mediaPlayer?.start()
    }

    override fun onPause() {
        super.onPause()

        mediaPlayer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Libera os recursos do MediaPlayer
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
