package com.dev.hexagonal.config

import com.dev.hexagonal.adapters.out.DeleteCustomerByIdAdapter
import com.dev.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase
import com.dev.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class DeleteCustomerConfig {

    @Bean
    fun deleteCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        deleteCustomerByIdAdapter: DeleteCustomerByIdAdapter
    ) = DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter)
}