/*
 * Project: RDTRANS
 * Copyright 2015 CTTIC
 * All right reserved.
 */
package cn.cttic.core.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 建立日期 : 2015-9-2 上午9:14:45<br>
 * 作者 : liuzhenliang@cttic.cn<br>
 * 模块 : <br>
 * 描述 : <br>
 * 修改历史 <br>
 * 序号 日期 修改人 修改原因 <br>
 * 1 <br>
 * 2 <br>
 */
public class Base64
{
	private static final Base64Encoder encoder = new Base64Encoder();

	  public static byte[] encode(byte[] data)
	  {
	    return encode(data, 0, data.length);
	  }

	  public static byte[] encode(byte[] data, int offset, int length)
	  {
	    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
	    try
	    {
	      encoder.encode(data, 0, data.length, bOut);
	    }
	    catch (IOException e)
	    {
	      throw new RuntimeException("exception encoding base64 string: " + e);
	    }

	    return bOut.toByteArray();
	  }

	  public static int encode(byte[] data, OutputStream out)
	    throws IOException
	  {
	    return encoder.encode(data, 0, data.length, out);
	  }

	  public static int encode(byte[] data, int off, int length, OutputStream out)
	    throws IOException
	  {
	    return encoder.encode(data, off, length, out);
	  }

	  public static byte[] decode(byte[] data)
	  {
	    return decode(data, 0, data.length);
	  }

	  public static byte[] decode(byte[] data, int offset, int length)
	  {
	    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
	    try
	    {
	      encoder.decode(data, offset, length, bOut);
	    }
	    catch (IOException e)
	    {
	      throw new RuntimeException("exception decoding base64 string: " + e);
	    }

	    return bOut.toByteArray();
	  }

	  public static byte[] decode(String data)
	  {
	    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
	    try
	    {
	      encoder.decode(data, bOut);
	    }
	    catch (IOException e)
	    {
	      throw new RuntimeException("exception decoding base64 string: " + e);
	    }

	    return bOut.toByteArray();
	  }

	  public static int decode(String data, OutputStream out)
	    throws IOException
	  {
	    return encoder.decode(data, out);
	  }

	  public static int decode(byte[] data, OutputStream out)
	    throws IOException
	  {
	    return encoder.decode(data, 0, data.length, out);
	  }
}
