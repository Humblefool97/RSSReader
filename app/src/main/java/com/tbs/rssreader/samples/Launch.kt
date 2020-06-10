package com.tbs.rssreader.samples

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.UnsupportedOperationException

fun main() = runBlocking {
    val task = GlobalScope.launch {
        doSomethingNaughty()
    }
    task.join()
    println("Completed!")
}

fun doSomethingNaughty() {
    throw UnsupportedOperationException("Can't do")
}