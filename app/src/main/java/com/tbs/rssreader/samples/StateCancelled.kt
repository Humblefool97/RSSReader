package com.tbs.rssreader.samples

import android.util.Log
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

object StateCancelled {
    @JvmStatic
    fun main(arg:Array<String>){
       something()
    }

    fun something() = runBlocking {
        val job = launch {
            delay(5 * 1000)
        }
        delay(2 * 1000)
        job.cancel(cause = CancellationException("Timeout@"))

       println(job.isCancelled)
    }
}