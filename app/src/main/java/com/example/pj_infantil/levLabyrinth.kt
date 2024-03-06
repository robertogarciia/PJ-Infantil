package com.example.pj_infantil

import android.content.Context
import android.content.Intent
import android.graphics.*
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class levLabyrinth : AppCompatActivity() {

    private lateinit var homebacklevel3 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.levlabyrinth)

        homebacklevel3 = findViewById(R.id.HomeBackLevelMenuLabyrinth)

        homebacklevel3.setOnClickListener {
            val intent = Intent(this, MapLevels::class.java)
            startActivity(intent)
        }

            // Obtenir la referència de la vista "DrawingView"
            val drawingView = findViewById<DrawingView>(R.id.dibuixar)

            // Verificar si s'ha dibuixat alguna cosa a la vista

        }


    class DrawingView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
        private var path = Path()
        private var drawPaint = Paint()

        init {
            setupPaint()
        }

        private fun setupPaint() {
            drawPaint.apply {
                color = Color.BLACK
                isAntiAlias = true
                strokeWidth = 10f
                style = Paint.Style.STROKE
                strokeJoin = Paint.Join.ROUND
                strokeCap = Paint.Cap.ROUND
            }
        }

        override fun onDraw(canvas: Canvas) {
            canvas.drawPath(path, drawPaint)
        }

        override fun onTouchEvent(event: MotionEvent): Boolean {
            val xPos = event.x
            val yPos = event.y

            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    path.moveTo(xPos, yPos)
                    return true
                }

                MotionEvent.ACTION_MOVE -> {
                    path.lineTo(xPos, yPos)

                    // Verificar si la linea esta dins el rang
                    if (isLineInRange(xPos, yPos)) {
                        showGameWonDialog()
                    }
                }

                else -> return false
            }

            // Invalidar la vista per forçar el redibuix
            invalidate()
            return true
        }

        private fun isLineInRange(xPos: Float, yPos: Float): Boolean {
            // si l'usuari entra a aquest rang surt el dialogue per que has guanyat per facilitar el joc
            val minX = 1750f
            val maxX = 2000f
            val minYX = 750f
            val maxYX = 1200f

            // Verificar si la línea esta dins els rangs especificats
            return xPos in minX..maxX && yPos >= minYX && yPos <= maxYX
        }
        private fun showGameWonDialog() {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(R.string.dialogueCongratulations)
            builder.setMessage(R.string.dialogueYouWin)
            builder.setPositiveButton(R.string.dialoguereturnmap) { dialog, _ ->
                val intent = Intent(context, MapLevels::class.java)
                context.startActivity(intent)
                dialog.dismiss()
            }
            builder.setCancelable(false)
            builder.create().show()
        }

        fun hasDrawn(): Boolean {
            // Comprova si s'ha dibuixat alguna cosa
            return !path.isEmpty
        }
    }
}

