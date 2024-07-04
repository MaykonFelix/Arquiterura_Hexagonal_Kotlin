package com.dev.hexagonal.application.ports.`in`

import com.dev.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {

    fun update(customer: Customer, zipCode: String)
}