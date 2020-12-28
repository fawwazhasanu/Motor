package com.fawwaz.motor.data.repository

import com.fawwaz.motor.data.model.ActionState
import com.fawwaz.motor.data.model.News
import com.fawwaz.motor.data.remote.NewsService
import com.fawwaz.motor.data.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception
import java.net.URL

class NewsRepository {
    private  val newsService: NewsService by lazy { RetrofitApi.newsService() }

    suspend fun listNews() : ActionState<List<News>> {
        return try {
            val list = newsService.listNews().await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message,isSucces = false)
        }
    }
    suspend fun detailNews(url: String) : ActionState<News> {
        return try {
            val list = newsService.detailNews(url).await()
            ActionState(list.data.first())
        } catch (e: Exception) {
            ActionState(message = e.message,isSucces = false)
        }
    }

    suspend fun searchNews(query: String) : ActionState<List<News>> {
        return try {
            val list = newsService.searchNews(query).await()
            ActionState(list.data)
        } catch (e:Exception) {
            ActionState(message = e.message, isSucces = false)
        }
    }
}