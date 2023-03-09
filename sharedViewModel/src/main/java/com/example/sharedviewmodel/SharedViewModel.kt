package com.example.sharedviewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coremodel.repository.Repository

class SharedViewModel(repo: Repository) : AndroidViewModel(application = Application()) {



    class SharedViewModelFactory(private val repo: Repository) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == SharedViewModel::class.java)
            return SharedViewModel(repo = repo) as T
        }
    }
}
