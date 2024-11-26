package com.zyy.compose_nav

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

;
internal class NavChannel {
    companion object {
        private val channel = Channel<NavIntent>(
            capacity = Int.MAX_VALUE,
            onBufferOverflow = BufferOverflow.DROP_LATEST,
        )

        internal var navChannel = channel.receiveAsFlow()

        internal fun navigate(destination: NavIntent) {
            channel.trySend(destination)
        }
    }

}