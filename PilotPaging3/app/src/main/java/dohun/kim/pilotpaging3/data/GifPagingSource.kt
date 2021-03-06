package dohun.kim.pilotpaging3.data

import androidx.paging.PagingSource
import dohun.kim.pilotpaging3.model.GifModel
import kotlinx.coroutines.delay

class GifPagingSource(
    private val giphyService: GiphyService
) : PagingSource<Int, GifModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GifModel> {
        return try {
            val key = params.key ?: 0
            val response = giphyService.getGifs(key).data

            delay(2000)

            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = key + 20
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}