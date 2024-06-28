package com.dev.hexagonal.adapters.out.client

import com.dev.hexagonal.adapters.out.client.response.AddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name= "FindAddressByZipCodeClient",
    url="\${devdeolho.client.address.url}",
)
interface FindAddressByZipCodeClient {

    @GetMapping("/{zipCode}")
    fun find(@PathVariable zipCode: String): AddressResponse
}