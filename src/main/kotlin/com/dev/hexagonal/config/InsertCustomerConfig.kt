package com.dev.hexagonal.config

import com.dev.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.dev.hexagonal.adapters.out.InsertCustomerAdapter
import com.dev.hexagonal.adapters.out.SendCpfForValidationAdapter
import com.dev.hexagonal.application.core.usecase.InsertCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter
    ) = InsertCustomerUseCase(
            findAddressByZipCodeAdapter,
            insertCustomerAdapter,
            sendCpfForValidationAdapter
        )

}