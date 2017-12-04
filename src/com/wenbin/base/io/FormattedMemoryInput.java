package com.wenbin.base.io;//: io/FormattedMemoryInput.java
import java.io.*;

// 中文注释, 基于字节的读取会让中文变乱码
public class FormattedMemoryInput {
  public static void main(String[] args)
  throws IOException {
    try {
      DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read(
          "/Users/wenbin/code/PractiseCode/src/com/wenbin/base/io/FormattedMemoryInput.java").getBytes()));
      while(true)
        System.out.print((char)in.readByte());
    } catch(EOFException e) {
      System.err.println("End of stream");
    }
  }
} /* (Execute to see output) *///:~
