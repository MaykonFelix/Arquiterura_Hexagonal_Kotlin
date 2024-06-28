package com.dev.hexagonal.adapters.out

import com.dev.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import com.dev.hexagonal.application.core.domain.Address
import com.dev.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter (
    private val findAddressByZipCodeClient: FindAddressByZipCodeClient
): FindAddressByZipCodeOutputPort {
    override fun find(zipCode: String): Address =
        findAddressByZipCodeClient.find(zipCode).toAddress()
}