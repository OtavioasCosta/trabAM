package br.com.cotemig.trabalhoam.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.cotemig.trabalhoam.R
import br.com.cotemig.trabalhoam.model.Account
import br.com.cotemig.trabalhoam.services.RetrofitInitializer
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.Theme
import retrofit2.Call
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var login = findViewById<Button>(R.id.login)



        login.setOnClickListener {

                var intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
        }

        var register = findViewById<Button>(R.id.register)
        register.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        var forgot = findViewById<Button>(R.id.forgot)
        forgot.setOnClickListener {
            var intent = Intent(this, ForgotActivity::class.java)
            startActivity(intent)
        }

    }
}