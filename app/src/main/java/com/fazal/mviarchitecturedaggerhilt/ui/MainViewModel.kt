package com.fazal.mviarchitecturedaggerhilt.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.fazal.mviarchitecturedaggerhilt.model.Blog
import com.fazal.mviarchitecturedaggerhilt.repository.MainRepo
import com.fazal.mviarchitecturedaggerhilt.utils.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/**
 * Main View Model Class
 */
class MainViewModel
@ViewModelInject constructor(
    private val mainRepo: MainRepo,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Blog>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Blog>>>
        get() = _dataState

    fun setStateEvent(mainStateEvents: MainStateEvents) {
        viewModelScope.launch {
            when(mainStateEvents) {
                is MainStateEvents.GetBlogEvents -> {
                    mainRepo.getBlogs()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
            }
        }

    }

}

sealed class MainStateEvents {
    object GetBlogEvents : MainStateEvents()
}