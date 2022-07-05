package io.heist.store.model.core.amounts

import java.math.BigDecimal

data class Amount (

    val id: String? = null,

    val ref: String? = null,

    val value: BigDecimal? = null,

    val currency: String? = null,

    val sign: Sign? = null

)