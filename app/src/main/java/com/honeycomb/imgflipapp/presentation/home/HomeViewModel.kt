package com.honeycomb.imgflipapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.honeycomb.imgflipapp.domain.common.BaseResult
import com.honeycomb.imgflipapp.domain.memes.DataEntity
import com.honeycomb.imgflipapp.domain.memes.usecase.MemesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val memesUseCase: MemesUseCase) : ViewModel(){

    private val state = MutableStateFlow<MemesState>(MemesState.Init)
    val mState: StateFlow<MemesState> get() = state

    private val memes = MutableStateFlow<DataEntity?>(null)
    val mMemes: StateFlow<DataEntity?> get() = memes

    private fun isError(value : Boolean){
        state.value = MemesState.IsError(value)
    }

    private fun showToast(message: String){
        state.value = MemesState.ShowToast(message)
    }

    fun fetchAllMemes(){
        viewModelScope.launch {
            memesUseCase.execute()
                .onStart {
                    isError(false)
                }
                .catch { exception ->
                    isError(true)
                    showToast(exception.message.toString())
                }
                .collect { result ->
                    when(result){
                        is BaseResult.Success -> {
                            memes.value = result.data
                        }
                        is BaseResult.Error -> {
                            showToast(result.toString())
                        }
                    }
                }
        }
    }
}

sealed class MemesState {
    object Init : MemesState()
    data class IsError(val isError: Boolean) : MemesState()
    data class ShowToast(val message : String) : MemesState()
}