package com.game.ticketmaster.app.ui.model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.ticketmaster.app.core.ApiKeyProvider
import com.game.ticketmaster.app.data.TicketMasterClient.ticketmasterApiService
import com.game.ticketmaster.app.data.model.Events
import com.game.ticketmaster.app.data.network.TicketMasterApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeViewModel() : ViewModel() {

    private val _ciudades = listOf("Madrid", "Barcelona", "Paris", "New York")
    val ciudades: LiveData<List<String>> = MutableLiveData(_ciudades)

    private val _gridDesign = MutableLiveData(1)
    val gridDesign: LiveData<Int> = _gridDesign

    val selectedText = mutableStateOf(ciudades.value?.first())

    private val _events = MutableLiveData<List<Events>>()
    val events: LiveData<List<Events>> = _events

    init {
        kotlin.run {
            getEventsByCity(selectedText.value!!)
        }
    }

    fun changeGrid() {
        if (gridDesign.value == 2) {
            _gridDesign.value = 1
        } else {
            _gridDesign.value = 2
        }
    }

    fun getEventsByCity(city: String) {
        viewModelScope.launch {
            try {
                val api = ticketmasterApiService
                val response = api.getEventsByCity(city)
                if (response.isSuccessful) {
                    val eventResponse = response.body()
                    val event = eventResponse?.embedded?.events
                    event.let {
                        _events.value = it
                    }
                } else {
                    Log.d("RESPONSE", "Error: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("RESPONSE", "Exception: ${e.message}")
            }
        }
    }

    private fun getRetrofitInstance(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.ticketmaster.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }


}