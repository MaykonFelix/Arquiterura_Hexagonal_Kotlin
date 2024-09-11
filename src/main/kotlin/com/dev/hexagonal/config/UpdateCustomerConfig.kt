package com.dev.hexagonal.config

import com.dev.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.dev.hexagonal.adapters.out.SendCpfForValidationAdapter
import com.dev.hexagonal.adapters.out.UpdateCustomerAdapter
import com.dev.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.dev.hexagonal.application.core.usecase.UpdateCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter
    ) =  UpdateCustomerUseCase(
            findCustomerByIdUseCase,
            findAddressByZipCodeAdapter,
            updateCustomerAdapter,
            sendCpfForValidationAdapter
        )

}