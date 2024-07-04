package com.dev.hexagonal.adapters.out

import com.dev.hexagonal.adapters.out.repository.CustomerRepository
import com.dev.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.dev.hexagonal.application.core.domain.Customer
import com.dev.hexagonal.application.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository
): UpdateCustomerOutputPort {
    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }


}