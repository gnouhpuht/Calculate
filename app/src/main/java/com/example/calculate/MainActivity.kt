package com.example.calculate

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.KeyEvent.KEYCODE_DEL
import android.view.inputmethod.BaseInputConnection
import android.view.KeyEvent
import java.text.DecimalFormat
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    private var arrOperation: ArrayList<String> = ArrayList()
    private var arrNumber: ArrayList<Double> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onclickBtn()

    }

    @SuppressLint("SetTextI18n")
    private fun onclickBtn() {
        deleteBtn.setOnClickListener {
            showResultTxt.text = "0"
            performCalculationTxt.text = ""
        }
        zeroBtn.setOnClickListener {
            showResultTxt.append("0")
            performCalculationTxt.append("0")
        }
        oneBtn.setOnClickListener {
            if (showResultTxt.text.toString().equals("0")){
                showResultTxt.text = "1"
            }else{
                showResultTxt.append("1")
            }
            performCalculationTxt.append("1")
        }
        twoBtn.setOnClickListener {
            if (showResultTxt.text.toString().equals("0")){
                showResultTxt.text = "2"
            }else{
                showResultTxt.append("2")
            }
            performCalculationTxt.append("2")
        }
        threeBtn.setOnClickListener {
            if (showResultTxt.text.toString().equals("0")){
                showResultTxt.text = "3"
            }else{
                showResultTxt.append("3")
            }
            performCalculationTxt.append("3")
        }
        fourBtn.setOnClickListener {
            if (showResultTxt.text.toString().equals("0")){
                showResultTxt.text = "4"
            }else{
                showResultTxt.append("4")
            }
            performCalculationTxt.append("4")
        }
        fiveBtn.setOnClickListener {
            if (showResultTxt.text.toString().equals("0")){
                showResultTxt.text = "5"
            }else{
                showResultTxt.append("5")
            }
            performCalculationTxt.append("5")
        }
        sixBtn.setOnClickListener {
            if (showResultTxt.text.toString().equals("0")){
                showResultTxt.text = "6"
            }else{
                showResultTxt.append("6")
            }
            performCalculationTxt.append("6")
        }
        sevenBtn.setOnClickListener {
            if (showResultTxt.text.toString().equals("0")){
                showResultTxt.text = "7"
            }else{
                showResultTxt.append("7")
            }
            performCalculationTxt.append("7")
        }
        eightBtn.setOnClickListener {
            if (showResultTxt.text.toString().equals("0")){
                showResultTxt.text = "8"
            }else{
                showResultTxt.append("8")
            }
            performCalculationTxt.append("8")
        }
        nineBtn.setOnClickListener {
            if (showResultTxt.text.toString().equals("0")){
                showResultTxt.text = "9"
            }else{
                showResultTxt.append("9")
            }
            performCalculationTxt.append("9")
        }
        doubleZeroBtn.setOnClickListener {
            if (showResultTxt.text.toString().equals("0")){
                showResultTxt.text = "0"
            }else{
                showResultTxt.append("00")
            }
            performCalculationTxt.append("00")
        }
        plusBtn.setOnClickListener {
            performCalculationTxt.append("+")
            showResultTxt.text = ""
        }
        minusBtn.setOnClickListener {
            performCalculationTxt.append("-")
            showResultTxt.text = ""
        }
        multiplyBtn.setOnClickListener {
            performCalculationTxt.append("x")
            showResultTxt.text = ""
        }
        divisionBtn.setOnClickListener {
            performCalculationTxt.append("/")
            showResultTxt.text = ""
        }
        percentBtn.setOnClickListener {
            performCalculationTxt.append("%")
            showResultTxt.text = ""
        }

        clearBtn.setOnClickListener {
            val textFieldInputConnection = BaseInputConnection(performCalculationTxt, true)
            textFieldInputConnection.sendKeyEvent(
                KeyEvent(
                    KeyEvent.ACTION_DOWN,
                    KEYCODE_DEL
                )
            )
        }
        resultBtn.setOnClickListener {
            val decimalFormat = DecimalFormat("###.#######")
            var result = 0.0

            addOperation(performCalculationTxt.text.toString())
            addNumber(performCalculationTxt.text.toString())
            if (arrOperation.size >= arrNumber.size || arrOperation.size < 1) {
                showResultTxt.text = "Lỗi định dạng"
            } else {
                for (i in 0 until arrNumber.size - 1) {
                    when (arrOperation[i]) {
                        "+" -> if (i == 0) {
                            result = arrNumber[i] + arrNumber[i + 1]
                        } else {
                            result += arrNumber[i + 1]
                        }
                        "-" -> if (i == 0) {
                            result = arrNumber[i] - arrNumber[i + 1]
                        } else {
                            result -= arrNumber[i + 1]
                        }
                        "x" -> if (i == 0) {
                            result = arrNumber[i] * arrNumber[i + 1]
                        } else {
                            result *= arrNumber[i + 1]
                        }
                        "/" -> if (i == 0) {
                            result = arrNumber[i] / arrNumber[i + 1]
                        } else {
                            result /= arrNumber[i + 1]
                        }
                        else -> {
                        }
                    }
                }
                showResultTxt.text = decimalFormat.format(result) + ""
            }
        }
    }

    private fun addOperation(input: String): Int {
        val cArray = input.toCharArray()
        for (i in cArray.indices) {
            when (cArray[i]) {
                '+' -> arrOperation.add(cArray[i] + "")
                '-' -> arrOperation.add(cArray[i] + "")
                'x' -> arrOperation.add(cArray[i] + "")
                '/' -> arrOperation.add(cArray[i] + "")
                else -> {
                }
            }
        }
        return 0
    }

    private fun addNumber(input: String) {
        val regex = Pattern.compile("(\\d+(?:\\.\\d+)?)")
        val matcher = regex.matcher(input)
        while (matcher.find()) {
            arrNumber.add(java.lang.Double.valueOf(matcher.group(1)))
        }
    }
}
