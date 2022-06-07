/*
 * Project: RDTRANS
 * Copyright 2015 CTTIC
 * All right reserved.
 */
package cn.cttic.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 建立日期 : 2015-9-2 上午9:18:38<br>
 * 作者 : liuzhenliang@cttic.cn<br>
 * 模块 : <br>
 * 描述 : <br>
 * 修改历史 <br>
 * 序号 日期 修改人 修改原因 <br>
 * 1 <br>
 * 2 <br>
 */
public class Base64Encoder
{
	protected final byte[] encodingTable = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };

	  protected byte padding = 61;

	  protected final byte[] decodingTable = new byte[256];

	  protected void initialiseDecodingTable()
	  {
	    for (int i = 0; i < this.encodingTable.length; i++)
	    {
	      this.decodingTable[this.encodingTable[i]] = (byte)i;
	    }
	  }

	  public Base64Encoder()
	  {
	    initialiseDecodingTable();
	  }

	  public int encode(byte[] data, int off, int length, OutputStream out)
	    throws IOException
	  {
	    int modulus = length % 3;
	    int dataLength = length - modulus;

	    for (int i = off; i < off + dataLength; i += 3)
	    {
	      int a1 = data[i] & 0xFF;
	      int a2 = data[(i + 1)] & 0xFF;
	      int a3 = data[(i + 2)] & 0xFF;

	      out.write(this.encodingTable[(a1 >>> 2 & 0x3F)]);
	      out.write(this.encodingTable[((a1 << 4 | a2 >>> 4) & 0x3F)]);
	      out.write(this.encodingTable[((a2 << 2 | a3 >>> 6) & 0x3F)]);
	      out.write(this.encodingTable[(a3 & 0x3F)]);
	    }
	    int d1;
	    int b1;
	    int b2;
	    switch (modulus)
	    {
	    case 0:
	      break;
	    case 1:
	      d1 = data[(off + dataLength)] & 0xFF;
	      b1 = d1 >>> 2 & 0x3F;
	      b2 = d1 << 4 & 0x3F;

	      out.write(this.encodingTable[b1]);
	      out.write(this.encodingTable[b2]);
	      out.write(this.padding);
	      out.write(this.padding);
	      break;
	    case 2:
	      d1 = data[(off + dataLength)] & 0xFF;
	      int d2 = data[(off + dataLength + 1)] & 0xFF;

	      b1 = d1 >>> 2 & 0x3F;
	      b2 = (d1 << 4 | d2 >>> 4) & 0x3F;
	      int b3 = d2 << 2 & 0x3F;

	      out.write(this.encodingTable[b1]);
	      out.write(this.encodingTable[b2]);
	      out.write(this.encodingTable[b3]);
	      out.write(this.padding);
	    }

	    return dataLength / 3 * 4 + (modulus == 0 ? 0 : 4);
	  }

	  private boolean ignore(char c)
	  {
	    return (c == '\n') || (c == '\r') || (c == '\t') || (c == ' ');
	  }

	  public int decode(byte[] data, int off, int length, OutputStream out)
	    throws IOException
	  {
	    int outLen = 0;

	    int end = off + length;

	    while (end > 0)
	    {
	      if (!ignore((char)data[(end - 1)]))
	      {
	        break;
	      }

	      end--;
	    }

	    int i = off;
	    int finish = end - 4;

	    while (i < finish)
	    {
	      while ((i < finish) && (ignore((char)data[i])))
	      {
	        i++;
	      }

	      byte b1 = this.decodingTable[data[(i++)]];

	      while ((i < finish) && (ignore((char)data[i])))
	      {
	        i++;
	      }

	      byte b2 = this.decodingTable[data[(i++)]];

	      while ((i < finish) && (ignore((char)data[i])))
	      {
	        i++;
	      }

	      byte b3 = this.decodingTable[data[(i++)]];

	      while ((i < finish) && (ignore((char)data[i])))
	      {
	        i++;
	      }

	      byte b4 = this.decodingTable[data[(i++)]];

	      out.write(b1 << 2 | b2 >> 4);
	      out.write(b2 << 4 | b3 >> 2);
	      out.write(b3 << 6 | b4);

	      outLen += 3;
	    }

	    if (data[(end - 2)] == this.padding)
	    {
	      byte b1 = this.decodingTable[data[(end - 4)]];
	      byte b2 = this.decodingTable[data[(end - 3)]];

	      out.write(b1 << 2 | b2 >> 4);

	      outLen++;
	    }
	    else if (data[(end - 1)] == this.padding)
	    {
	      byte b1 = this.decodingTable[data[(end - 4)]];
	      byte b2 = this.decodingTable[data[(end - 3)]];
	      byte b3 = this.decodingTable[data[(end - 2)]];

	      out.write(b1 << 2 | b2 >> 4);
	      out.write(b2 << 4 | b3 >> 2);

	      outLen += 2;
	    }
	    else
	    {
	      byte b1 = this.decodingTable[data[(end - 4)]];
	      byte b2 = this.decodingTable[data[(end - 3)]];
	      byte b3 = this.decodingTable[data[(end - 2)]];
	      byte b4 = this.decodingTable[data[(end - 1)]];

	      out.write(b1 << 2 | b2 >> 4);
	      out.write(b2 << 4 | b3 >> 2);
	      out.write(b3 << 6 | b4);

	      outLen += 3;
	    }

	    return outLen;
	  }

	  public int decode(String data, OutputStream out)
	    throws IOException
	  {
	    int length = 0;

	    int end = data.length();

	    while (end > 0)
	    {
	      if (!ignore(data.charAt(end - 1)))
	      {
	        break;
	      }

	      end--;
	    }

	    int i = 0;
	    int finish = end - 4;

	    while (i < finish)
	    {
	      while ((i < finish) && (ignore(data.charAt(i))))
	      {
	        i++;
	      }

	      byte b1 = this.decodingTable[data.charAt(i++)];

	      while ((i < finish) && (ignore(data.charAt(i))))
	      {
	        i++;
	      }
	      byte b2 = this.decodingTable[data.charAt(i++)];

	      while ((i < finish) && (ignore(data.charAt(i))))
	      {
	        i++;
	      }
	      byte b3 = this.decodingTable[data.charAt(i++)];

	      while ((i < finish) && (ignore(data.charAt(i))))
	      {
	        i++;
	      }
	      byte b4 = this.decodingTable[data.charAt(i++)];

	      out.write(b1 << 2 | b2 >> 4);
	      out.write(b2 << 4 | b3 >> 2);
	      out.write(b3 << 6 | b4);

	      length += 3;
	    }

	    if (data.charAt(end - 2) == this.padding)
	    {
	      byte b1 = this.decodingTable[data.charAt(end - 4)];
	      byte b2 = this.decodingTable[data.charAt(end - 3)];

	      out.write(b1 << 2 | b2 >> 4);

	      length++;
	    }
	    else if (data.charAt(end - 1) == this.padding)
	    {
	      byte b1 = this.decodingTable[data.charAt(end - 4)];
	      byte b2 = this.decodingTable[data.charAt(end - 3)];
	      byte b3 = this.decodingTable[data.charAt(end - 2)];

	      out.write(b1 << 2 | b2 >> 4);
	      out.write(b2 << 4 | b3 >> 2);

	      length += 2;
	    }
	    else
	    {
	      byte b1 = this.decodingTable[data.charAt(end - 4)];
	      byte b2 = this.decodingTable[data.charAt(end - 3)];
	      byte b3 = this.decodingTable[data.charAt(end - 2)];
	      byte b4 = this.decodingTable[data.charAt(end - 1)];

	      out.write(b1 << 2 | b2 >> 4);
	      out.write(b2 << 4 | b3 >> 2);
	      out.write(b3 << 6 | b4);

	      length += 3;
	    }

	    return length;
	  }

	  public int decode(byte[] data, int off, int length, byte[] out)
	    throws IOException
	  {
	    int outLen = 0;

	    int end = off + length;

	    while (end > 0)
	    {
	      if (!ignore((char)data[(end - 1)]))
	      {
	        break;
	      }

	      end--;
	    }

	    int i = off;
	    int finish = end - 4;

	    while (i < finish)
	    {
	      while ((i < finish) && (ignore((char)data[i])))
	      {
	        i++;
	      }

	      byte b1 = this.decodingTable[data[(i++)]];

	      while ((i < finish) && (ignore((char)data[i])))
	      {
	        i++;
	      }

	      byte b2 = this.decodingTable[data[(i++)]];

	      while ((i < finish) && (ignore((char)data[i])))
	      {
	        i++;
	      }

	      byte b3 = this.decodingTable[data[(i++)]];

	      while ((i < finish) && (ignore((char)data[i])))
	      {
	        i++;
	      }

	      byte b4 = this.decodingTable[data[(i++)]];

	      out[(outLen++)] = (byte)(b1 << 2 | b2 >> 4);
	      out[(outLen++)] = (byte)(b2 << 4 | b3 >> 2);
	      out[(outLen++)] = (byte)(b3 << 6 | b4);
	    }

	    if (data[(end - 2)] == this.padding)
	    {
	      byte b1 = this.decodingTable[data[(end - 4)]];
	      byte b2 = this.decodingTable[data[(end - 3)]];

	      out[(outLen++)] = (byte)(b1 << 2 | b2 >> 4);
	    }
	    else if (data[(end - 1)] == this.padding)
	    {
	      byte b1 = this.decodingTable[data[(end - 4)]];
	      byte b2 = this.decodingTable[data[(end - 3)]];
	      byte b3 = this.decodingTable[data[(end - 2)]];

	      out[(outLen++)] = (byte)(b1 << 2 | b2 >> 4);
	      out[(outLen++)] = (byte)(b2 << 4 | b3 >> 2);
	    }
	    else
	    {
	      byte b1 = this.decodingTable[data[(end - 4)]];
	      byte b2 = this.decodingTable[data[(end - 3)]];
	      byte b3 = this.decodingTable[data[(end - 2)]];
	      byte b4 = this.decodingTable[data[(end - 1)]];

	      out[(outLen++)] = (byte)(b1 << 2 | b2 >> 4);
	      out[(outLen++)] = (byte)(b2 << 4 | b3 >> 2);
	      out[(outLen++)] = (byte)(b3 << 6 | b4);
	    }

	    return outLen;
	  }

	  public boolean isValidBase64(int ch)
	  {
	    return (ch == this.padding) || (ch == 65) || (this.decodingTable[ch] != 0);
	  }

	  public void encodeWord(InputStream in, String charset, OutputStream out, boolean fold)
	    throws IOException
	  {
	    PrintStream writer = new PrintStream(out);

	    int limit = 68 - charset.length();
	    boolean firstLine = true;
	    StringBuffer encodedString = new StringBuffer(76);
	    while (true)
	    {
	      encode(in, encodedString, limit);

	      if (encodedString.length() == 0)
	      {
	        break;
	      }

	      if (!firstLine) {
	        if (fold) {
	          writer.print("\r\n");
	        }
	        else {
	          writer.print(" ");
	        }

	      }

	      writer.print("=?");
	      writer.print(charset);
	      writer.print("?B?");

	      writer.print(encodedString.toString());

	      writer.print("?=");
	      writer.flush();

	      encodedString.setLength(0);

	      firstLine = false;
	    }
	  }

	  public void encodeWord(byte[] data, StringBuffer out, String charset)
	    throws IOException
	  {
	    out.append("=?");
	    out.append(charset);
	    out.append("?B?");

	    encodeWordData(data, out);

	    out.append("?=");
	  }

	  public void encodeWordData(byte[] data, StringBuffer out)
	  {
	    int modulus = data.length % 3;
	    int dataLength = data.length - modulus;

	    for (int i = 0; i < dataLength; i += 3)
	    {
	      int a1 = data[i] & 0xFF;
	      int a2 = data[(i + 1)] & 0xFF;
	      int a3 = data[(i + 2)] & 0xFF;

	      out.append((char)this.encodingTable[(a1 >>> 2 & 0x3F)]);
	      out.append((char)this.encodingTable[((a1 << 4 | a2 >>> 4) & 0x3F)]);
	      out.append((char)this.encodingTable[((a2 << 2 | a3 >>> 6) & 0x3F)]);
	      out.append((char)this.encodingTable[(a3 & 0x3F)]);
	    }
	    int d1;
	    int b1;
	    int b2;
	    switch (modulus)
	    {
	    case 0:
	      break;
	    case 1:
	      d1 = data[dataLength] & 0xFF;
	      b1 = d1 >>> 2 & 0x3F;
	      b2 = d1 << 4 & 0x3F;

	      out.append((char)this.encodingTable[b1]);
	      out.append((char)this.encodingTable[b2]);
	      out.append((char)this.padding);
	      out.append((char)this.padding);
	      break;
	    case 2:
	      d1 = data[dataLength] & 0xFF;
	      int d2 = data[(dataLength + 1)] & 0xFF;

	      b1 = d1 >>> 2 & 0x3F;
	      b2 = (d1 << 4 | d2 >>> 4) & 0x3F;
	      int b3 = d2 << 2 & 0x3F;

	      out.append((char)this.encodingTable[b1]);
	      out.append((char)this.encodingTable[b2]);
	      out.append((char)this.encodingTable[b3]);
	      out.append((char)this.padding);
	    }
	  }

	  public void encode(InputStream in, StringBuffer out, int limit)
	    throws IOException
	  {
	    int count = limit / 4;
	    byte[] inBuffer = new byte[3];

	    while (count-- > 0)
	    {
	      int readCount = in.read(inBuffer);

	      if (readCount == 3) {
	        int a1 = inBuffer[0] & 0xFF;
	        int a2 = inBuffer[1] & 0xFF;
	        int a3 = inBuffer[2] & 0xFF;

	        out.append((char)this.encodingTable[(a1 >>> 2 & 0x3F)]);
	        out.append((char)this.encodingTable[((a1 << 4 | a2 >>> 4) & 0x3F)]);
	        out.append((char)this.encodingTable[((a2 << 2 | a3 >>> 6) & 0x3F)]);
	        out.append((char)this.encodingTable[(a3 & 0x3F)]);
	      }
	      else {
	        if (readCount <= 0)
	        {
	          return;
	        }
	        if (readCount == 1) {
	          int a1 = inBuffer[0] & 0xFF;
	          out.append((char)this.encodingTable[(a1 >>> 2 & 0x3F)]);
	          out.append((char)this.encodingTable[(a1 << 4 & 0x3F)]);
	          out.append((char)this.padding);
	          out.append((char)this.padding);
	          return;
	        }
	        if (readCount == 2) {
	          int a1 = inBuffer[0] & 0xFF;
	          int a2 = inBuffer[1] & 0xFF;

	          out.append((char)this.encodingTable[(a1 >>> 2 & 0x3F)]);
	          out.append((char)this.encodingTable[((a1 << 4 | a2 >>> 4) & 0x3F)]);
	          out.append((char)this.encodingTable[(a2 << 2 & 0x3F)]);
	          out.append((char)this.padding);
	          return;
	        }
	      }
	    }
	  }

	  public int estimateEncodedLength(byte[] data)
	  {
	    return (data.length + 2) / 3 * 4;
	  }
}
