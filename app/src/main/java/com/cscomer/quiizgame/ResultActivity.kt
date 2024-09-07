package com.cscomer.quiizgame

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cscomer.quiizgame.databinding.ActivityPlayBinding
import com.cscomer.quiizgame.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val skip =intent.getIntExtra("skip",0)
        val correct=intent.getIntExtra("correct",0)
        val wrong=intent.getIntExtra("wrong",0)


        binding.resulttv.text=("Number of skip :$skip")
        binding.resulttv.text=("Number of correct:$correct")
        binding.resulttv.text=("Number of wrong: $wrong")


    }
}