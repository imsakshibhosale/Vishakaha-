package com.example.demo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs



@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            intit()
            setUpTransformer()




        viewPager2.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable,2000)

            }

        })
        val myTextView = findViewById<TextView>(R.id.myTextView)

        // Set the text with line breaks dynamically
        val dynamicText = "Location:\nCarpet-Area:\n Price"
        myTextView.text = dynamicText


        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(this)

        propertylist=ArrayList()


        propertylist.add(Property(R.drawable.house, name = "first house"))
        propertylist.add(Property(R.drawable.house3, name = "third house"))
        propertylist.add(Property(R.drawable.house4, name = "fourth house"))
        propertylist.add(Property(R.drawable.house5, name = "fifth house"))

        propertyAdapter = Property_Adapter(propertylist)
        recyclerView.adapter=propertyAdapter

    }

    override fun onPause(){
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override  fun onResume(){
        super.onResume()
        handler.postDelayed(runnable,2000)
    }

    private val runnable =Runnable{
        viewPager2.currentItem= viewPager2.currentItem + 1
    }

    private fun setUpTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - kotlin.math.abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }
        viewPager2.setPageTransformer(transformer)
    }





    fun intit() {
        viewPager2=findViewById(R.id.viewpager2)
        handler = Handler(Looper.getMainLooper()!!)
        imageList= ArrayList()
        imageList.add(R.drawable.house)
        imageList.add(R.drawable.house3)
        imageList.add(R.drawable.house4)
        imageList.add(R.drawable.house5)
        imageAdapter = ImageAdapter(imageList, viewPager2)
        viewPager2.adapter =imageAdapter
        viewPager2.offscreenPageLimit =3
        viewPager2.clipToPadding =false
        viewPager2.clipChildren=false
        viewPager2.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER

    }




    }
}

