package com.dev.hexagonal.application.core.usecase

import com.dev.hexagonal.application.core.domain.Customer
import com.dev.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.dev.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.dev.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.dev.hexagonal.application.ports.out.SendCpfForValidationOutputPort
import com.dev.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
): UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {
        if(customer.id == null) throw IllegalArgumentException("The id field cannot be null")
        val savedCpf =  findCustomerByIdInputPort.find(customer.id).cpf

        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            updateCustomerOutputPort.update(it)
            if(savedCpf != it.cpf){
                sendCpfForValidationOutputPort.send(it.cpf)
            }
        }
    }
}