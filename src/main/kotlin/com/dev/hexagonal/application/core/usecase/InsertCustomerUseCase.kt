package com.dev.hexagonal.application.core.usecase

import com.dev.hexagonal.application.core.domain.Customer
import com.dev.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.dev.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.dev.hexagonal.application.ports.out.InsertCustomerOutputPort
import com.dev.hexagonal.application.ports.out.SendCpfForValidationOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort,
    private val sendValidationOutputPort: SendCpfForValidationOutputPort
): InsertCustomerInputPort {

    override fun insert (customer: Customer, zipCode: String)  {
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            insertCustomerOutputPort.insert(it)
            sendValidationOutputPort.send(it.cpf)
        }
    }
}