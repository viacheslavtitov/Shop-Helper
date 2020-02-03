package com.shop.helper.domain.base

interface BaseInteractor<Inner, Outer> {

    suspend fun execute(data: Inner): Outer

}