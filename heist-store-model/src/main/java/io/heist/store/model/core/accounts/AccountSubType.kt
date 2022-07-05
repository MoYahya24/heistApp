package io.heist.store.model.core.accounts

enum class AccountSubType(val value: String) {
    CHARGECARD( "ChargeCard" ),
    CREDITCARD( "CreditCard" ),
    CURRENTACCOUNT( "CurrentAccount" ),
    EMONEY( "EMoney" ),
    LOAN( "Loan" ),
    MORTGAGE( "Mortgage" ),
    OTHER( "Other" ),
    PREPAIDCARD( "PrePaidCard" ),
    SAVINGS( "Savings" );

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): AccountSubType {
            for (b in AccountSubType.values()) {
                if (b.value == value) {
                    return b
                }
            }
            throw IllegalArgumentException("Unexpected value '$value'")
        }
    }
}