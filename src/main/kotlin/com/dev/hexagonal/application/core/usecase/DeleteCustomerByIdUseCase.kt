package com.dev.hexagonal.application.core.usecase

import com.dev.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.dev.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.dev.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort


class DeleteCustomerByIdUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val deleteCustomerOutputPort: DeleteCustomerByIdOutputPort
): DeleteCustomerByIdInputPort {

    override fun delete(id: String) {
        findCustomerByIdInputPort.find(id)
        deleteCustomerOutputPort.delete(id)
    }
}