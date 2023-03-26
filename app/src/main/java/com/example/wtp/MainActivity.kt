package com.example.wtp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.wtp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var buildingClass: ActivityMainBinding

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        buildingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(buildingClass.root)


        lateinit var timer : CountDownTimer
        timer = object : CountDownTimer(1_200, 1_000) {
            override fun onTick(remain: Long) {}
            override fun onFinish() {
                buildingClass.deniedImage.visibility = View.INVISIBLE
            }
        }

        val mark: Person =
            Person(getString(R.string.nameMark), R.drawable.mark, getString(R.string.MarksMONEY))

        val anton: Person =
            Person(getString(R.string.nameAnton), R.drawable.anton, getString(R.string.AntonsMONEY))

        val ravel: Person =
            Person(getString(R.string.nameRavel), R.drawable.ravel, getString(R.string.RavelsMONEY))

        buildingClass.buttonChekInfo.setOnClickListener {
            when (buildingClass.passwordText.getText().toString()) {
                "4484" -> {
                    val h1 = Intent(this, SeqActivity::class.java)
                    h1.putExtra("Person", mark)
                    startActivity(h1)
                }
                "1555" -> {
                    val h2 = Intent(this, SeqActivity::class.java)
                    h2.putExtra("Person", anton)
                    startActivity(h2)
                }
                "6616" -> {
                    val h3 = Intent(this, SeqActivity::class.java)
                    h3.putExtra("Person", ravel)
                    startActivity(h3)
                }

                else -> {
                    buildingClass.deniedImage.visibility = View.VISIBLE
                    timer.start()
                }


            }
        }


    }
}