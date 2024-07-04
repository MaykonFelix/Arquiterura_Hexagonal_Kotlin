package com.dev.hexagonal.config

import com.dev.hexagonal.adapters.out.FindCustomerByIdAdapter
import com.dev.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerById(findCustomerByIdAdapter: FindCustomerByIdAdapter) =
         FindCustomerByIdUseCase(findCustomerByIdAdapter)

}