package io.heist.store.model.core.amounts

enum class Sign(val value: String) {
    CREDIT("Credit"), DEBIT("Debit");

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): Sign {
            for (b in values()) {
                if (b.value == value) {
                    return b
                }
            }
            throw IllegalArgumentException("Unexpected value '$value'")
        }
    }
}
