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
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

        var create = findViewById<Button>(R.id.create)

        create.setOnClickListener {
            createAccount()
        }

    }

    fun createAccount() {

        var account = Account()
        account.name = "Dirceu Belém"
        account.email = email.text.toString()
        account.password = password.text.toString()

        var s = RetrofitInitializer().accountService()
        var call = s.create(account)

        call.enqueue(object : retrofit2.Callback<Account> {
            override fun onResponse(call: Call<Account>, response: Response<Account>) {

                if (response.code() == 200) {
                    MaterialDialog.Builder(this@RegisterActivity)
                        .theme(Theme.LIGHT)
                        .title(R.string.success)
                        .content(R.string.success_message)
                        .positiveText(R.string.button_ok)
                        .show()

                } else if (response.code() == 409) {
                    MaterialDialog.Builder(this@RegisterActivity)
                        .theme(Theme.LIGHT)
                        .title(R.string.ops)
                        .content(R.string.user_reset_message)
                        .positiveText(R.string.button_yes)
                        .onPositive { dialog, which ->
                            showForgot()
                        }
                        .negativeText(R.string.button_no)
                        .show()
                }

            }

            override fun onFailure(call: Call<Account>, t: Throwable) {
                MaterialDialog.Builder(this@RegisterActivity)
                    .theme(Theme.LIGHT)
                    .title(R.string.ops)
                    .content(R.string.generic_error)
                    .positiveText(R.string.button_ok)
                    .show()
            }
        })

    }

    fun showForgot() {
        var intent = Intent(this, ForgotActivity::class.java)
        intent.putExtra("email", email.text.toString())
        startActivity(intent)
        finish()
    }
}