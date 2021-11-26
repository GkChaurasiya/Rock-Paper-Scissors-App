package com.development.rockpaperscissor

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

        private val rock =findViewById<Button>(R.id.Rock)
        private val paper=findViewById<Button>(R.id.Paper)
        private val scissor=findViewById<Button>(R.id.Scissor)
        private var score=findViewById<TextView>(R.id.yourScore)
        private val computerChoice=findViewById<TextView>(R.id.computerchoiceValue)
        private var playerScore:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        rock.setOnClickListener {
            val result:Int=playTurn("rock")
            if(result==1)
                Toast.makeText(this,"You Won",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Computer Won",Toast.LENGTH_SHORT).show()
            return@setOnClickListener

        }
        paper.setOnClickListener {
            val result:Int=playTurn("paper")
            if(result==1)
                Toast.makeText(this,"You Won",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Computer Won",Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }
        scissor.setOnClickListener {
            val result:Int=playTurn("scissor")
            if(result==1)
                Toast.makeText(this,"You Won",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Computer Won",Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }
        score.text= playerScore.toString()
    }
    @SuppressLint("SetTextI18n")
    fun playTurn(playerChoice:String):Int
    {
        var computerchoice:String=""
        val computerchoiceNumber=(1..3).random()
        if(computerchoiceNumber==1)
        {
            computerchoice="rock"
        }
        if(computerchoiceNumber==2)
        {
            computerchoice="paper"
        }
        if(computerchoiceNumber==3)
        {
            computerchoice="scissors"
        }
        if(computerchoice=="rock")
        {
            computerChoice.text="Rock"
        }

        else if(computerchoice=="paper")
        {
            computerChoice.text="Paper"
        }

        else if(computerchoice=="scissors")
        {
            computerChoice.text="Scissors"
        }

        //comparing player choice with human choice
        if(computerchoice==playerChoice)
        {
            return 0
        }
        else if(playerChoice=="rock" && computerchoice=="Scissor")
        {
            playerScore++
            return 1
        }
        else if(playerChoice=="rock" && computerchoice=="paper")
        {
            playerScore--
            return -1
        }
        else if(playerChoice=="scissors" && computerchoice=="paper")
        {
            playerScore++
            return 1
        }
        else if(playerChoice=="paper" && computerchoice=="rock")
        {
            playerScore++
            return 1
        }
        else if(playerChoice=="paper" && computerchoice=="scissors")
        {
            playerScore--
            return -1
        }
        else if(playerChoice=="scissors" && computerchoice=="rock")
        {
            playerScore--
            return -1
        }

        else
        {
            return -2
        }
    }
}