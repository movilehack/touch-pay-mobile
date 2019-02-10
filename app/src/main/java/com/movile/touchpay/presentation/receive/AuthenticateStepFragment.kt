package com.movile.touchpay.presentation.receive

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.movile.touchpay.R
import kotlinx.android.synthetic.main.fragment_authenticate_step.*
import java.lang.StringBuilder


class AuthenticateStepFragment : Fragment() {

    private var listener: AuthenticateStepListener? = null

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btnClear: Button
    private var pinText: StringBuilder = StringBuilder()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_authenticate_step, container, false)

        btn1 = root.findViewById(R.id.button1)
        btn2 = root.findViewById(R.id.button2)
        btn3 = root.findViewById(R.id.button3)
        btn4 = root.findViewById(R.id.button4)
        btn5 = root.findViewById(R.id.button5)
        btnClear = root.findViewById(R.id.btnClear)

        btn1.setOnClickListener {
            pinText.append(1)
            edtxtPin.setText(pinText.toString())
            edtxtPin.setSelection(pinText.length)
        }
        btn2.setOnClickListener {
            pinText.append(1)
            edtxtPin.setText(pinText.toString())
            edtxtPin.setSelection(pinText.length)
        }
        btn3.setOnClickListener {
            pinText.append(1)
            edtxtPin.setText(pinText.toString())
            edtxtPin.setSelection(pinText.length)
        }
        btn4.setOnClickListener {
            pinText.append(1)
            edtxtPin.setText(pinText.toString())
            edtxtPin.setSelection(pinText.length)
        }
        btn5.setOnClickListener {
            pinText.append(1)
            edtxtPin.setText(pinText.toString())
            edtxtPin.setSelection(pinText.length)
        }
        btnClear.setOnClickListener {
            pinText.clear()
            edtxtPin.setText("")
        }

        return root
    }

    fun onNextStep() {
        listener?.onAuthenticateStepInteraction()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AuthenticateStepListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement AuthenticateStepListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface AuthenticateStepListener {
        fun onAuthenticateStepInteraction()
    }

    companion object {
        @JvmStatic
        fun newInstance() = AuthenticateStepFragment()
    }
}
