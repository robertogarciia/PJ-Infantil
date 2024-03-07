package  com.example.pj_infantil
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.pj_infantil.MapLevels
import com.example.pj_infantil.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class levAnswerCharacters : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var btnOption1: ImageView
    private lateinit var btnOption2: ImageView
    private lateinit var btnOption3: ImageView
    private lateinit var btnOption4: ImageView
    private lateinit var contadorTextView: TextView
    private lateinit var homebacklevel1 : ImageView

    private val correctAnswers = intArrayOf(3, 1, 4, 2)
    private var currentImageIndex = 0
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.levelcountcharacters)

        imageView = findViewById(R.id.imgShow)
        btnOption1 = findViewById(R.id.ivcount1)
        btnOption2 = findViewById(R.id.ivcount2)
        btnOption3 = findViewById(R.id.ivcount3)
        btnOption4 = findViewById(R.id.ivcount4)
        homebacklevel1 = findViewById(R.id.IVBackLevels)

        contadorTextView = findViewById(R.id.textViewcontador)

        btnOption1.setOnClickListener { checkAnswer(3) }
        btnOption2.setOnClickListener { checkAnswer(1) }
        btnOption3.setOnClickListener { checkAnswer(4) }
        btnOption4.setOnClickListener { checkAnswer(2) }
        homebacklevel1.setOnClickListener {
            finish()
        }

        // Inicia el juego mostrando la primera imagen
        showNextImage()
    }

    private fun showNextImage() {

        currentImageIndex = (0 until 4).random()
        val drawableId = when (currentImageIndex) {
            0 -> R.drawable.img1conill
            1 -> R.drawable.img2conills
            2 -> R.drawable.img3conills
            3 -> R.drawable.img4conills
            else -> true
        }

        imageView.setImageDrawable(ContextCompat.getDrawable(this, drawableId as Int))

        // Asigna opciones de respuesta a botones
        btnOption1.tag = 1
        btnOption2.tag = 2
        btnOption3.tag = 3
        btnOption4.tag = 4

        btnOption1.isEnabled = true
        btnOption2.isEnabled = true
        btnOption3.isEnabled = true
        btnOption4.isEnabled = true
    }

    private fun checkAnswer(selectedOption: Int) {
        // Verifica l¡opcio correcta
        val correctAnswer = correctAnswers[currentImageIndex]

        if (selectedOption == correctAnswer) {
            // si la resposta es correcta augmenta el contador fins que arribi a 5, si arriba mostra el dialogue
            contador++
            contadorTextView.text = contador.toString()
        } else {

            contadorTextView.text = contador.toString()
        }
        if (contador == 5) {
            showGameWonDialog()
        } else {

            showNextImage()
        }
    }
//dialogue que mostra que has guanyat
    private fun showGameWonDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.dialogueCongratulations)
        builder.setMessage(R.string.dialogueYouWin)
        builder.setPositiveButton(R.string.dialoguereturnmap) { dialog, _ ->
            GlobalScope.launch {
                ((applicationContext as App).db).settingsDao().updateIsdone(5)
            }
            finish()
            dialog.dismiss()
        }
        builder.setCancelable(false)
        builder.create().show()
    }
}


