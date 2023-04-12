package com.example.testing

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mPlayerName : String? = null
    private var mCorrectAnswers: Int = 0


    private var progressBar : ProgressBar? = null
    private var textViewProgress : TextView? = null
    private var textViewQuestion : TextView? = null
    private var imageViewImage : ImageView? = null

    private var textViewOptionOne : TextView? = null
    private var textViewOptionTwo : TextView? = null
    private var textViewOptionThree : TextView? = null
    private var textViewOptionFour : TextView? = null

    private var buttonSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mPlayerName = intent.getStringExtra(Constants.PLAYER_NAME)

        progressBar = findViewById(R.id.progressBar)
        textViewProgress = findViewById(R.id.textView_progress)
        textViewQuestion = findViewById(R.id.textView_question)
        imageViewImage = findViewById(R.id.imageView_image)

        textViewOptionOne = findViewById(R.id.textView_optionOne)
        textViewOptionTwo = findViewById(R.id.textView_optionTwo)
        textViewOptionThree = findViewById(R.id.textView_optionThree)
        textViewOptionFour = findViewById(R.id.textView_optionFour)

        buttonSubmit = findViewById(R.id.buttonSubmit)

        textViewOptionOne?.setOnClickListener(this)
        textViewOptionTwo?.setOnClickListener(this)
        textViewOptionThree?.setOnClickListener(this)
        textViewOptionFour?.setOnClickListener(this)

        buttonSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()

        setQuestion()
    }

    private fun setQuestion() {

        defaultOptionsView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        imageViewImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        textViewProgress?.text = "$mCurrentPosition / ${progressBar?.max}"
        textViewQuestion?.text = question.question
        textViewOptionOne?.text = question.optionOne
        textViewOptionTwo?.text = question.optionTwo
        textViewOptionThree?.text = question.optionThree
        textViewOptionFour?.text = question.optionFour

        if(mCurrentPosition == mQuestionList!!.size) {
            buttonSubmit?.text = "FINISH"
        } else {
            buttonSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        textViewOptionOne?.let {
            options.add(0, it)
        }
        textViewOptionTwo?.let {
            options.add(1, it)
        }
        textViewOptionThree?.let {
            options.add(2, it)
        }
        textViewOptionFour?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8090"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectOptionView(tv:TextView, selectedOptionNum:Int) {
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_background
        )
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.textView_optionOne -> {
                textViewOptionOne?.let{
                    selectOptionView(it, 1)
                }
            }
            R.id.textView_optionTwo -> {
                textViewOptionTwo?.let{
                    selectOptionView(it, 2)
                }
            }
            R.id.textView_optionThree -> {
                textViewOptionThree?.let{
                    selectOptionView(it, 3)
                }
            }
            R.id.textView_optionFour -> {
                textViewOptionFour?.let{
                    selectOptionView(it, 4)
                }
            }
            R.id.buttonSubmit ->{
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.PLAYER_NAME, mPlayerName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionList!!.size) {
                        buttonSubmit?.text = "FINISH"
                    } else {
                        buttonSubmit?.text = "Go to next question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> {
                textViewOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                textViewOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                textViewOptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                textViewOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }

}