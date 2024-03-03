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

class level1puzzle : AppCompatActivity() {

    private lateinit var piezas: List<ImageButton>
    private lateinit var sitios: List<ImageView>
    private lateinit var piezasPuestas: List<ImageView>
    private lateinit var homebacklevel6 : ImageView

    // Propiedades para las imágenes iniciales
    private lateinit var p1s1: ImageView
    private lateinit var p1s2: ImageView
    private lateinit var p1s3: ImageView
    private lateinit var p1s4: ImageView

    private lateinit var p2s1: ImageView
    private lateinit var p2s2: ImageView
    private lateinit var p2s3: ImageView
    private lateinit var p2s4: ImageView

    private lateinit var p3s1: ImageView
    private lateinit var p3s2: ImageView
    private lateinit var p3s3: ImageView
    private lateinit var p3s4: ImageView

    private lateinit var p4s1: ImageView
    private lateinit var p4s2: ImageView
    private lateinit var p4s3: ImageView
    private lateinit var p4s4: ImageView

    private lateinit var p1: ImageButton
    private lateinit var p2: ImageButton
    private lateinit var p3: ImageButton
    private lateinit var p4: ImageButton

    private lateinit var s1: ImageView
    private lateinit var s2: ImageView
    private lateinit var s3: ImageView
    private lateinit var s4: ImageView

    var b_p1: Boolean? = false
    var b_p2: Boolean? = false
    var b_p3: Boolean? = false
    var b_p4: Boolean? = false

    var b_s1: Boolean? = false
    var b_s2: Boolean? = false
    var b_s3: Boolean? = false
    var b_s4: Boolean? = false

    var final: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.puzzlelev1)

        homebacklevel6 = findViewById(R.id.HomeBackLevelMenu)

        homebacklevel6.setOnClickListener {
            val intent = Intent(this, MapLevels::class.java)
            startActivity(intent)
        }

        game()
    }

    private fun initializeGame() {
        // Inicializar las vistas después de setContentView
        piezas = listOf(
            findViewById(R.id.pieza1),
            findViewById(R.id.pieza2),
            findViewById(R.id.pieza3),
            findViewById(R.id.pieza4),
        )

        sitios = listOf(
            findViewById(R.id.sitio1),
            findViewById(R.id.sitio2),
            findViewById(R.id.sitio3),
            findViewById(R.id.sitio4),
        )

        piezasPuestas = listOf(
            findViewById(R.id.pieza1_sitio1),
            findViewById(R.id.pieza1_sitio2),
            findViewById(R.id.pieza1_sitio3),
            findViewById(R.id.pieza1_sitio4),

            findViewById(R.id.pieza2_sitio1),
            findViewById(R.id.pieza2_sitio2),
            findViewById(R.id.pieza2_sitio3),
            findViewById(R.id.pieza2_sitio4),

            findViewById(R.id.pieza3_sitio1),
            findViewById(R.id.pieza3_sitio2),
            findViewById(R.id.pieza3_sitio3),
            findViewById(R.id.pieza3_sitio4),

            findViewById(R.id.pieza4_sitio1),
            findViewById(R.id.pieza4_sitio2),
            findViewById(R.id.pieza4_sitio3),
            findViewById(R.id.pieza4_sitio4),
        )

        // Inicializar las imágenes que hay dentro del cuadro del puzzle
        //piezas1
        p1 = piezas[0]
        s1 = sitios[0]
        p1s1 = piezasPuestas[0]
        p1s2 = piezasPuestas[1]
        p1s3 = piezasPuestas[2]
        p1s4 = piezasPuestas[3]

        //piezas2
        p2 = piezas[1]
        s2 = sitios[1]
        p2s1 = piezasPuestas[4]
        p2s2 = piezasPuestas[5]
        p2s3 = piezasPuestas[6]
        p2s4 = piezasPuestas[7]

        //piezas3
        p3 = piezas[2]
        s3 = sitios[2]
        p3s1 = piezasPuestas[8]
        p3s2 = piezasPuestas[9]
        p3s3 = piezasPuestas[10]
        p3s4 = piezasPuestas[11]

        //piezas4
        p4 = piezas[3]
        s4 = sitios[3]
        p4s1 = piezasPuestas[12]
        p4s2 = piezasPuestas[13]
        p4s3 = piezasPuestas[14]
        p4s4 = piezasPuestas[15]

        // Hacer invisible las imagenes dentro del cuadro del puzzle
        p1s1.visibility = View.INVISIBLE
        p1s2.visibility = View.INVISIBLE
        p1s3.visibility = View.INVISIBLE
        p1s4.visibility = View.INVISIBLE

        p2s1.visibility = View.INVISIBLE
        p2s2.visibility = View.INVISIBLE
        p2s3.visibility = View.INVISIBLE
        p2s4.visibility = View.INVISIBLE

        p3s1.visibility = View.INVISIBLE
        p3s2.visibility = View.INVISIBLE
        p3s3.visibility = View.INVISIBLE
        p3s4.visibility = View.INVISIBLE

        p4s1.visibility = View.INVISIBLE
        p4s2.visibility = View.INVISIBLE
        p4s3.visibility = View.INVISIBLE
        p4s4.visibility = View.INVISIBLE
    }

    private val handler = Handler()

    fun game() {
        initializeGame()
        setCardClickListeners()
        checkGameCompletion()
    }

/*    private fun resetGame() {
        p1.visibility = View.VISIBLE
        p2.visibility = View.VISIBLE
        p3.visibility = View.VISIBLE
        p4.visibility = View.VISIBLE

        p1s1.visibility = View.INVISIBLE
        p1s2.visibility = View.INVISIBLE
        p1s3.visibility = View.INVISIBLE
        p1s4.visibility = View.INVISIBLE

        p2s1.visibility = View.INVISIBLE
        p2s2.visibility = View.INVISIBLE
        p2s3.visibility = View.INVISIBLE
        p2s4.visibility = View.INVISIBLE

        p3s1.visibility = View.INVISIBLE
        p3s2.visibility = View.INVISIBLE
        p3s3.visibility = View.INVISIBLE
        p3s4.visibility = View.INVISIBLE

        p4s1.visibility = View.INVISIBLE
        p4s2.visibility = View.INVISIBLE
        p4s3.visibility = View.INVISIBLE
        p4s4.visibility = View.INVISIBLE

        b_p1 = false
        b_p2 = false
        b_p3 = false
        b_p4 = false

        b_s1 = false
        b_s2 = false
        b_s3 = false
        b_s4 = false

        final = false

        setCardClickListeners()
    } */

    private fun checkGameCompletion() {
        handler.postDelayed({
            if (!final) {
                if (checkCardsVisibility() && checkSitioBooleans()) {
                    showCompletionDialog()
                } else {
                    checkGameCompletion()
                }
            }
        }, 100)
    }

    private fun checkSitioBooleans(): Boolean {
        return (b_s1 == true && b_s2 == true && b_s3 == true && b_s4 == true)
    }

    private fun checkCardsVisibility(): Boolean {
        return (p1s1.visibility == View.VISIBLE &&
                p2s2.visibility == View.VISIBLE &&
                p3s3.visibility == View.VISIBLE &&
                p4s4.visibility == View.VISIBLE)
    }


    private fun setCardClickListeners() {
        p1.setOnClickListener { onCardClicked(1) }
        p2.setOnClickListener { onCardClicked(2) }
        p3.setOnClickListener { onCardClicked(3) }
        p4.setOnClickListener { onCardClicked(4) }
    }

    private fun onCardClicked(num: Int? = null) {
        if (num == 1) {
            p1.visibility = View.INVISIBLE
            b_p1 = true
            setSitioClickListeners()
        } else if (num == 2) {
            p2.visibility = View.INVISIBLE
            b_p2 = true
            setSitioClickListeners()
        } else if (num == 3) {
            p3.visibility = View.INVISIBLE
            b_p3 = true
            setSitioClickListeners()
        } else if (num == 4) {
            p4.visibility = View.INVISIBLE
            b_p4 = true
            setSitioClickListeners()
        }
    }

    private fun setSitioClickListeners() {
        s1.setOnClickListener { onSitioClicked(1) }
        s2.setOnClickListener { onSitioClicked(2) }
        s3.setOnClickListener { onSitioClicked(3) }
        s4.setOnClickListener { onSitioClicked(4) }
    }

    private fun onSitioClicked(num: Int? = null) {
        if (b_p1 == true && num == 1) { // Si la pieza 1 está seleccionada
            p1s1.visibility = View.VISIBLE
            b_p1 = false
            b_s1 = true
        } else if (b_p1 == true && num == 2) {
            p1s2.visibility = View.VISIBLE
            b_p1 = false
        } else if (b_p1 == true && num == 3) {
            p1s3.visibility = View.VISIBLE
            b_p1 = false
        } else if (b_p1 == true && num == 4) {
            p1s4.visibility = View.VISIBLE
            b_p1 = false

        } else if (b_p2 == true && num == 1) { // Si la pieza 2 está seleccionada
            p2s1.visibility = View.VISIBLE
            b_p2 = false
        } else if (b_p2 == true && num == 2) {
            p2s2.visibility = View.VISIBLE
            b_p2 = false
            b_s2 = true
        } else if (b_p2 == true && num == 3) {
            p2s3.visibility = View.VISIBLE
            b_p2 = false
        } else if (b_p2 == true && num == 4) {
            p2s4.visibility = View.VISIBLE
            b_p2 = false

        } else if (b_p3 == true && num == 1) { // Si la pieza 3 está seleccionada
            p3s1.visibility = View.VISIBLE
            b_p3 = false
        } else if (b_p3 == true && num == 2) {
            p3s2.visibility = View.VISIBLE
            b_p3 = false
        } else if (b_p3 == true && num == 3) {
            p3s3.visibility = View.VISIBLE
            b_p3 = false
            b_s3 = true
        } else if (b_p3 == true && num == 4) {
            p3s4.visibility = View.VISIBLE
            b_p3 = false

        } else if (b_p4 == true && num == 1) { // Si la pieza 4 está seleccionada
            p4s1.visibility = View.VISIBLE
            b_p4 = false
        } else if (b_p4 == true && num == 2) {
            p4s2.visibility = View.VISIBLE
            b_p4 = false
        } else if (b_p4 == true && num == 3) {
            p4s3.visibility = View.VISIBLE
            b_p4 = false
        } else if (b_p4 == true && num == 4) {
            p4s4.visibility = View.VISIBLE
            b_p4 = false
            b_s4 = true
        }
    }

    private fun showCompletionDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("¡MOLT BÉ!")
        builder.setMessage("HAS ACABAT EL JOC DEL PUZZLE.")
        builder.setPositiveButton("ACCEPTAR") { dialog, _ ->
            dialog.dismiss()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        builder.create().show()
    }
}