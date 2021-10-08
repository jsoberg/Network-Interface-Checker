package com.soberg.netchecker

class NetworkInterfaceConsoleOutput {
    companion object {
        private const val NO_NETWORK_INTERFACES = "No active Network Interfaces found"
    }

    /** Generates a uniform formatted output String to be displayed in a console, describing [displayItems]. */
    fun generate(displayItems: List<NetworkInterfaceDisplayItem>): String {
        if (displayItems.isEmpty()) return NO_NETWORK_INTERFACES

        val longestNameLength = displayItems.maxOf { it.name.length }
        val nameFormat = "%-${longestNameLength}s"
        return generateFormattedString(
            nameFormat = nameFormat,
            displayItems = displayItems
        )
    }

    private fun generateFormattedString(
        nameFormat: String,
        displayItems: List<NetworkInterfaceDisplayItem>
    ): String {
        val builder = StringBuilder()
        for (item in displayItems) {
            builder.append(nameFormat.format(item.name))
                .append("   ")
                .append(item.displayName)
                .appendLine()
        }
        return builder.toString()
    }
}