package com.example.intent_example

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        /*val name=intent.getStringExtra("EXTRA_NAME")
        val tv=findViewById<TextView>(R.id.textview2)
        tv.text=name*/
        println("Creating activity 2")
         val input=findViewById<EditText>(R.id.second_activity)
        val btn=findViewById<Button>(R.id.set)
        btn.setOnClickListener{
            intent=Intent()
            intent.putExtra("NAME",input.text.toString())
            setResult(RESULT_OK,intent)
            finish()
        }

        val firstActivityBtn=findViewById<Button>(R.id.first_activity)
        firstActivityBtn.setOnClickListener {
            intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        val secondActivityBtn=findViewById<Button>(R.id.second_activity_btn)
        secondActivityBtn.setOnClickListener {
            intent=Intent(this,SecondActivity::class.java)
            //intent.flags=Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        /*intent=Intent()
        intent.putExtra("NAME","from child activity")*/
        setResult(RESULT_CANCELED)
        finish()
    }

    override fun onStart() {
        println("Starting 2..")
        super.onStart()
    }

    override fun onResume() {
        println("Resuming 2...")
        super.onResume()
    }

    override fun onPause() {
        println("Pausing 2...")
        super.onPause()
    }

    override fun onStop() {
        println("Stopping 2..")
        super.onStop()
    }

    override fun onDestroy() {
        println("Destroying 2..")
        super.onDestroy()
    }
}