/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tester.maventest;

/**
 *
 * @author kell-gigabyte
 */
import java.awt.List;
import org.ardulink.core.Link;

/**
 * [ardulinktitle] [ardulinkversion]
 *
 * project Ardulink http://www.ardulink.org/
 *
 * [adsense]
 *
 */
public class mavenTestMan {

    public static void main(String[] args) {
        try {
            Link link = Link
            // Comment this row if you use just the default connection
            link = getDigisparkConnection();

            List<String> portList = link.getPortList(); // 2
            if (portList != null && portList.size() > 0) {
                String port = portList.get(0);
                System.out.println("Connecting on port: " + port);
                boolean connected = link.connect(port); // 3
                System.out.println("Connected:" + connected);
                Thread.sleep(2000); // 4
                int power = IProtocol.HIGH;
                while (true) {
                    System.out.println("Send power:" + power);
                    link.sendPowerPinSwitch(2, power); // 5
                    if (power == IProtocol.HIGH) {
                        power = IProtocol.LOW;
                    } else {
                        power = IProtocol.HIGH;
                    }
                    Thread.sleep(2000);
                }
            } else {
                System.out.println("No port found!");
            }

        } catch (InterruptedException e) {
        }

    }
}
