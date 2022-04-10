package com.pe5ha.homework

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class ReceiverFragment : Fragment() {

    companion object {
        private const val MESSAGE_TEXT_KEY = "MESSAGE_TEXT_KEY"
        fun newInstance(message: String) =
            ReceiverFragment().apply {
                arguments = Bundle().apply {
                    putString(MESSAGE_TEXT_KEY, message)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_receiver, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val messageView = view.findViewById<TextView>(R.id.messageText)
        val viewModel = ViewModelProvider(this).get(ReceiverFragmentViewModel::class.java)
        viewModel.messageTextMutableLiveData.observe(viewLifecycleOwner) { text ->
            messageView.text = text
        }
        viewModel.messageTextStyleMLD.observe(viewLifecycleOwner) { style ->
            messageView.setTypeface(messageView.typeface, style)
        }
        if (savedInstanceState == null)
            viewModel.messageTextMutableLiveData.value = arguments?.getString(MESSAGE_TEXT_KEY)
        view.findViewById<Button>(R.id.receiver_read_button).setOnClickListener {
            viewModel.messageTextMutableLiveData.value = getString(R.string.messages_is_read_hint)
            viewModel.messageTextStyleMLD.value = Typeface.ITALIC
        }
    }
}