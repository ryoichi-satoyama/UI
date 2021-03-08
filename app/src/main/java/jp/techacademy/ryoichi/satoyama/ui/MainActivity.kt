package jp.techacademy.ryoichi.satoyama.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.text = "ボタン"
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.button1 -> textView.text = editText.text.toString()
            R.id.button2 -> showAlertDialog()
            R.id.button3 -> showTimePickerDialog()
            R.id.button4 -> showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{
                view, year, month, dayOfMonth -> Log.d("UI_PARTS", "$year/${month+1}/$dayOfMonth")
            },2018, 4, 1
        )
        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener {
                view, hour, minute -> Log.d("UI_PARTS", "$hour:$minute")
            },
            13,0, true)
        timePickerDialog.show()
    }

    private fun showAlertDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("タイトル")
        alertDialogBuilder.setMessage("メッセージ")

        alertDialogBuilder.setPositiveButton("肯定") {
            dialog, which -> Log.d("UI_PARTS", "肯定ボタン")
        }

        alertDialogBuilder.setNeutralButton("中立") {
            _, _ -> Log.d("UI_PARTS", "中立ボタン")
        }

        alertDialogBuilder.setNegativeButton("否定") {
            _, _ ->  Log.d("UI_PARTS", "否定ボタン")
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

}