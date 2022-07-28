package com.example.reqresusers.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reqresusers.data.User
import com.example.reqresusers.data.UsersListResponse
import com.example.reqresusers.service.UsersApi
import kotlinx.coroutines.launch

enum class ReqresApiStatus {LOADING, ERROR, DONE}
class UsersViewModel: ViewModel() {
    private val _status = MutableLiveData<ReqresApiStatus>()
    val status: LiveData<ReqresApiStatus> = _status

    private val _users = MutableLiveData<List<User>>()
    val users:LiveData<List<User>> = _users

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            _status.value = ReqresApiStatus.LOADING
            try {
                _users.value = UsersApi.retrofitService.getUsers().data
                _status.value = ReqresApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ReqresApiStatus.ERROR
                _users.value = listOf()
            }
        }
    }
}