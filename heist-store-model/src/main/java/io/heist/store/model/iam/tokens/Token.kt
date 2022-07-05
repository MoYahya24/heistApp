/*
 * Copyright (c) 2020. Weird ( The Weird Science Holding B.V. )
 *
 * All rights reserved.
 */
package io.heist.store.model.iam.tokens

data class Token (

    val access_token: String? = null,

    val expires_in: Long? = null,

    val token_type: String? = null,

    val scope: String? = null,

    val state: String? = null,

    val id_token: String? = null,

    val principal: String? = null

)