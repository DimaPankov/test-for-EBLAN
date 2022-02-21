package ru.skillbranch.qestion1.view.qestionFrafment

import android.os.Bundle
import android.os.CountDownTimer

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import ru.skillbranch.qestion1.*
import ru.skillbranch.qestion1.databinding.FragmentQestionBinding

import ru.skillbranch.qestion1.viewModel.qestionViewModel.questionModel

class qestionFragment : Fragment() {
    lateinit var binding: FragmentQestionBinding
    lateinit var quizViewModel: questionModel
    var actionFragment = false





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
           setView()
        setClickListner()
    }

    private fun setClickListner(){
        binding.btnTrue.setOnClickListener {
            clickTrue()
        }

        binding.btnFalse.setOnClickListener {
            clickFalse()
        }
    }

    private fun setView(){
        quizViewModel = ViewModelProvider(this).get(questionModel::class.java)
        binding = FragmentQestionBinding.inflate(layoutInflater)
        binding.tvQestion.setText(quizViewModel.Data().textResId)
        binding.imageQestion.setImageResource(quizViewModel.Data().imageResId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root


    }

    private fun clickTrue() {
        quizViewModel.moveData()
        binding.imageQestion.setImageResource(quizViewModel.Data().imageResId)
        binding.tvQestion.setText(quizViewModel.Data().textResId)

        if (quizViewModel.answer()) {
            trueAnswerSize++
            binding.imageQestion.isVisible = false
            binding.frameLayout.setBackgroundColor(resources.getColor(R.color.teal_200))
            binding.tvQestion.isVisible = false
            binding.background.setBackgroundColor(resources.getColor(R.color.teal_200))
            binding.btnTrue.isVisible = false
            binding.btnFalse.isVisible = false
            binding.textViewTRUE.isVisible = true

        } else {
        falseAnswerSize++
        binding.imageQestion.isVisible = false
        binding.frameLayout.setBackgroundColor(resources.getColor(R.color.red))
        binding.tvQestion.isVisible = false
        binding.background.setBackgroundColor(resources.getColor(R.color.red))
        binding.btnTrue.isVisible = false
        binding.btnFalse.isVisible = false
        binding.textViewFALSE.isVisible = true

    }

        finish(1000L)

}



    private fun clickFalse() {


        quizViewModel.moveData()

        binding.imageQestion.setImageResource(quizViewModel.Data().imageResId)
        binding.tvQestion.setText(quizViewModel.Data().textResId)

        if (!quizViewModel.answer()) {
           trueAnswerSize++
            binding.imageQestion.isVisible = false
            binding.frameLayout.setBackgroundColor(resources.getColor(R.color.teal_200))
            binding.tvQestion.isVisible =  false
            binding.background.setBackgroundColor(resources.getColor(R.color.teal_200))
            binding.btnTrue.isVisible = false
            binding.btnFalse.isVisible = false
            binding.textViewTRUE.isVisible = true
        } else {
            falseAnswerSize++
            binding.imageQestion.isVisible = false
            binding.frameLayout.setBackgroundColor(resources.getColor(R.color.red))
            binding.tvQestion.isVisible =  false
            binding.background.setBackgroundColor(resources.getColor(R.color.red))
            binding.btnTrue.isVisible = false
            binding.btnFalse.isVisible = false
            binding.textViewFALSE.isVisible = true


        }
      finish(1000L)

            }





    private fun finish( sec:Long ){

        object : CountDownTimer(sec, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                binding.imageQestion.isVisible = true
                binding.frameLayout.setBackgroundColor(resources.getColor(R.color.white))
                binding.tvQestion.isVisible =  true
                binding.background.setBackgroundColor(resources.getColor(R.color.white))
                binding.btnTrue.isVisible = true
                binding.btnFalse.isVisible = true
                binding.textViewTRUE.isVisible = false
                binding.textViewFALSE.isVisible = false

                if(actionFragment) {
                    MAIN.navController.navigate(R.id.action_qestionFragment_to_resultFragment)
                }

                if(quizViewModel.index == 9) {
                    actionFragment = true
                }



            }
        }.start()

        if(actionFragment){
            object : CountDownTimer(5000, 1000) {
                override fun onTick(millisUntilFinished: Long) {}

                override fun onFinish() {
                    MAIN.navController.navigate(R.id.action_resultFragment_to_qestionFragment)
                   trueAnswerSize = 0
                   falseAnswerSize = 0
                }
            }.start()
        }

    }
    }
