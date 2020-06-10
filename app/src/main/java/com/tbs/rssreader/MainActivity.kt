package com.tbs.rssreader

import android.os.Bundle
import android.provider.Contacts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_main.*
import kotlinx.coroutines.*
import org.w3c.dom.Element
import org.w3c.dom.Node
import javax.xml.parsers.DocumentBuilderFactory


class MainActivity : AppCompatActivity() {
    private val netDispatcher = newSingleThreadContext("ServiceCall")
    private val factory = DocumentBuilderFactory.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
        asyncLoadNews()
    }

    private fun asyncLoadNews(dispatcher:CoroutineDispatcher = netDispatcher) {
        GlobalScope.launch(dispatcher) {
            val headlines = fetchRssHeadlines()
            launch(Dispatchers.Main) {
                newsCount.text = "Found ${headlines.size} articles"
            }
        }
    }

    private fun fetchRssHeadlines(): List<String> {
        val builder = factory.newDocumentBuilder()
        val xml = builder.parse("https://www.npr.org/rss/rss.php?id=1001")
        val news = xml.getElementsByTagName("channel").item(0)
        return (0 until news.childNodes.length)
            .map { news.childNodes.item(it) }
            .filter { Node.ELEMENT_NODE == it.nodeType }
            .map { it as Element }
            .filter { "item" == it.tagName }
            .map {
                it.getElementsByTagName("title").item(0).textContent
            }
    }
}