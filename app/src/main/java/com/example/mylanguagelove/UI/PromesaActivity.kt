package com.example.mylanguagelove.UI

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.mylanguagelove.R
import com.example.mylanguagelove.databinding.ActivityMainBinding




class PromesaActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private val textToType = "¿Quieres casarte conmigo?"
    private var alertDialog: AlertDialog? = null
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var imgBoda: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promesa)

        imgBoda = findViewById(R.id.imgBoda)

        var fadeInAnimation = AnimationUtils.loadAnimation(
            this, R.anim.fade_in
        )

        imgBoda.startAnimation(fadeInAnimation)

        mediaPlayer = MediaPlayer.create(this, R.raw.musica)
        mediaPlayer?.isLooping = true //Repetir la musica
        mediaPlayer?.start()//

        textView = findViewById(R.id.textView)


        typeWriteEffect()

    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    //Efecto Maquina de Escribir
    private fun typeWriteEffect() {
        val handler = Handler(Looper.getMainLooper())
        var index = 0

        handler.post(object  : Runnable {
            override fun run() {
                if(index < textToType.length) {
                    val currentText = textToType.substring(0, index + 1)
                    textView.text = currentText
                    index++
                    handler.postDelayed(this, 140)
                } else {
                    mostrarAlertaDialog()
                }
            }
        })

    }

    private fun mostrarAlertaDialog() {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("DI QUE SI , DI QUE SI, DI QUE SI")
        builder.setMessage("Espero tu respuesta")
        builder.setPositiveButton("Si") { _, _ ->
            showToast("Gracias por querer compartir tu vida conmigo! Te amo demasiado!")
        }

        builder.setNegativeButton("No") { _, _ ->
            showWaitDialog()

        }

        alertDialog = builder.create()
        alertDialog?.show()
    }

    private fun showWaitDialog() {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Responde que shiii si? :c")
        builder.setMessage("Responde que si ya >:(")
        builder.setPositiveButton("Ok") { _, _ ->
            alertDialog?.show()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }



}