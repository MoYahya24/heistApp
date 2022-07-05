package io.heist.store.model.core.balances

enum class BalanceType(val value: String) {
    OB_CLOSINGAVAILABLE("ClosingAvailable"), OB_CLOSINGBOOKED("ClosingBooked"), OB_CLOSINGCLEARED("ClosingCleared"), OB_EXPECTED(
        "Expected"
    ),
    OB_FORWARDAVAILABLE("ForwardAvailable"), OB_INFORMATION("Information"), OB_INTERIMAVAILABLE("InterimAvailable"), OB_INTERIMBOOKED(
        "InterimBooked"
    ),
    OB_INTERIMCLEARED("InterimCleared"), OB_OPENINGAVAILABLE("OpeningAvailable"), OB_OPENINGBOOKED("OpeningBooked"), OB_OPENINGCLEARED(
        "OpeningCleared"
    ),
    OB_PREVIOUSLYCLOSEDBOOKED("PreviouslyClosedBooked");

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): BalanceType {
            for (b in BalanceType.values()) {
                if (b.value == value) {
                    return b
                }
            }
            throw IllegalArgumentException("Unexpected value '$value'")
        }
    }
}