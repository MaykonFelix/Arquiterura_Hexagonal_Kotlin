package com.dev.hexagonal.application.ports.out

import com.dev.hexagonal.application.core.domain.Customer

interface UpdateCustomerOutputPort {

    fun update(customer: Customer)
}