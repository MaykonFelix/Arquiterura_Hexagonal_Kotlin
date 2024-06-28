package com.dev.hexagonal.application.ports.`in`

import com.dev.hexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {

    fun insert (customer: Customer, zipCode: String)
}