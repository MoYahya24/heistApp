package io.heist.store.model.core.payments

import java.time.Duration
import java.time.OffsetDateTime
import java.time.Period

data class Schedule (

    val id: String? = null,

    val start: OffsetDateTime? = null,

    val period: Period? = null,

    val duration: Duration? = null

)