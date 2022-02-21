package ru.skillbranch.qestion1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.skillbranch.qestion1.R
import ru.skillbranch.qestion1.databinding.FragmentResultBinding
import ru.skillbranch.qestion1.falseAnswerSize
import ru.skillbranch.qestion1.trueAnswerSize


class ResultFragment : Fragment() {

    lateinit var binding: FragmentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentResultBinding.inflate(layoutInflater)

        binding.tvTrue.text = "TRUE ${trueAnswerSize.toString()}"
        binding.tvFalse.text = "FALSE ${falseAnswerSize.toString()}"
        binding.textViewCountEblan.text = countEblan()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root

    }

    private fun countEblan():String = when(falseAnswerSize){
        0 -> "0% еблан"
        1 -> "20% еблан"
        2 -> "40% еблан"
        3 -> "60% еблан"
        4 -> "80% еблан"
        5 -> "100% еблан"
        else -> "200% еблан"
    }




}