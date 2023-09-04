package com.yape.domain.usecase

import com.yape.data.repository.FoodRepository
import com.yape.domain.model.FoodModel
import com.yape.domain.model.convertToModel
import com.yape.domain.core.UseCase
import com.yape.domain.model.convertLocalToModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllStoredFoodList @Inject constructor(
    private val repository: FoodRepository
) : UseCase.WithoutParams<Flow<List<FoodModel>>> {

    override suspend fun invoke(): Flow<List<FoodModel>> {
        return repository.getAllStoredFoodList().map { it.convertLocalToModel() }
    }
}