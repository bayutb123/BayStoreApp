package com.bayutb.baystoreapp.domain.usecase

import com.bayutb.baystoreapp.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {

}