package com.killkinto.mytrip

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_calculate) {
            handleCalculete()
        }
    }

    private fun handleCalculete() {
        if (isValid()) {
            try {
                val result = ((edit_distance.text.toString().toFloat() * edit_price.text.toString().toFloat())
                    / edit_autonomy.text.toString().toFloat())
                text_result.text = "Total: R$ $result"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.values_invalid), Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, getString(R.string.values_invalid), Toast.LENGTH_LONG).show()
        }
    }

    private fun isValid(): Boolean {
        return edit_distance.text.toString().isNotEmpty()
                && edit_price.text.toString().isNotEmpty()
                && edit_autonomy.text.toString().isNotEmpty()
                && edit_autonomy.text.toString() != "0"
    }

}
