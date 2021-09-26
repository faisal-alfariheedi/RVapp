package com.example.rvapp


import android.graphics.Color.parseColor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var input = ArrayList<String>()
        var add =findViewById<Button>(R.id.button)
        var inin =findViewById<EditText>(R.id.entry)
        val rv= findViewById<RecyclerView>(R.id.rvMain)
        rv.adapter = RVAdapter(input)
        rv.layoutManager = LinearLayoutManager(this)
        var snackbar = Snackbar.make(findViewById<ConstraintLayout>(R.id.mains),"IT is empty you can`t add empty because i said so"
            ,Snackbar.LENGTH_LONG)

                add.setOnClickListener{(
            if (inin.text.toString().isNotEmpty()){
                input.add(inin.text.toString())
                inin.setHintTextColor(parseColor("#000000"))
                rv.adapter = RVAdapter(input)
                inin.text.clear()
            }else{
                snackbar.show()
                inin.setHintTextColor(parseColor("#FF0000"))
                })
        }

    }

}