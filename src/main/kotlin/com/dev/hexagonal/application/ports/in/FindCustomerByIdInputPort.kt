package com.dev.hexagonal.application.ports.`in`

import com.dev.hexagonal.application.core.domain.Customer

interface FindCustomerByIdInputPort {
    
    fun find(id: String): Customer
}