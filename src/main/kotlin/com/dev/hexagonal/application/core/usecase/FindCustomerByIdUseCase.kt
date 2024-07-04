package com.dev.hexagonal.application.core.usecase

import com.dev.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.dev.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.dev.hexagonal.application.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
): FindCustomerByIdInputPort {

    override fun find(id: String) =
        findCustomerByIdOutputPort.find(id) ?: throw ObjectNotFoundException("Customer not Found")

}