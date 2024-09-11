package com.dev.hexagonal.adapters.out

import com.dev.hexagonal.adapters.out.repository.CustomerRepository
import com.dev.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort
import org.springframework.stereotype.Component

@Component
class DeleteCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
): DeleteCustomerByIdOutputPort {
    override fun delete(id: String) {
        customerRepository.deleteById(id)
    }

}