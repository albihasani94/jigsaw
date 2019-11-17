package org.fastsocket;

import com.socket.NetworkSocket;
import com.socket.spi.NetworkSocketProvider;

public class FastNetworkSocketProvider extends NetworkSocketProvider {

    public FastNetworkSocketProvider() {
    }

    @Override
    public NetworkSocket opeNetworkSocket() {
        return new FastNetworkSocket();
    }

}