package com.example.pj_infantil

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class lev1Activity : AppCompatActivity() {
    private lateinit var contadorTextView: TextView
    private val colors = arrayOf(
        R.string.colorsBlue,
        R.string.colorsPurple,
        R.string.colorsRed,
        R.string.colorsGreen,

    )

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
            correctColor = getString(colors[(0 until colors.size).random()])
        } while (correctColor == previousColor)

        // Actualizar el color anterior
        previousColor = correctColor

        // Mostrar el color en el texto
        val colorText: TextView = findViewById(R.id.imgPickColorUserPickLev1)
        colorText.text = correctColor
    }


    private fun checkColor(imageView: ImageView) {
        // Obtener el color asociado a la imagen
        val selectedColors = getColorForImageView(imageView)

        if (correctColor in selectedColors) {
            contador += 1
        } else {
            // Lógica para cuando el color seleccionado no es correcto
        }

        // Actualizar el TextView del contador
        contadorTextView.text = contador.toString()

        // Verificar si el jugador ha ganado
        if (contador == 5) {
            showGameWonDialog()
        }

        startGame()
    }

    private fun getColorForImageView(imageView: ImageView): List<String> {
        // Obtener el color asociado a la imagen
        return when (imageView.id) {
            R.id.PickColorBlueLev1 -> listOf("Blau", "Blue", "Azul")
            R.id.PickColorRedLev1 -> listOf("Vermell", "Red", "Rojo")
            R.id.PickColorLev1BackgroundGeneral -> listOf("Verd", "Green", "Verde")
            R.id.PickColorPurpleLev1 -> listOf("Lila", "Purple")
            else -> emptyList()
        }
    }


    private fun showGameWonDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.dialogueCongratulations)
        builder.setMessage(R.string.dialogueYouWin)
        builder.setPositiveButton(R.string.dialoguereturnmap) { dialog, _ ->
            val intent = Intent(this, MapLevels::class.java)
            startActivity(intent)
            dialog.dismiss()
        }
        builder.setCancelable(false)
        builder.create().show()
    }
}
