package io.heist.store.model.core.debits

enum class DirectDebitStatus(val value: String) {
    ACTIVE("Active"), INACTIVE("Inactive");

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): DirectDebitStatus {
            for (b in values()) {
                if (b.value == value) {
                    return b
                }
            }
            throw IllegalArgumentException("Unexpected value '$value'")
        }
    }

}