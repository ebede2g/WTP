package com.example.wtp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.wtp.databinding.SeqBinding

class SeqActivity : AppCompatActivity() {
    lateinit var buildingClass : SeqBinding


    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        setContentView(R.layout.seq)
        buildingClass = SeqBinding.inflate(layoutInflater)
        setContentView(buildingClass.root)

        val person = intent.getParcelableExtra<Person>("Person")
        buildingClass.imageOfPerson.setImageResource(person!!.image)
        buildingClass.moneyText.text=person.money
        buildingClass.nameText.text=person.name


        lateinit var timer : CountDownTimer
        timer = object : CountDownTimer(1_200, 1_000) {
            override fun onTick(remain: Long) {}
            override fun onFinish() {
                buildingClass.imageOfPerson.setImageResource(person!!.image)
            }
        }

        buildingClass.buttonGoBack.setOnClickListener { finish() }

        buildingClass.buttonGetPay.setOnClickListener {
            val money = (buildingClass.moneyText.text.toString().toInt() - buildingClass.paysSize.text.toString().toInt()).toString()
            if(money.toInt()>=0){
                buildingClass.moneyText.text=money
            }
            else{
                buildingClass.imageOfPerson.setImageResource(R.drawable.denied)
                timer.start()
            }

        }


    }

}