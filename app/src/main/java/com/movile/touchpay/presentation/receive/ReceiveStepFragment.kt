package com.movile.touchpay.presentation.receive

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.movile.touchpay.R


class ReceiveStepFragment : Fragment() {

    private var listener: ReceiveStepListener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_receive_step, container, false)
    }

    fun onNextStep() {
        listener?.onReceiveStepInteraction()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ReceiveStepListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface ReceiveStepListener {
        fun onReceiveStepInteraction()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ReceiveStepFragment()
    }
}
