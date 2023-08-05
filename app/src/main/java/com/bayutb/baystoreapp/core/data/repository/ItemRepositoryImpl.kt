package com.bayutb.baystoreapp.core.data.repository

import com.bayutb.baystoreapp.core.data.source.dummy.DummyItem
import com.bayutb.baystoreapp.domain.repository.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val dummyItem: DummyItem
) : ItemRepository {

}