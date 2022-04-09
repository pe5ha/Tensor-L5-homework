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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_receiver, container, false)
        val messageView = view.findViewById<TextView>(R.id.messageText)

        // вью модель для хранения данных фрагмента
        val viewModel = ViewModelProvider(this).get(ReceiverFragmentViewModel::class.java)
        viewModel.messageTextMutableLiveData.observe(viewLifecycleOwner) { text ->
            messageView.text = text
        }
        viewModel.messageTextStyleMLD.observe(viewLifecycleOwner) { style ->
            messageView.setTypeface(messageView.typeface, style)
        }

        // receiver text from bundle
        viewModel.messageTextMutableLiveData.value = arguments?.getString(MESSAGE_TEXT_KEY)

        // при нажатии кнопки данные сохраняются в вью модель в мутабл дата, а они в свою очередь триггерят изменение вью
        view.findViewById<Button>(R.id.receiver_read_button).setOnClickListener {
            viewModel.messageTextMutableLiveData.value = getString(R.string.messages_is_read_hint)
            viewModel.messageTextStyleMLD.value = Typeface.ITALIC
        }

//        messageView.text = viewModel.messageTextLiveData.toString()
//        messageView.setTypeface(messageView.typeface, viewModel.messageTextStyleLiveData.value!!)
//
//        messageText?.let { text -> messageView.text = text }

//        view.findViewById<Button>(R.id.receiver_read_button).setOnClickListener {
//            messageView.text = getString(R.string.messages_is_read_hint)
//            messageView.setTypeface(messageView.typeface,Typeface.ITALIC)
//        }

        return view
    }
}