package org.jbm.instruction.impl.simple;

import org.jbm.element.MethodElement;
import org.jbm.instruction.AbstractInstruction;
import org.jbm.util.HTML;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnNode;

import java.awt.*;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author : const_
 */
public class BasicInstruction extends AbstractInstruction<InsnNode> {

    public BasicInstruction(MethodElement method, InsnNode node) {
        super(method, node);
    }

    @Override
    public String format() {
        return "<html>" + HTML.color(Color.GRAY, opcodeName()) + "</html>";
    }

    @Override
    public String definition() {
        switch (opcode()) {
            case NOP:
                return "Performs no operation";
            case ACONST_NULL:
                return "Pushes a null value onto the stack";
            case ICONST_M1:
                return "Pushes an int value of -1 onto the stack";
            case ICONST_0:
                return "Pushes an int value of 0 onto the stack";
            case ICONST_1:
                return "Pushes an int value of 1 onto the stack";
            case ICONST_2:
                return "Pushes an int value of 2 onto the stack";
            case ICONST_3:
                return "Pushes an int value of 3 onto the stack";
            case ICONST_4:
                return "Pushes an int value of 4 onto the stack";
            case ICONST_5:
                return "Pushes an int value of 5 onto the stack";
            case LCONST_0:
                return "Pushes a long value of 0 onto the stack";
            case LCONST_1:
                return "Pushes a long value of 1 onto the stack";
            case FCONST_0:
                return "Pushes a float value of 0.0 onto the stack";
            case FCONST_1:
                return "Pushes a float value of 1.0 onto the stack";
            case FCONST_2:
                return "Pushes a float value of 2.0 onto the stack";
            case DCONST_0:
                return "Pushes a double value of 0.0 onto the stack";
            case DCONST_1:
                return "Pushes a double value of 1.0 onto the stack";
            case IALOAD:
                return "Loads an int from an array";
            case LALOAD:
                return "Loads a long from an array";
            case FALOAD:
                return"Loads a float from an array";
            case DALOAD:
                return "Loads a double from an array";
            case AALOAD:
                return "Loads an object from an array";
            case BALOAD:
                return "Loads a byte from an array";
            case CALOAD:
                return "Loads a char from an array";
            case SALOAD:
                return "Loads a short from an array";
            case IASTORE:
                return "Stores an int in an array";
            case LASTORE:
                return "Stores a long in an array";
            case FASTORE:
                return "Stores a float in an array";
            case DASTORE:
                return "Stores a double in an array";
            case AASTORE:
                return "Stores an object in an array";
            case BASTORE:
                return "Stores a byte in an array";
            case CASTORE:
                return "Stores a char in an array";
            case SASTORE:
                return "Stores a short in an array";
            case POP:
                return "Discards the top value on the stack";
            case POP2:
                return "Discards the top two values on the stack (or one value, if it is a double or long)";
            case DUP:
                return "Duplicates the top value on the stack";
            case DUP_X1:
                return "Inserts a copy of the top value on the stack into the stack two values from the top";
            case DUP_X2:
                return "Inserts a copy of the top value into the stack two values from the top";
            case DUP2:
                return "Duplicates top two stack values";
            case DUP2_X1:
                return "Duplicate top two stack values and insert beneath the third stack value";
            case DUP2_X2:
                return "Duplicate top two stack values and insert beneath the fourth stack value";
            case SWAP:
                return "Swaps the two values on the top of the stack around";
            case IADD:
                return "Adds two ints together (+)";
            case LADD:
                return "Adds two longs together (+)";
            case FADD:
                return "Adds two floats together (+)";
            case DADD:
                return "Adds two doubles together (+)";
            case ISUB:
                return "Subtracts two ints (-)";
            case LSUB:
                return "Subtracts two longs (-)";
            case FSUB:
                return "Subtracts two floats (-)";
            case DSUB:
                return "Subtracts two doubles (-)";
            case IMUL:
                return "Multiplies two ints (*)";
            case LMUL:
                return "Multiplies two longs (*)";
            case FMUL:
                return "Multiplies two floats (*)";
            case DMUL:
                return "Multiplies two doubles (*)";
            case IDIV:
                return "Divides two ints (/)";
            case LDIV:
                return "Divides two longs (/)";
            case FDIV:
                return "Divides two floats (/)";
            case DDIV:
                return "Divides two doubles (/)";
            case IREM:
                return "Performs logcal int remainder operation (%)";
            case LREM:
                return "Performs logical long remainder operation (%)";
            case FREM:
                return "Performs logical float remainder operation (%)";
            case DREM:
                return "Performs logical double remainder operation (%)";
            case INEG:
                return "Negates an int";
            case LNEG:
                return "Negates a long";
            case FNEG:
                return "Negates a float";
            case DNEG:
                return "Negates a double";
            case ISHL:
                return "Shifts an int left";
            case LSHL:
                return "Shifts a long left";
            case ISHR:
                return "Shifts an int right";
            case LSHR:
                return "Shifts a long right";
            case IUSHR:
                return "Logical int shift right";
            case LUSHR:
                return "Logical long shift right";
            case IAND:
                return "Performs bitwise on two ints (&)";
            case LAND:
                return "Performs bitwise on two longs (&)";
            case IOR:
                return "Performs bitwise OR on two ints (|)";
            case LOR:
                return "Performs bitwise OR on two longs (|)";
            case IXOR:
                return "Performs bitwise exclusive of two ints";
            case LXOR:
                return "Performs bitwise exclusive of two longs";
            case I2L:
                return "Converts an int to long";
            case I2F:
                return "Converts an int to float";
            case I2D:
                return "Converts an int to double";
            case L2I:
                return "Converts a long to int";
            case L2D:
                return "Converts a long to double";
            case L2F:
                return "Converts a long to float";
            case F2I:
                return "Converts a float to int";
            case F2D:
                return "Converts a float to double";
            case F2L:
                return "Converts a float to long";
            case D2I:
                return "Converts a double to int";
            case D2F:
                return "Converts a double to float";
            case D2L:
                return "Converts a double to long";
            case I2B:
                return "Converts an int to byte";
            case I2C:
                return "Converts an int to char";
            case I2S:
                return "Converts an int to short";
            case LCMP:
                return "Compares two longs";
            case FCMPL:
                return "Compares two floats";
            case FCMPG:
                return "Compares two floats";
            case DCMPL:
                return "Compares two doubles";
            case DCMPG:
                return "Compares two doubles";
            case IRETURN:
                return "Returns an int value";
            case LRETURN:
                return "Returns a long value";
            case FRETURN:
                return "Returns a float value";
            case DRETURN:
                return "Returns a double value";
            case ARETURN:
                return "Returns an object value";
            case RETURN:
                return "Returns no value (void method)";
            case ARRAYLENGTH:
                return "Gets the length of an array";
            case ATHROW:
                return "Throws an error or exception";
            case MONITORENTER:
                return "Start of synchronized() section (locks)";
            case MONITOREXIT:
                return "End of synchronized() section (unlocks)";
        }
        return "null";
    }
}
