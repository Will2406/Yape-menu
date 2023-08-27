package com.yape.menu.data

import com.yape.menu.data.response.CategoryListResponse
import retrofit2.Response
import retrofit2.http.GET

interface MenuService {

    @GET("categories")
    suspend fun getCategories(): Response<CategoryListResponse>
}