package com.example.pj_infantil

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class level1diferencias : AppCompatActivity() {

    // Aquí puedes declarar las vistas que necesitas
    private lateinit var ardilla1ImageView: ImageView
    private lateinit var ardilla2ImageView: ImageView
    private lateinit var florImageView: ImageView
    private lateinit var gorraImageView: ImageView
    private lateinit var mariposaImageView: ImageView
    private lateinit var solImageView: ImageView
    private lateinit var checkMariposa: ImageView
    private lateinit var checkGorra: ImageView
    private lateinit var checkSol: ImageView
    private lateinit var checkFlor: ImageView
    private lateinit var homeBacklevel : ImageView

    var final: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level1diferencias)

        game()
        homeBacklevel = findViewById(R.id.IVBackLevels)

        homeBacklevel.setOnClickListener {
            val intent = Intent(this, MapLevels::class.java)
            startActivity(intent)
        }

    }

    private fun initializeGame() {
        // Inicializar las vistas después de setContentView
        ardilla1ImageView = findViewById(R.id.ardilla1)
        ardilla2ImageView = findViewById(R.id.ardilla2)
        florImageView = findViewById(R.id.flor)
        gorraImageView = findViewById(R.id.gorra)
        mariposaImageView = findViewById(R.id.mariposa)
        solImageView = findViewById(R.id.sol)
        checkMariposa = findViewById(R.id.checkMariposa)
        checkGorra = findViewById(R.id.checkGorra)
        checkSol = findViewById(R.id.checkSol)
        checkFlor = findViewById(R.id.checkFlor)

        // Inicializar las propiedades de las vistas
        checkMariposa.visibility = View.INVISIBLE
        checkGorra.visibility = View.INVISIBLE
        checkSol.visibility = View.INVISIBLE
        checkFlor.visibility = View.INVISIBLE
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
        return (checkMariposa.visibility == View.VISIBLE &&
                checkFlor.visibility == View.VISIBLE &&
                checkSol.visibility == View.VISIBLE &&
                checkGorra.visibility == View.VISIBLE)
    }


    private fun setCardClickListeners() {
        florImageView.setOnClickListener { onCardClicked(1) }
        gorraImageView.setOnClickListener { onCardClicked(2) }
        solImageView.setOnClickListener { onCardClicked(3) }
        mariposaImageView.setOnClickListener { onCardClicked(4) }
    }

    private fun onCardClicked(num: Int? = null) {
        if (num == 1) {
            checkFlor.visibility = View.VISIBLE
        } else if (num == 2) {
            checkGorra.visibility = View.VISIBLE
        } else if (num == 3) {
            checkSol.visibility = View.VISIBLE
        } else if (num == 4) {
            checkMariposa.visibility = View.VISIBLE
        }
    }

    private fun showCompletionDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("¡MOLT BÉ!")
        builder.setMessage("HAS ACABAT EL JOC DE LES DIFERENCIES.")
        builder.setPositiveButton("ACCEPTAR") { dialog, _ ->
            dialog.dismiss()
            val intent = Intent(this, SecundaryMenu::class.java)
            startActivity(intent)
        }
        builder.create().show()
    }

}
