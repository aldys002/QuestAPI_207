package com.example.restapi.view.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restapi.modeldata.DataSiswa
import com.example.restapi.repositori.RepositoryDataSiswa
import com.example.restapi.view.route.DestinasiDetail
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException


sealed interface StatusUIDetail {
    data class Success(val satuSiswa: DataSiswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}
class DetailViewModel (savedStateHandle: SavedStateHandle, private val repositoryDataSiswa: RepositoryDataSiswa): ViewModel(){
    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])
    var statusUIDetail: StatusUIDetail by mutableStateOf(StatusUIDetail.Loading)
        private set

    init {
        getSatuSiswa()
    }

    fun getSatuSiswa(){
        viewModelScope.launch {
            statusUIDetail = StatusUIDetail.Loading
            statusUIDetail = try {
                StatusUIDetail.Success(
                    satuSiswa = repositoryDataSiswa.getSatuSiswa(idSiswa)
                )
            } catch (e: IOException) {
                StatusUIDetail.Error
            } catch (e: HttpException) {
                StatusUIDetail.Error
            }
        }
    }
    fun hapusSatuSiswa() {
        viewModelScope.launch {
            try {
                repositoryDataSiswa.hapusSatuSiswa(idSiswa)
            } catch (e: IOException) {
                StatusUIDetail.Error
            } catch (e: HttpException) {
                StatusUIDetail.Error
            }
        }
    }

}