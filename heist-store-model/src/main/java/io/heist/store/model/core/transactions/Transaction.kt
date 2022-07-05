package io.heist.store.model.core.transactions

import io.heist.store.model.core.accounts.Account
import io.heist.store.model.core.aliases.Alias
import io.heist.store.model.core.amounts.Amount
import io.heist.store.model.core.balances.Balance
import io.heist.store.model.core.extensions.Extension
import java.time.OffsetDateTime

data class Transaction (

    val id: String? = null,

    val ref: String? = null,

    val address: String? = null,

    val status: String? = "Booked",

    val booked: OffsetDateTime? = null,

    val valued: OffsetDateTime? = null,

    val statements: List<String>? = null,

    val info: String? = null,

    val code: String? = null,

    val account: Account? = null,

    val amount: Amount? = null,

    val charge: Amount? = null,

    val from: Alias? = null,

    val to: Alias? = null,

    val category: Category? = null,

    val exchange: Exchange? = null,

    val balance: Balance? = null,

    val merchant: Merchant? = null,

    val card: Card? = null,

    val extensions: List<Extension?>? = null

) {
    val transactionStatus = TransactionStatus.fromValue(status!!)
}