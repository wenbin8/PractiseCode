package com.wenbin.base.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wenbin on 2017/12/3.
 */
public class GetChannelCopy1 {
    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("data1.txt").getChannel();
        fc.write(ByteBuffer.wrap("1234".getBytes()));
        fc.close();

        fc = new RandomAccessFile("data1.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("4567".getBytes()));
        fc.close();

        fc = new FileInputStream("data1.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024);
        fc.read(buff);
        buff.flip();

        while (buff.hasRemaining()) {
            System.out.print((char)buff.get());
        }
    }

}
