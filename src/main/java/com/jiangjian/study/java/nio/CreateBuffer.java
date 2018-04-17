// $Id$
package com.jiangjian.study.java.nio;// $Id$

import java.nio.*;

public class CreateBuffer
{
  static public void main( String args[] ) throws Exception {
    ByteBuffer buffer = ByteBuffer.allocate( 1024 );

    buffer.put( (byte)'a' );
    buffer.put( (byte)'b' );
    buffer.put( (byte)'c' );
    buffer.rewind();
    buffer.put((byte)'s');

    buffer.flip();
    System.out.println(buffer.remaining());
//    System.out.println( (char)buffer.get() );
//    System.out.println( (char)buffer.get() );
//    System.out.println( (char)buffer.get() );
  }
}
