package com.dev.hexagonal.adapters.out

import com.dev.hexagonal.adapters.out.repository.CustomerRepository
import com.dev.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.dev.hexagonal.application.core.domain.Customer
import com.dev.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
): InsertCustomerOutputPort {

    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}