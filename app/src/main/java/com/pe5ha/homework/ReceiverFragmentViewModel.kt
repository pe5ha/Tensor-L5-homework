package com.pe5ha.homework

import android.graphics.Typeface
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReceiverFragmentViewModel : ViewModel() {
    val messageTextMutableLiveData = MutableLiveData<String>()
    val messageTextStyleMLD = MutableLiveData<Int>(Typeface.BOLD)
}