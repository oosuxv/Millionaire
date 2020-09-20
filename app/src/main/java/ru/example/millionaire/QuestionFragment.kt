package ru.example.millionaire

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.snackbar.Snackbar
import ru.example.millionaire.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!
    private lateinit var question: Question
    private val questionViewModel: QuestionViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        question = questionViewModel.getLastAskedQuestion()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onStart() {
        super.onStart()
        setText()
        binding.buttonA.setOnClickListener { checkAnswer(0) }
        binding.buttonB.setOnClickListener { checkAnswer(1) }
        binding.buttonC.setOnClickListener { checkAnswer(2) }
        binding.buttonD.setOnClickListener { checkAnswer(3) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setText() {
        binding.questionTextView.setText(question.text)
        binding.levelTextView.setText(getString(R.string.level, question.level))
        binding.buttonA.setText(getString(R.string.button_a, question.choices[0]))
        binding.buttonB.setText(getString(R.string.button_b, question.choices[1]))
        binding.buttonC.setText(getString(R.string.button_c, question.choices[2]))
        binding.buttonD.setText(getString(R.string.button_d, question.choices[3]))
    }

    private fun checkAnswer(buttonNum: Int) {
        if (question.answer == buttonNum) {
            Snackbar.make(binding.root, R.string.right_answer, Snackbar.LENGTH_LONG).show();
            question = questionViewModel.getNextQuestion()
        } else {
            Snackbar.make(binding.root, R.string.wrong_answer, Snackbar.LENGTH_LONG).show();
            question = questionViewModel.getFirstQuestion()
        }
        setText()
    }
}