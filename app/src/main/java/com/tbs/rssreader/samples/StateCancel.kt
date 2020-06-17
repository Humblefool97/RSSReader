package com.tbs.rssreader.samples

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import java.util.concurrent.CancellationException

object StateCancel {
    @JvmStatic
    fun main(args:Array<String>) = runBlocking {
        val job = launch {
            delay(5000)
        }
        job.invokeOnCompletion { cause ->
            cause?.let {
                println("Reason ; ${it.message}")
            }
        }
        delay(2 * 1000)
        job.cancel(cause = CancellationException("Timeout!"))
    }
}