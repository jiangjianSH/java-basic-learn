// $Id$
package com.jiangjian.study.java.advanced.nio;// $Id$

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class ReadAndShow
{
  static public void main( String args[] ) throws Exception {
    FileInputStream fin = new FileInputStream( "person.xml" );
    FileChannel fc = fin.getChannel();

    ByteBuffer buffer = ByteBuffer.allocate( 1024 );

    fc.read( buffer );

    buffer.flip();

    int i=0;
    while (buffer.remaining()>0) {
      byte b = buffer.get();
      System.out.print(((char)b) );
      i++;
    }

    fin.close();
  }
}
