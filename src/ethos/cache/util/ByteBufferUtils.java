package ethos.cache.util;

import java.nio.ByteBuffer;

/**
 * A utility class for byte buffers.
 * 
 * @author Graham Edgecombe
 * 
 */
public class ByteBufferUtils {

	/**
	 * Gets a smart.
	 * 
	 * @param buf
	 *            The buffer.
	 * @return The smart.
	 */
	public static int getSmart(ByteBuffer buf) {
		int peek = buf.get(buf.position()) & 0xFF;
		if (peek < 128) {
			return buf.get() & 0xFF;
		} else {
			return (buf.getShort() & 0xFFFF) - 32768;
		}
	}
	public static int getSmart2(ByteBuffer buf) {
        int baseVal = 0;
        int lastVal = 0;
        while ((lastVal = getSmart(buf)) == 32767) {
            baseVal += 32767;
        }
        return baseVal + lastVal;
	}
    public static int getUIncrementalSmart(ByteBuffer buf) {
		int value = 0, remainder;
		for (remainder = getSmart(buf); remainder == 32767; remainder = getSmart(buf)) {
			value += 32767;
		}
		value += remainder;
		return value;
	}
	/**
	 * Gets an RS2 string from the buffer.
	 *
	 */
    public static String getString(ByteBuffer buffer) {
        StringBuilder bldr = new StringBuilder();
        char c;
        while ((c = (char) buffer.get()) != 10) {
            bldr.append(c);
        }
        return bldr.toString();
    }

}
