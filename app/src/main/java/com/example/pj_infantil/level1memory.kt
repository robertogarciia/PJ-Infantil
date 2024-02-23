package com.example.pj_infantil

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.pj_infantil.R

class level1memory : AppCompatActivity() {

    private val cards: List<ImageButton> by lazy {
        listOf(
            findViewById(R.id.madera_1),
            findViewById(R.id.madera_2),
            findViewById(R.id.madera_3),
            findViewById(R.id.madera_4),
            findViewById(R.id.madera_5),
            findViewById(R.id.madera_6),
            findViewById(R.id.madera_7),
            findViewById(R.id.madera_8)
        )
    }

    // Propiedades para las imágenes iniciales
    private val initialImages: List<ImageView> by lazy {
        listOf(
            findViewById(R.id.par1_1),
            findViewById(R.id.par1_2),
            findViewById(R.id.par2_1),
            findViewById(R.id.par2_2),
            findViewById(R.id.par3_1),
            findViewById(R.id.par3_2),
            findViewById(R.id.par4_1),
            findViewById(R.id.par4_2)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level1memory)

        val madera1: ImageButton = cards[0]
        val madera2: ImageButton = cards[1]
        val madera3: ImageButton = cards[2]
        val madera4: ImageButton = cards[3]
        val madera5: ImageButton = cards[4]
        val madera6: ImageButton = cards[5]
        val madera7: ImageButton = cards[6]
        val madera8: ImageButton = cards[7]

        val par1_1: ImageView = initialImages[0]
        val par1_2: ImageView = initialImages[1]
        val par2_1: ImageView = initialImages[2]
        val par2_2: ImageView = initialImages[3]
        val par3_1: ImageView = initialImages[4]
        val par3_2: ImageView = initialImages[5]
        val par4_1: ImageView = initialImages[6]
        val par4_2: ImageView = initialImages[7]

    }

    private var clickedCard: ImageButton? = null
    private var lastClickedCard: Int? = null

    private fun onCardClicked(card: ImageButton, imageId: Int) {
        // Encuentra el índice de la carta clicada
        val cardIndex = cards.indexOf(card)

        // Verifica si ya se hizo clic en otra carta
        if (lastClickedCard == null) {
            // Primer clic
            lastClickedCard = cardIndex
            clickedCard = card
            card.setImageResource(imageId)
        } else {
            // Segundo clic
            card.setImageResource(imageId)


            if (initialImages[lastClickedCard!!].drawable.constantState == initialImages[cardIndex].drawable.constantState) {
                // Se encontró un par, haz las imágenes correspondientes visibles
                initialImages[lastClickedCard!!].visibility = View.VISIBLE
                initialImages[cardIndex].visibility = View.VISIBLE
            } else {
                // No es un par, volvemos a ocultar las cartas después de un breve tiempo
                card.postDelayed({
                    card.setImageResource(R.drawable.tablamemory)
                    clickedCard?.setImageResource(R.drawable.tablamemory)
                    clickedCard = null
                    lastClickedCard = null
                }, 1000)
            }
        }
    }
}