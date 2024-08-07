package com.android.base.views.container.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.base.views.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    private val _currentTime = MutableLiveData<String>()
    val currentTime: LiveData<String> = _currentTime

    private var timerJob: Job? = null

    fun startTimer(inputSeconds: Int) {
        timerJob?.cancel()

        val minutes = inputSeconds / 10
        val seconds = (inputSeconds % 10) * 10
        val totalTime = (minutes * 60) + seconds

        timerJob = viewModelScope.launch {
            for (i in totalTime downTo 0) {
                val displayMinutes = i / 60
                val displaySeconds = i % 60
                _currentTime.value = String.format("%02d:%02d", displayMinutes, displaySeconds)
                delay(1000)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }

    companion object {
        const val MIllIS_IN_FUTURE = 10000L
        const val SECONDS = 1000L
    }

}