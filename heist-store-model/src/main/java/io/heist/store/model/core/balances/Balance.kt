package io.heist.store.model.core.balances

import io.heist.store.model.core.amounts.Amount
import java.time.OffsetDateTime

data class Balance (

    val id: String? = null,

    val ref: String? = null,

    val type: String? = "ClosingAvailable",

    val updated: OffsetDateTime? = null,

    val amount: Amount? = null,

    val credits: List<Credit>? = null

) {
    val balanceType = BalanceType.fromValue(type!!)
}