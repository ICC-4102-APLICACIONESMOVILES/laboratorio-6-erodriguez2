package com.example.eduardo.lab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.jetbrains.anko.find
import java.util.regex.Pattern
import android.content.Intent
import android.app.Activity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    private lateinit var signInButton: Button
    private lateinit var userContent: EditText
    private lateinit var userPasswordContent: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUIReferences()
        setupListeners()
    }

    private fun getUIReferences(){
        signInButton = find(R.id.signInButton)
        userContent = find(R.id.userEmailEditText)
        userPasswordContent = find(R.id.passwordEmailEditText)
    }

    private fun setupListeners(){
        signInButton.setOnClickListener {
            if(isEmailValid(userContent.text.toString())){
                NetworkManager.getInstance(this).login(
                        userContent.text.toString(),
                        userPasswordContent.text.toString(),
                        {response ->
                            val headers = response.optJSONObject("headers")
                            val token = headers.optString("Authorization", "")
                            Toast.makeText(this, token.toString(), Toast.LENGTH_SHORT).show()
                            val returnIntent = Intent()
                            returnIntent.putExtra("userToken", token)
                            setResult(Activity.RESULT_CANCELED, returnIntent)
                            finish()
                        },
                        {
                            Toast.makeText(this, R.string.wrong_credentials, Toast.LENGTH_SHORT).show()
                        }
                )
            }
            else{
                Toast.makeText(this, "User Not Format Valid", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }
}
