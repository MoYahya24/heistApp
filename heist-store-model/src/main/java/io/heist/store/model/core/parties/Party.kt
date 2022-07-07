package io.heist.store.model.core.parties

import io.heist.store.model.core.accounts.Account
import io.heist.store.model.core.addresses.Address
import io.heist.store.model.core.contacts.Contact
data class Party (

    val id: String? = null,

    val ref: String? = null,

    val number: String? = null,

    val type: String? = "Delegate",

    val name: String? = null,

    val legalName: String? = null,

    val legalStructure: String? = null,

    val beneficial: Boolean? = null,

    val role: String? = null,

    val email: String? = null,

    val phone: String? = null,

    val mobile: String? = null,

    val addresses: List<Address>? = null,

    val accounts: MutableList<Account>? = mutableListOf(),

    val contacts: List<Contact>? = null

) {
    val partyType = PartyType.fromValue(type!!)
}

