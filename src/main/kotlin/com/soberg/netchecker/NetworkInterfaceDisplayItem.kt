package com.soberg.netchecker

data class NetworkInterfaceDisplayItem(
    /** Network interface name, to be used when binding to a particular network interface (e.g. `eth0`). */
    val name: String,
    /** Human-readable name/description of this network interface (e.g. Intel Wi-Fi...) */
    val displayName: String,
)