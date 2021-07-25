package com.example.todofibraoptc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isInvisible
import com.example.todofibraoptc.databinding.ActivityLoginBinding
import kotlinx.coroutines.delay
import kotlin.concurrent.thread

class LoginActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnlogin.setOnClickListener(this)
        binding.btnregistreteaqui.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnlogin ->{
                if (UtilsNetwork().isOnline(this)){
                    logeoUser()
                }else{
                    alertDialog("debes conectarte a internet para ingresar al sistemas ")
                }
            }
            R.id.btnregistreteaqui ->{
                startActivity(Intent(this,RegistroUserActivity::class.java))
                finish()
            }
        }
    }


    private fun logeoUser() {
        changeLoginshowForm(false)
        Toast.makeText(this,"Logeate ",Toast.LENGTH_SHORT).show()

    }

    private fun changeLoginshowForm(showForm:Boolean) {
        if (!showForm){
            binding.progressBarlogin.isInvisible = false
            binding.cardViewlogind.isInvisible = true
        }else{
            binding.progressBarlogin.isInvisible = true
            binding.cardViewlogind.isInvisible = false
        }
    }
    private fun alertDialog(s: String) {
        changeLoginshowForm(false)
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Precacion!!")
        builder.setMessage(s)

        val dialog = builder.create()
        dialog.show()
    }
}
