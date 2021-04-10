package net.alerok.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_splash.*
import net.alerok.motivation.R
import net.alerok.motivation.infra.MotivationConstants
import net.alerok.motivation.infra.SecurityPreferences

class SplashActivity : AppCompatActivity() {

    private lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        securityPreferences = SecurityPreferences(applicationContext)

        verifyName()

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        buttonSave.setOnClickListener() {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = editTextName.text.toString()

        if (name != "") {
            securityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(applicationContext, MainActivity::class.java))

            //If you don't want to maintain the SplashActivity, remove the comment below this part
            //finish()
        } else {
            Toast.makeText(applicationContext, getString(R.string.error_inform_username), Toast.LENGTH_SHORT).show()
        }
    }

    private fun verifyName() {
        val name = securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        if (name != "") {
            startActivity(Intent(applicationContext, MainActivity::class.java))

            //If you don't want to maintain the SplashActivity, remove the comment below this part
            //finish()
        }
    }
}