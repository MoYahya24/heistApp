package io.heist.store.model.core.balances

import io.heist.store.model.core.amounts.Amount

data class Credit (

    val id: String? = null,

    val included: Boolean? = null,

    val type: String? = null,

    val amount: Amount? = null

) {
    val creditType = CreditType.fromValue(type!!)
}