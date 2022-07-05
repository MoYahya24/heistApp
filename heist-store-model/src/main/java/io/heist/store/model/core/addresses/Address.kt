package io.heist.store.model.core.addresses

data class Address (

    val id: String? = null,

    val ref: String? = null,

    val type: String? = null,

    val department: String? = null,

    val subdepartment: String? = null,

    val street: String? = null,

    val number: String? = null,

    val postcode: String? = null,

    val city: String? = null,

    val region: String? = null,

    val country: String? = null,

    val lines: List<String>? = null,

)