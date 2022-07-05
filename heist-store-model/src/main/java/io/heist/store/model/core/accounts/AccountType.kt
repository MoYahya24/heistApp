package io.heist.store.model.core.accounts

enum class AccountType(val value: String) {
    BUSINESS("Business"), PERSONAL("Personal");

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): AccountType {
            for (b in AccountType.values()) {
                if (b.value == value) {
                    return b
                }
            }
            throw IllegalArgumentException("Unexpected value '$value'")
        }
    }
}