package com.wenbin.base.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by wenbin on 2017/12/3.
 */
public class NioinputAndOurputAsUtf8 {

    public static void main(String[] args) throws IOException {
        FileChannel out = new FileOutputStream("data5.txt").getChannel();

        ByteBuffer.allocate(1024);
        String enCoding = System.getProperty("file.encoding");
        ByteBuffer buff = ByteBuffer.wrap("中文 字符传".getBytes(enCoding));
//        Charset.forName(enCoding).decode(buff);
        out.write(buff);
        buff.clear();
        out.close();

        FileChannel in = new FileInputStream("data5.txt").getChannel();
        in.read(buff);
        buff.flip();  //
        buff.rewind();
        Charset.forName(enCoding).decode(buff);
        buff.rewind();
        System.out.print(Charset.forName(enCoding).decode(buff));

    }
}
