package com.a6.testclima

import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.a6.testclima.datos.ForeCastViewModel
import com.a6.testclima.datos.ForeCastViewModelFactory

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

/**
 *     Soy conciente que los test unitarios son muy importantes,
 *     es un tema que tengo pendiente aprender
 */

// https://medium.com/tribalscale/testing-viewmodels-and-activities-in-your-mvvm-app-5bf946559258
// https://github.com/square/okhttp/tree/master/mockwebserver

@RunWith(MockitoJUnitRunner::class)
class TestUnitarios {


    private lateinit var viewModel: ForeCastViewModel

    @Spy
    private val teamListLiveData: MutableLiveData<ForeCastViewModel> = MutableLiveData()


    @Before
    @Throws(Exception::class)
    fun setUp() {
        viewModel = ForeCastViewModel("Buenos Aires, AR")
    }

    @Test
    fun Test1() {
        viewModel.datos()
    }


}

