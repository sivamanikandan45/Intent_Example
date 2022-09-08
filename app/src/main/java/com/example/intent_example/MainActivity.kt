package com.example.intent_example

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {
    private lateinit var messageTextView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        messageTextView=findViewById(R.id.message_first)

        println("Creating activity 1")
        val button=findViewById<Button>(R.id.next)
        button.setOnClickListener{
            //println(it)
            val intent=Intent(this,SecondActivity::class.java)
            resultLauncher.launch(intent)
            //startActivity(intent)
        }
    }

    var resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        //println(result)

        if (result?.resultCode == Activity.RESULT_OK) {
            if(result.data?.getStringExtra("NAME")!=""){
                messageTextView.text=result.data?.getStringExtra("NAME")
            }else{
                messageTextView.text="First Activity"
            }
        }else{
            messageTextView.text="You Clicked Back Button"
        }
    }
    //onActivityResult / startActivityForResult

    override fun onStart() {
        println("Starting 1..")
        super.onStart()
    }

    override fun onResume() {
        println("Resuming 1...")
        super.onResume()
    }

    override fun onPause() {
        println("Pausing 1...")
        super.onPause()
    }

    override fun onStop() {
        println("Stopping 1..")
        super.onStop()
    }

    override fun onDestroy() {
        println("Destroying 1..")
        super.onDestroy()
    }

}

