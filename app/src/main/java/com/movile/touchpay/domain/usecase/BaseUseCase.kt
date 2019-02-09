package com.movile.touchpay.domain.usecase

abstract class BaseUseCase<in Q : BaseUseCase.RequestValues, out R : BaseUseCase.ResultValues> {

    abstract fun execute(requestValues: Q): R

    interface RequestValues

    interface ResultValues
}