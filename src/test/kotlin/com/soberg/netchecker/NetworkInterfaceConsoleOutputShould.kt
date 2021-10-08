package com.soberg.netchecker

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class NetworkInterfaceConsoleOutputShould {

    private val shortDisplayItem = NetworkInterfaceDisplayItem("eth", "Ethernet")
    private val longDisplayItem = NetworkInterfaceDisplayItem("eps1wlan0", "Wireless 802.11n Adapter")
    private val consoleOutput = NetworkInterfaceConsoleOutput()

    @Test
    fun `return empty string when no interfaces are found`() {
        val output = consoleOutput.generate(emptyList())
        assertThat(output).isEqualTo("No active Network Interfaces found")
    }

    @Test
    fun `generate lines equal to the number of display items`() {
        val output = consoleOutput.generate(listOf(shortDisplayItem, longDisplayItem))
        val lines = output.lines().filter { it.isNotEmpty() }
        assertThat(lines.size).isEqualTo(2)
    }

    @Test
    fun `size the name column for the longest name to maintain alignment`() {
        val output = consoleOutput.generate(listOf(shortDisplayItem, longDisplayItem))
        val lines = output.lines()
        assertThat(lines[0]).isEqualTo("eth         Ethernet")
        assertThat(lines[1]).isEqualTo("eps1wlan0   Wireless 802.11n Adapter")
    }
}