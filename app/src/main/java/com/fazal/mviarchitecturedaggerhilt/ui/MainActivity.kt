package com.fazal.mviarchitecturedaggerhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.fazal.mviarchitecturedaggerhilt.R
import com.fazal.mviarchitecturedaggerhilt.model.Blog
import com.fazal.mviarchitecturedaggerhilt.utils.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.setStateEvent(MainStateEvents.GetBlogEvents)

        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(this, Observer { dataState->
            when(dataState) {
                is DataState.Loading -> {
                    displayProgress(true)
                }

                is DataState.Success<List<Blog>> -> {
                    displayProgress(false)
                    onSuccess(dataState.data)
                }

                is DataState.Error -> {
                    displayProgress(false)
                    onError(dataState.exception)
                }
            }
        })
    }

    private fun onError(exception: Exception) {
        text.text = exception.message.toString()
    }

    private fun displayProgress(isShow: Boolean) {
        progress_circular.visibility = if (isShow) View.VISIBLE else View.GONE
    }

    private fun onSuccess(data: List<Blog>) {
        val stringBuilder = StringBuilder()
        for (blog in data) {
            stringBuilder.append(blog.title.plus("\n"))
        }
        text.text = stringBuilder.toString()

    }
}