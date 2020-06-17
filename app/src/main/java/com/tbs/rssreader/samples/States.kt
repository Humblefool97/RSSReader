package com.tbs.rssreader.samples

import kotlinx.coroutines.*

object States {
    @JvmStatic
    fun main(args: Array<String>) {
        printStates()
    }

    fun printStates() = runBlocking {
        val job = launch {
            delay( 5 *1000)
        }

        println(getState(job))
        job.start()
        println(getState(job))
        delay(2 * 1000)
        job.cancel()
        println(getState(job))
    }

    private fun getState(job: Job) : String = when {
        job.isActive -> "Active"
        job.isCancelled -> "Cancelled"
        job.isCompleted -> "Completed"
        else -> {
            "Invalid!"
        }
    }
}