package com.rulhouse.callbackpractice

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(): ViewModel() {
    private val _musicPlaying = mutableStateOf(false)
    val musicPlaying: State<Boolean> = _musicPlaying

    private val musicStateListener = object: PlayMusic.MusicStateListener {
        override fun onStart() {
            _musicPlaying.value = true
        }

        override fun onFinished() {
            _musicPlaying.value = false
        }
    }

    private val playMusic = PlayMusic()

    init {
        playMusic.setMusicStateListener(musicStateListener)
    }

    fun onEvent(event: MainScreenEvent) {
        when(event) {
            MainScreenEvent.StartButton -> {
                if (!musicPlaying.value)
                    playMusic.playMusic()
            }
        }
    }
}