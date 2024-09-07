package com.cscomer.quiizgame

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cscomer.quiizgame.databinding.ActivityMainBinding
import com.cscomer.quiizgame.databinding.ActivityPlayBinding

class playActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlayBinding

   val quizlist= listOf<Quiz>(


      Quiz("What is your Country Name?",
          "Bangladesh",
          "pakistan",
          "India",
          "Iran",
          "Bangladesh"),
       Quiz("What is the Capital of Bangladesh?",
           "Dhaka",
           "Rongpur",
           "Borishal",
           "Noyakhali",
           "Dhaka"),
       Quiz(" What is the Capital of Pakistan?",
           "Dhaka",
           "Islamabad",
           "Borishal",
           "Noyadilli",
           "Islamabad"),
       Quiz(" What is the Capital of India ?",
           "Dhaka",
           "Islamabad",
           "Borishal",
           "Noyadilli",
           "Noyadilli"),
       Quiz("What is your national Animal?",
           "Cow",
           "Fox",
           "Tiger",
           "Lion",
           "Tiger"),
       Quiz("What is your national Bird?",
           "Dove",
           "Magpie Robin",
           "Cuckoo",
           "crow",
           "Magpie Robin"),
       Quiz("Who was the first prime minister of Bangladesh?",
           "sheikh Mujibur Rahman",
           "Tazuddin Ahmed",
           "Sayed Nazrul Islam",
           "Mr.Mohammed Shahabuddin",
           "Tazuddin Ahmed"),
       Quiz("Who was the first president of Bangladesh?",
           "Sayed Nazrul Islam",
           "Mr.Mohammed Shahabuddin",
           "sheikh Mujibur Rahman",
           "Tazuddin Ahmed",
           "sheikh Mujibur Rahman"),





   )

    var index = 0
    var updateQuestion = 1
    var hasFinished = false


    var skip =-1
    var correct=0
    var wrong=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)


        intTQuestion()
        binding.NextBT.setOnClickListener(){


            showNextQuestion()
        }

    }

    private fun intTQuestion() {
        val quiz =quizlist[index]



        binding.apply{
            TextVI.text=quiz.question
            radioBT1.text=quiz.option1
            radioBT2.text=quiz.option2
            radioBT3.text=quiz.option3
            radioBT4.text=quiz.option4
        }

    }
    private fun showNextQuestion(){

        CheckAnswer()
        binding.apply {


            if (updateQuestion < quizlist.size) {
                updateQuestion++
                intTQuestion()

            }else if (index <= quizlist.size -1) {
                index++
            }else{
                hasFinished =true
            }

            radioGP.clearCheck()


        }



    }
    private fun CheckAnswer(){

        binding.apply {

            if (radioGP.checkedRadioButtonId==-1){
                skip++
                showAlertDialoge("skip")
            }else{
              val checkButton=findViewById<RadioButton>(radioGP.checkedRadioButtonId)
                val checkAnswer=checkButton.text.toString()


                if(checkAnswer == quizlist [index].answer){
                    correct++

                    showAlertDialoge("Answer Right")

                }else{

                    wrong++
                    showAlertDialoge("Answer wrong")
                }





            }

            if (index<= quizlist.size-1){
                index++

            }else{

                showAlertDialoge("Finished")
            }



        }




    }

    fun showAlertDialoge(message:String){

        val builder=AlertDialog.Builder(this)
        builder.setTitle(message)


        builder.setPositiveButton("ok", object :DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {


                if (message=="Finished"){


                    val intent= Intent(this@playActivity,ResultActivity::class.java)

                    intent.putExtra("skip",skip)
                    intent.putExtra("correct",correct)
                    intent.putExtra("wrong",wrong)


                    startActivity(intent)
                }


            }


        })

        val alertDialog=builder.create()
        alertDialog.show()




    }








}