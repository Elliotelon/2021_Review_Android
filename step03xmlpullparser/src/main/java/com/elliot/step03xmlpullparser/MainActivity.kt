package com.elliot.step03xmlpullparser

import android.os.Bundle
import android.util.Log
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {

            // creating a user list string hash map arraylist
            val userList = ArrayList<HashMap<String, String?>>()

            // creating a user string hashmap
            var user = HashMap<String, String?>()

            // declaring the list view from the layout file
            val lv = findViewById<ListView>(R.id.user_list)

            // input stream the userdetails.xml file
            val istream = assets.open("userdetails.xml")

            //creating a XmlPull parse Factory instance
            val parserFactory = XmlPullParserFactory.newInstance()
            val parser = parserFactory.newPullParser()

            // setting the namespaces feature to false
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)

            // setting the input to the parser
            parser.setInput(istream, null)

            // working with the input stream
            var tag: String? = ""
            var text: String? = ""
            var event = parser.eventType
            while (event != XmlPullParser.END_DOCUMENT) {
                tag = parser.name
                when (event) {
                    XmlPullParser.START_TAG -> if (tag == "user") user = HashMap()
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when (tag) {
                        "name" -> user["name"] = text
                        "designation" -> user["designation"] = text
                        "user" -> userList.add(user)
                    }
                }
                event = parser.next()
            }

            // List Adapter to broadcast the information to the list_rows.xml file
            val adapter: ListAdapter = SimpleAdapter(this, userList, R.layout.list_row,
                arrayOf("name", "designation"), intArrayOf(R.id.name, R.id.designation)
            )
            lv.adapter = adapter
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        }
    }
}