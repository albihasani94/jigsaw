package org.openjdk.hello;

import org.openjdk.jigsaw.JigsawProvider;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello " + JigsawProvider.jigsaw());
    }
}