package com.shop.helper.domain.base

interface BaseInteractor<Inner, Outer> {

    fun execute(data: Inner): Outer

}