package com.rulhouse.callbackpractice

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            val stateText = if (viewModel.musicPlaying.value) "Playing"
                else "Not playing"
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = stateText
            )
            if (!viewModel.musicPlaying.value)
                Button(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    onClick = {
                    viewModel.onEvent(MainScreenEvent.StartButton)
                }) {
                    Text(text = "Play")
                }
            if (viewModel.musicPlaying.value)
                CircularProgressIndicator(
                    modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                )
        }
    }
}