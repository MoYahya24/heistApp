package io.heist.store.model.core.contacts

import io.heist.store.model.core.addresses.Address
import io.heist.store.model.core.aliases.Alias
import io.heist.store.model.core.extensions.Extension
import io.heist.store.model.core.parties.Party

data class Contact (

    val id: String? = null,

    val type: String? = "Trusted",

    val ref: String? = null,

    val name: String? = null,

    val email: String? = null,

    val phone: String? = null,

    val addresses: List<Address>? = null,

    val party: Party? = null,

    val alias: Alias? = null,

    val extensions: List<Extension?>? = null

) {
    val contactType = ContactType.fromValue(type!!)
}