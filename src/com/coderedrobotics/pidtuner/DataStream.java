package com.coderedrobotics.pidtuner;

import java.util.ArrayList;

class DataStream {

    private ArrayList<Graph.Packet> vpackets;
    private Graph.Packet[] apackets;
    private boolean arrayIsCurrent;

    String name;

    public DataStream(String name) {
        this.name = name;
        vpackets = new ArrayList<>();
        vpackets.add(new Graph.Packet(0));//TODO: remove
        arrayIsCurrent = false;
        refreshArray();
    }

    synchronized void addPacket(double val) {
        vpackets.add(0, new Graph.Packet(val));
        arrayIsCurrent = false;
    }

    private void refreshArray() {
        apackets = new Graph.Packet[vpackets.size()];
        for (int i = 0; i < vpackets.size(); i++) {
            apackets[i] = (Graph.Packet) vpackets.get(i);
        }
        arrayIsCurrent = true;
    }

    public synchronized Graph.Packet[] getPackets() {
        if (!arrayIsCurrent) {
            refreshArray();
        }
        return apackets;
    }

    public synchronized Graph.Packet getLastPacket() {
        return (Graph.Packet) vpackets.get(0);
    }

    public synchronized Graph.Packet[] getPackets(int num) {
        Graph.Packet[] result = new Graph.Packet[num];
        for (int i = num - 1; i >= 0; i--) {
            Graph.Packet p = null;
            int j = vpackets.size() - num;
            if (i + j > -1) {
                result[i] = (Graph.Packet) vpackets.get(i + j);
            } else {
                result[i] = null;
            }
        }
        return result;
    }
}
