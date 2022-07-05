package io.heist.store.model.core.contacts

enum class ContactType(val value: String) {

    OB_TRUSTED("Trusted"), OB_ORDINARY("Ordinary");

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): ContactType {
            for (b in values()) {
                if (b.value == value) {
                    return b
                }
            }
            throw IllegalArgumentException("Unexpected value '$value'")
        }
    }

}