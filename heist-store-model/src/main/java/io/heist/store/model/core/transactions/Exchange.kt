package io.heist.store.model.core.transactions

import java.math.BigDecimal
import java.time.OffsetDateTime

data class Exchange (

    private val id: String? = null,

    val source: String? = null,

    val target: String? = null,

    val unit: String? = null,

    val contract: String? = null,

    val amount: String? = null,

    val currency: String? = null,

    val rate: BigDecimal? = null,

    val quoted: OffsetDateTime? = null

)