package com.example.crosszero

import android.app.Dialog
import android.content.Intent
import android.graphics.Color.green
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.winnerdialog.*

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    // function for 9 blocks
    fun buclick(view: View) {
        var cellId = 0    // giving id's to each cell
        val buSelected = view as Button

        when (buSelected.id)   // switch case
        {
            R.id.bu1 -> cellId = 1;
            R.id.bu2 -> cellId = 2;
            R.id.bu3 -> cellId = 3;
            R.id.bu4 -> cellId = 4;
            R.id.bu5 -> cellId = 5;
            R.id.bu6 -> cellId = 6;
            R.id.bu7 -> cellId = 7;
            R.id.bu8 -> cellId = 8;
            R.id.bu9 -> cellId = 9;
        }
        playGame(cellId, buSelected)  // function call

    }

    var activePlayer = 1;
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellId: Int, buSelected: Button) {
        if (activePlayer == 1) {
            buSelected.text = "X";
            buSelected.setBackgroundResource(R.drawable.playeronebox)
            player1.add(cellId)
            activePlayer = 2   //player 2 can't use the same button
        } else {
            buSelected.text = "O";
            buSelected.setBackgroundResource(R.drawable.playertwobox)
            player2.add(cellId)
            activePlayer = 1   //player 1 can't use the same button
        }

        buSelected.isEnabled = false

        checkWinner()   // function call
    }

    // FUNCTION TO CHECK WINNER OF THE GAME
    fun checkWinner() {
        var winner = -1
//--------------------------------------------------------------------------------------------------
        // row 1 winner
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
//--------------------------------------------------------------------------------------------------
        // row 2 winner
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }

        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
//--------------------------------------------------------------------------------------------------

        // row 3 winner
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
//-------------------------------------------------------------------------------------------------
        // col 1 winner
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
//-------------------------------------------------------------------------------------------------
        // col 2 winner
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }

        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
//-------------------------------------------------------------------------------------------------
        // col 3 winner
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
//--------------------------------------------------------------------------------------------------
        // diagonal winner
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
//--------------------------------------------------------------------------------------------------
        // diagonal winner
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }

        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }
//--------------------------------------------------------------------------------------------------


        // making dialog
        if (winner == 1) {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            // go to resources->layout->winner dialog & implement that layout here
            dialog.setContentView(R.layout.winnerdialog)
            dialog.win.text = "Player 1 Wins"

            dialog.exit.setOnClickListener {
                val intent = Intent(this, StartActivity::class.java)
                startActivity(intent)
            }

            dialog.again.setOnClickListener {
                val intent = Intent(this, GameActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()
        }
        else if (winner == 2) {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            // go to resources->layout->winner dialog & implement that layout here
            dialog.setContentView(R.layout.winnerdialog)
            dialog.win.text = "Player 2 Wins"

            dialog.exit.setOnClickListener {
                val intent = Intent(this, StartActivity::class.java)
                startActivity(intent)
            }

            dialog.again.setOnClickListener {
                val intent = Intent(this, GameActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()

        }

    }
}
