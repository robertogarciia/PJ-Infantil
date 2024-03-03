package com.example.pj_infantil

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class lev1Activity : AppCompatActivity() {
    private lateinit var contadorTextView: TextView
    private val colors =  arrayOf("Rojo", "Verde", "Azul", "Lila") // Colores que se van a mostrar
    private var previousColor: String? = null
    private lateinit var correctColor: String
    private var contador: Int = 0
    private lateinit  var homebacklevel1 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level1colors)

        // Obtener referencias a los elementos de la interfaz de usuario
        val colorText: TextView = findViewById(R.id.imgPickColorUserPickLev1)
        val colorBlue: ImageView = findViewById(R.id.PickColorBlueLev1)
        val colorRed: ImageView = findViewById(R.id.PickColorRedLev1)
        val colorGreen: ImageView = findViewById(R.id.PickColorLev1BackgroundGeneral)
        val colorPurple: ImageView = findViewById(R.id.PickColorPurpleLev1)
        contadorTextView = findViewById(R.id.ContadorTv)
        homebacklevel1 = findViewById(R.id.HomeBackLevelMenu)

        homebacklevel1.setOnClickListener {
            val intent = Intent(this, MapLevels::class.java)
            startActivity(intent)
        }

        // Inicializar el juego
        startGame()

        // Configurar clics en las imágenes
        colorBlue.setOnClickListener { checkColor(colorBlue) }
        colorRed.setOnClickListener { checkColor(colorRed) }
        colorGreen.setOnClickListener { checkColor(colorGreen) }
        colorPurple.setOnClickListener { checkColor(colorPurple) }
    }

    private fun startGame() {
        // Elegir un color aleatorio que no sea el mismo que el anterior
        do {
            correctColor = colors[(0 until colors.size).random()]
        } while (correctColor == previousColor)

        // Actualizar el color anterior
        previousColor = correctColor

        // Mostrar el color en el texto
        val colorText: TextView = findViewById(R.id.imgPickColorUserPickLev1)
        colorText.text = correctColor
    }

    private fun checkColor(imageView: ImageView) {
        // Obtener el color asociado a la imagen
        val selectedColor = getColorForImageView(imageView)

        if (correctColor.equals(selectedColor, ignoreCase = true)) {
            contador += 1
        } else {
            contador -= 1
        }

        // Actualizar el TextView del contador
        contadorTextView.text = contador.toString()

        // Verificar si el jugador ha ganado
        if (contador == 5) {
            showGameWonDialog()
        }

        // Iniciar un nuevo juego después de cada intento
        startGame()
    }

    private fun showGameWonDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("¡Felicitats!")
        builder.setMessage("¡Has guanyat!")
        builder.setPositiveButton("Tornar al mapa de nivells") { dialog, _ ->
            val intent = Intent(this, MapLevels::class.java)
            startActivity(intent)
            dialog.dismiss()
        }
        builder.setCancelable(false)
        builder.create().show()
    }

    private fun getColorForImageView(imageView: ImageView): String {
        // Obtener el color asociado a la imagen
        return when (imageView.id) {
            R.id.PickColorBlueLev1 -> "Azul"
            R.id.PickColorRedLev1 -> "Rojo"
            R.id.PickColorLev1BackgroundGeneral -> "Verde"
            R.id.PickColorPurpleLev1 -> "Lila"
            else -> ""
        }
    }
}
