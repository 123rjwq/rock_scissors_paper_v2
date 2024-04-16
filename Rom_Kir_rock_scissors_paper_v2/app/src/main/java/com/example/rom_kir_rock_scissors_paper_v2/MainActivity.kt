package com.example.rom_kir_rock_scissors_paper_v2


import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val elements = listOf("Камень", "Ножницы", "Бумага", "Ящерица", "Спок")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttons = listOf(
            findViewById<Button>(R.id.button_stone),
            findViewById<Button>(R.id.button_scissors),
            findViewById<Button>(R.id.button_paper),
            findViewById<Button>(R.id.button_lizard),
            findViewById<Button>(R.id.button_spock)
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                val userChoice = button.text.toString()
                val pcChoice = elements.random()
                // Вывод выбора компьютера
                Toast.makeText(this, "Компьютер выбрал: $pcChoice", Toast.LENGTH_SHORT).show()
                val result = checkWinner(userChoice, pcChoice)
                Toast.makeText(this, result, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkWinner(userChoice: String, pcChoice: String): String {
        return when {
            userChoice == pcChoice -> "Ничья!"
            (userChoice == "Камень" && pcChoice == "Ножницы") ||
                    (userChoice == "Ножницы" && pcChoice == "Бумага") ||
                    (userChoice == "Бумага" && pcChoice == "Камень") ||
                    (userChoice == "Камень" && pcChoice == "Ящерица") ||
                    (userChoice == "Ящерица" && pcChoice == "Спок") ||
                    (userChoice == "Спок" && pcChoice == "Ножницы") ||
                    (userChoice == "Ножницы" && pcChoice == "Ящерица") ||
                    (userChoice == "Ящерица" && pcChoice == "Бумага") ||
                    (userChoice == "Бумага" && pcChoice == "Спок") ||
                    (userChoice == "Спок" && pcChoice == "Камень") -> "Победа пользователя!"
            else -> "Победа компьютера!"
        }
    }
}

