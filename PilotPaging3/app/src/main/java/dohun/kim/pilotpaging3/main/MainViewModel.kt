package dohun.kim.pilotpaging3.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dohun.kim.pilotpaging3.data.GifPagingSource
import dohun.kim.pilotpaging3.data.GiphyService
import dohun.kim.pilotpaging3.model.GifModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

class MainViewModel : ViewModel() {
    val gifs: Flow<PagingData<GifModel>> = Pager(PagingConfig(pageSize = 25)) {
        GifPagingSource(GiphyService.getInstance())
    }
        .flow
        .catch { e ->

        }
        .cachedIn(viewModelScope)
}