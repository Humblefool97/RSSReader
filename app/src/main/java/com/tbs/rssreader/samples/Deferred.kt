package com.tbs.rssreader.samples

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

object Deferred {
    @JvmStatic
    fun main(args: Array<String>) {
        runDeferred()
    }

    fun runDeferred() = runBlocking {
        val deferred = async {
            delay(3 * 1000)
            getResponse()
        }

        println(deferred.await())
    }

    private fun getResponse():Int  = 200
}