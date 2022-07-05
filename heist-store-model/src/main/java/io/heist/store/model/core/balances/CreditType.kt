package io.heist.store.model.core.balances

enum class CreditType(val value: String) {
    AVAILABLE("Available"), CREDIT("Credit"), EMERGENCY("Emergency"), PRE_AGREED("Pre-Agreed"), TEMPORARY("Temporary");

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): CreditType {
            for (b in CreditType.values()) {
                if (b.value == value) {
                    return b
                }
            }
            throw IllegalArgumentException("Unexpected value '$value'")
        }
    }
}