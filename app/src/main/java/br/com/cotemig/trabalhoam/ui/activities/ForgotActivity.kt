package br.com.cotemig.trabalhoam.ui.activities

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

class ForgotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        var emailText = intent.getStringExtra("email")

        var email = findViewById<EditText>(R.id.email)
        email.setText(emailText)

        var sendPassword = findViewById<Button>(R.id.sendPassword)
        sendPassword.setOnClickListener {
            sendPassword(email.text.toString())
        }

    }

    fun sendPassword(email: String) {

        var account = Account()
        account.email = email

        var s = RetrofitInitializer().accountService()
        var call = s.forgot(account)

        call.enqueue(object : retrofit2.Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.code() == 204) { // sucesso, enviou a senha por email
                    // TODO: definir mensagens
                } else if (response.code() == 404) { // usuário não existe
                    // TODO: definir mensagens
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                MaterialDialog.Builder(this@ForgotActivity)
                    .theme(Theme.LIGHT)
                    .title(R.string.ops)
                    .content(R.string.generic_error)
                    .positiveText(R.string.button_ok)
                    .show()
            }
        })

    }
}