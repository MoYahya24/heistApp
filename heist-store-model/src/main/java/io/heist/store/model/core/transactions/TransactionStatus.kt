package io.heist.store.model.core.transactions

enum class TransactionStatus(val value: String) {
    BOOKED("Booked"), PENDING("Pending");

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): TransactionStatus {
            for (b in values()) {
                if (b.value == value) {
                    return b
                }
            }
            throw IllegalArgumentException("Unexpected value '$value'")
        }
    }
}