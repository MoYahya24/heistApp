package io.heist.store.model.core.transactions

enum class Scheme(val value: String) {
    AMERICANEXPRESS("AmericanExpress"), DINERS("Diners"), DISCOVER("Discover"), MASTERCARD("MasterCard"), VISA("VISA");

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): Scheme {
            for (b in values()) {
                if (b.value == value) {
                    return b
                }
            }
            throw IllegalArgumentException("Unexpected value '$value'")
        }
    }
}