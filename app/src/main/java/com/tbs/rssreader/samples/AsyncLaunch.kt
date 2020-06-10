package com.tbs.rssreader.samples

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val deferred = GlobalScope.async {
        doSomething()
    }
    deferred.join()
    deferred.await()
   /* if (deferred.isCancelled) {
        val exception = deferred.getCancellationException()
        println("Error with a message : ${exception.message}")
    } else {
        println("Success")
    }*/
    println("Completed!!")
}

fun doSomething() {
    throw UnsupportedOperationException("Can't do")
}


