package io.heist.store.model.core.payments

import io.heist.store.model.core.accounts.Account
import io.heist.store.model.core.aliases.Alias
import io.heist.store.model.core.amounts.Amount
import io.heist.store.model.core.extensions.Extension

data class Payment (

    val id: String? = null,

    val ref: String? = null,

    val amount: Amount? = null,

    val from: Alias? = null,

    val to: Alias? = null,

    val account: Account? = null,

    val schedule: Schedule? = null,

    val extensions: List<Extension>? = null

)