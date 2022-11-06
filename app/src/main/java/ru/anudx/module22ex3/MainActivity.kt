package ru.anudx.module22ex3

import android.animation.*
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ru.anudx.module22ex3.databinding.ActivityMainBinding
import ru.anudx.module22ex3.databinding.ButtonNewBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private lateinit var t: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.linearLayout.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        b.linearLayout.layoutTransition.setAnimator(LayoutTransition.APPEARING, AnimatorInflater.loadAnimator(this, R.animator.animator_btn))
        b.btnAdd.setOnClickListener {
            //val button = findViewById<Button>(R.id.bnt_new)
            val button = Button(this)
            button.text = "QWERTY"
            button.scaleX = 0f
            button.scaleY = 0f
            button.setOnClickListener {
                (it as Button).text = "1234567890"
            }
            b.linearLayout.addView(button)
        }
        b.btnDel.setOnClickListener {
            if (b.linearLayout.childCount > 0){
                b.linearLayout.removeViewAt(b.linearLayout.childCount-1)
            }
        }
    }
}