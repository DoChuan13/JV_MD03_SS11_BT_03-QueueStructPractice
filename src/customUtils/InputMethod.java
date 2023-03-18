package customUtils;

import java.util.Objects;
import java.util.Scanner;

/**
 * <p><b><u}>Description detail</u></b> </p>
 * <p>getString()  Return a String value from the user.</p>
 * <p>getChar()    Return a Character value from the user</p>
 * <p>getChar()    Return a Character value from the user.</p>
 * <p>getBoolean()	Return a boolean value from the user.</p>
 * <p>getByte()	Return a byte value from the user.</p>
 * <p>getShort()	Return a short value from the user.</p>
 * <p>getInt()	    Return a int value from the user.</p>
 * <p>getLong()	Return a long value from the user.</p>
 * <p>getFloat()	Return a float value from the user.</p>
 * <p>getDouble()	Return a double value from the user.</p>
 */
public final class InputMethod<E> {
    private static Scanner scanner = new Scanner(System.in);
    private static String input = scanner.nextLine();

    /**
     * getString()  Return a String value from the user.
     */
    final public static String getString() {
        String result = input;
        return result;
    }

    final public static boolean getBoolean() {
        Boolean result = Boolean.parseBoolean(getString());
        return result;
    }

    final public static int getInteger() {
        int result = Integer.parseInt(getString());
        return result;
    }


}
