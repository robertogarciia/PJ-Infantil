package com.example.pj_infantil

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class level1memory : AppCompatActivity() {

    private var flippedCards: MutableList<ImageButton> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level1memory)

        val cards: List<ImageButton> = listOf(
            findViewById(R.id.madera_1),
            findViewById(R.id.madera_2),
            findViewById(R.id.madera_3),
            findViewById(R.id.madera_4),
            findViewById(R.id.madera_5),
            findViewById(R.id.madera_6),
            findViewById(R.id.madera_7),
            findViewById(R.id.madera_8)
        )


        for (card in cards) {
            card.setOnClickListener {
                onCardClicked(card)
            }
        }
    }

    private fun onCardClicked(card: ImageButton) {
        if (!flippedCards.contains(card)) {
            // Flip the card
            // Add your code here to set the image source based on the card's identity

            flippedCards.add(card)

            // Check if two cards are flipped
            if (flippedCards.size == 2) {
                // Add your code here to check if the two flipped cards match
                // If they match, you can keep them flipped; otherwise, flip them back
                // Clear the flipped cards list for the next turn
                flippedCards.clear()
            }
        }
    }
}
