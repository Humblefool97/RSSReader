package com.tbs.rssreader.samples

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


suspend fun activeState()  {
    val j = GlobalScope.launch {
        delay(3 * 1000)
    }
    j.start()
}