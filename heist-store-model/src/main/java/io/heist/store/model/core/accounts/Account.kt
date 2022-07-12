package io.heist.store.model.core.accounts

import io.heist.store.model.core.aliases.Alias
import io.heist.store.model.core.balances.Balance
import io.heist.store.model.core.extensions.Extension
import io.heist.store.model.core.institutes.Institute
import io.heist.store.model.core.parties.Party
import io.heist.store.model.core.payments.Payment
import io.heist.store.model.core.transactions.Transaction
import java.time.OffsetDateTime

data class Account (

    val id : String? = null,

    val ref : String? = null,

    val type: String? = "Business",

    val accSubType : AccountSubType? = null,

    val status: String? = null,

    val currency: String? = null,

    val description: String? = null,

    val nickname: String? = null,

    val updated: OffsetDateTime? = null,

    val opened: OffsetDateTime? = null,

    val matures: OffsetDateTime? = null,

    val balance: Balance? = null,

    val aliases: List<Alias>? = null,

    val institute: Institute? = null,

    val party: Party? = null,

    val extensions: List<Extension>? = null,

    val transactions: MutableList<Transaction>? =  mutableListOf(),

    val payments: List<Payment?>? = null

) {
    val accType = AccountType.fromValue(type!!)
}