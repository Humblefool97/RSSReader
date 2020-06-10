package com.tbs.rssreader.samples

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking


fun main() = runBlocking{
    val task = GlobalScope.launch(newSingleThreadContext("ServiceCall")) {
        printCurrentThread()
    }
    task.join()

}

fun printCurrentThread(){
    println(Thread.currentThread().name)
}