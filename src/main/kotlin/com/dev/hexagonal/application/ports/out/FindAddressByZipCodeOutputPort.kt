package com.dev.hexagonal.application.ports.out

import com.dev.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipCode: String): Address
}