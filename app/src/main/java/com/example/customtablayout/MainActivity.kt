package com.example.customtablayout

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var def: ColorStateList
    lateinit var item1: TextView
    lateinit var item2: TextView
    lateinit var item3: TextView
    lateinit var select: TextView
    var fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        item1 = findViewById(R.id.item1)
        item2 = findViewById(R.id.item2)
        item3 = findViewById(R.id.item3)
        select = findViewById(R.id.select)

        //setting click listener
        item1.setOnClickListener(this)
        item2.setOnClickListener(this)
        item3.setOnClickListener(this)

       def = item2.textColors

    }

    override fun onClick(v: View?) {

        if (v!!.id == R.id.item1){
            select.animate().x(0F).setDuration(100)
            item1.setTextColor(Color.WHITE)
            item2.setTextColor(def)
            item3.setTextColor(def)

            val fragment = fragment1()

            fragmentManager.commit {

                //adding custom animation
//                setCustomAnimations(
//                    enter = R.anim.slide_in,
//                    exit = R.anim.fade_out,
//                    popEnter = R.anim.fade_in,
//                    popExit = R.anim.slide_out
//                )

                replace(R.id.fragmentContainer , fragment)
                setReorderingAllowed(true)
                    .addToBackStack("fragment1")
            }
        }else if (v!!.id == R.id.item2){
            var size: Float = item2.width.toFloat()
            select.animate().x(size).setDuration(100)
            item1.setTextColor(def)
            item2.setTextColor(Color.WHITE)
            item3.setTextColor(def)

            fragmentManager.commit {
                replace<fragment2>(R.id.fragmentContainer)
                setReorderingAllowed(true)
                    .addToBackStack("fragment2")
            }

        }else if (v!!.id == R.id.item3){

            var size: Float = item2.width.toFloat() * 2
            select.animate().x(size).setDuration(100)

            item1.setTextColor(def)
            item2.setTextColor(def)
            item3.setTextColor(Color.WHITE)

            fragmentManager.commit {
                replace<fragment3>(R.id.fragmentContainer)
                setReorderingAllowed(true)
                    .addToBackStack("fragment3")
            }

        }
    }
}