package com.example.pj_infantil

import android.app.AlertDialog
import android.os.Handler
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.pj_infantil.R

class level2memory : AppCompatActivity() {

    private lateinit var cards: List<ImageButton>
    private lateinit var initialImages: List<ImageView>
    private lateinit var homebacklevel2 : ImageView

    // Propiedades para las imágenes iniciales
    private lateinit var par1_1: ImageView
    private lateinit var par1_2: ImageView
    private lateinit var par2_1: ImageView
    private lateinit var par2_2: ImageView
    private lateinit var par3_1: ImageView
    private lateinit var par3_2: ImageView
    private lateinit var par4_1: ImageView
    private lateinit var par4_2: ImageView
    private lateinit var par5_1: ImageView
    private lateinit var par5_2: ImageView

    private lateinit var madera1: ImageButton
    private lateinit var madera2: ImageButton
    private lateinit var madera3: ImageButton
    private lateinit var madera4: ImageButton
    private lateinit var madera5: ImageButton
    private lateinit var madera6: ImageButton
    private lateinit var madera7: ImageButton
    private lateinit var madera8: ImageButton
    private lateinit var madera9: ImageButton
    private lateinit var madera10: ImageButton

    var par1: String? = null
    var par2: String? = null
    var final: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level2memory)
        game()

        homebacklevel2 = findViewById(R.id.HomeBackLevelMenuMemory)

        homebacklevel2.setOnClickListener {
            val intent = Intent(this, MapLevels::class.java)
            startActivity(intent)
        }
    }

    private fun initializeGame() {
        // Inicializar las vistas después de setContentView
        cards = listOf(
            findViewById(R.id.madera_1),
            findViewById(R.id.madera_2),
            findViewById(R.id.madera_3),
            findViewById(R.id.madera_4),
            findViewById(R.id.madera_5),
            findViewById(R.id.madera_6),
            findViewById(R.id.madera_7),
            findViewById(R.id.madera_8),
            findViewById(R.id.madera_9),
            findViewById(R.id.madera_10)
        )

        initialImages = listOf(
            findViewById(R.id.par1_1),
            findViewById(R.id.par1_2),
            findViewById(R.id.par2_1),
            findViewById(R.id.par2_2),
            findViewById(R.id.par3_1),
            findViewById(R.id.par3_2),
            findViewById(R.id.par4_1),
            findViewById(R.id.par4_2),
            findViewById(R.id.par5_1),
            findViewById(R.id.par5_2)
        )

        madera1 = cards[0]
        madera2 = cards[1]
        madera3 = cards[2]
        madera4 = cards[3]
        madera5 = cards[4]
        madera6 = cards[5]
        madera7 = cards[6]
        madera8 = cards[7]
        madera9 = cards[8]
        madera10 = cards[9]

        par1_1 = initialImages[0]
        par1_2 = initialImages[1]
        par2_1 = initialImages[2]
        par2_2 = initialImages[3]
        par3_1 = initialImages[4]
        par3_2 = initialImages[5]
        par4_1 = initialImages[6]
        par4_2 = initialImages[7]
        par5_1 = initialImages[8]
        par5_2 = initialImages[9]

        // Hacer invisible la imagen par1_1
        par1_1.visibility = View.INVISIBLE
        par1_2.visibility = View.INVISIBLE
        par2_1.visibility = View.INVISIBLE
        par2_2.visibility = View.INVISIBLE
        par3_1.visibility = View.INVISIBLE
        par3_2.visibility = View.INVISIBLE
        par4_1.visibility = View.INVISIBLE
        par4_2.visibility = View.INVISIBLE
        par5_1.visibility = View.INVISIBLE
        par5_2.visibility = View.INVISIBLE
    }

    private val handler = Handler()

    private fun game() {
        initializeGame()
        setCardClickListeners()
        checkGameCompletion()
    }

    private fun checkGameCompletion() {
        handler.postDelayed({
            if (!final) {
                if (checkCardsVisibility()) {
                    showCompletionDialog()
                } else {
                    checkGameCompletion()
                }
            }
        }, 100) // Ajusta el tiempo según sea necesario
    }

    private fun checkCardsVisibility(): Boolean {
        return (par1_1.visibility == View.VISIBLE && par1_2.visibility == View.VISIBLE &&
                par2_1.visibility == View.VISIBLE && par2_2.visibility == View.VISIBLE &&
                par3_1.visibility == View.VISIBLE && par3_2.visibility == View.VISIBLE &&
                par4_1.visibility == View.VISIBLE && par4_2.visibility == View.VISIBLE &&
                par5_1.visibility == View.VISIBLE && par5_2.visibility == View.VISIBLE)
    }


    private fun setCardClickListeners() {
        madera1.setOnClickListener { onCardClicked(par1_1, "par1", "par1") }
        madera2.setOnClickListener { onCardClicked(par2_1, "par2", "par2") }
        madera3.setOnClickListener { onCardClicked(par3_1, "par3", "par3") }
        madera4.setOnClickListener { onCardClicked(par4_2, "par4", "par4") }
        madera5.setOnClickListener { onCardClicked(par4_1, "par4", "par4") }
        madera6.setOnClickListener { onCardClicked(par2_2, "par2", "par2") }
        madera7.setOnClickListener { onCardClicked(par1_2, "par1", "par1") }
        madera8.setOnClickListener { onCardClicked(par3_2, "par3", "par3") }
        madera9.setOnClickListener { onCardClicked(par5_1, "par5", "par5") }
        madera10.setOnClickListener { onCardClicked(par5_2, "par5", "par5") }
    }

    private fun onCardClicked(card: ImageView, primeraCard: String? = null, segundaCard: String? = null) {
        if (par1 == null) {
            card.visibility = View.VISIBLE
            par1 = primeraCard
        } else {
            par2 = segundaCard
            if (par1 == par2) {
                card.visibility = View.VISIBLE
                par1 = null
                par2 = null
            } else {
                initialImages.forEach {
                    it.visibility = View.INVISIBLE
                }
                par1 = null
                par2 = null
            }
        }
    }

    private fun showCompletionDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("¡MOLT BÉ!")
        builder.setMessage("HAS ACABAT EL JOC DEL MEMORI.")
        builder.setPositiveButton("ACCEPTAR") { dialog, _ ->
            dialog.dismiss()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        builder.create().show()
    }
}