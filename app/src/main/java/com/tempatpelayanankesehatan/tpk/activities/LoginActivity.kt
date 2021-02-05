package com.tempatpelayanankesehatan.tpk.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tempatpelayanankesehatan.tpk.R
import com.tempatpelayanankesehatan.tpk.RegisterActivity
import com.tempatpelayanankesehatan.tpk.network.ApiConfig.Companion.apiUser
import com.tempatpelayanankesehatan.tpk.network.model.User
import com.tempatpelayanankesehatan.tpk.util.Session
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Session.init(applicationContext)

        btnRegLogin.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
        }

        buttonLogin.setOnClickListener {
            val user = User(
                    email = txt_email.text.toString(),
                    password = txt_password.text.toString()
            )

            GlobalScope.launch(Dispatchers.IO) {
                val response = apiUser.login(user)

                if (response.isSuccessful) {
                    response.body()?.data?.let { user ->
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@LoginActivity, "Berhasil Login", Toast.LENGTH_SHORT).show()

                            Session.bearer = user.idUser

                            startActivity(
                                    Intent(this@LoginActivity, MainActivity::class.java)
                            )
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@LoginActivity, "Gagal Login", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
