package net.alerok.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.alerok.motivation.R
import net.alerok.motivation.infra.MotivationConstants
import net.alerok.motivation.infra.SecurityPreferences
import net.alerok.motivation.repository.Mock

class MainActivity : AppCompatActivity() {

    private lateinit var securityPreferences: SecurityPreferences
    private var phraseFilter : Int = MotivationConstants.QUOTEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        securityPreferences = SecurityPreferences(applicationContext)

        textViewName.text =
            getString(R.string.greetings) + " " + securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME) + "!"

        //Start logic
        imageViewAll.setColorFilter(resources.getColor(R.color.colorAccent))
        handleNewQuote()

        buttonNewQuote.setOnClickListener() {
            handleNewQuote()
        }

        imageViewAll.setOnClickListener() {
            handleFilter(MotivationConstants.QUOTEFILTER.ALL)
        }

        imageViewHappy.setOnClickListener() {
            handleFilter(MotivationConstants.QUOTEFILTER.HAPPY)
        }

        imageViewSad.setOnClickListener() {
            handleFilter(MotivationConstants.QUOTEFILTER.SAD)
        }
    }

    private fun handleFilter(id: Int) {
        imageViewAll.setColorFilter(resources.getColor(R.color.white))
        imageViewHappy.setColorFilter(resources.getColor(R.color.white))
        imageViewSad.setColorFilter(resources.getColor(R.color.white))

        when (id) {
            1 -> {
                imageViewAll.setColorFilter(resources.getColor(R.color.colorAccent))
                phraseFilter = MotivationConstants.QUOTEFILTER.ALL
            }

            2 -> {
                imageViewHappy.setColorFilter(resources.getColor(R.color.colorAccent))
                phraseFilter = MotivationConstants.QUOTEFILTER.HAPPY
            }

            3 -> {
                imageViewSad.setColorFilter(resources.getColor(R.color.colorAccent))
                phraseFilter = MotivationConstants.QUOTEFILTER.SAD
            }
        }
    }

    private fun handleNewQuote() {
        val phrase = Mock().getPhrase(phraseFilter)
        textViewQuote.text = phrase
    }
}