package com.pe5ha.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SenderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sender, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editText = view.findViewById<EditText>(R.id.editText)
        val button = view.findViewById<Button>(R.id.sender_button)
        button?.setOnClickListener {
            Toast.makeText(activity?.applicationContext, editText.text, Toast.LENGTH_SHORT).show()
            showReceiverFragment(editText.text.toString())
        }
    }

    private fun showReceiverFragment(textForFragment: String) {
        val receiverFragment = ReceiverFragment.newInstance(textForFragment)
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_activity, receiverFragment)
            .addToBackStack(null)
            .commit()
    }
}