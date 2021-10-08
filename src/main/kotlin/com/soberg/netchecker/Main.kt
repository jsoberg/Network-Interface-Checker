package com.soberg.netchecker

import java.net.NetworkInterface

fun main() {
    val netInterfaces = findActiveNetworkInterfaces()
    val output = NetworkInterfaceConsoleOutput()
    print(output.generate(netInterfaces))
}

private fun findActiveNetworkInterfaces() =
    NetworkInterface.getNetworkInterfaces()
        .toList()
        .filter { it.interfaceAddresses.isNotEmpty() }
        .map { NetworkInterfaceDisplayItem(it.name, it.displayName) }