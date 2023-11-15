package com.zengjianxiong.log.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zengjianxiong.corelog.AppLogUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {


    fun test() {
        viewModelScope.launch {

            for (i in 0..100) {
                AppLogUtils.d("dddddddadfadf zfafadddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                        "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd")
            }

            withContext(Dispatchers.Default) {
                Thread{
                    for (i in 0..100) {
                        AppLogUtils.d("daafadfadddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd")
                    }
                }.start()
                Thread{
                    for (i in 0..100) {
                        AppLogUtils.d("dddddddadfadf zfafadddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                                "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd")
                    }
                }.start()
            }

        }
    }
}