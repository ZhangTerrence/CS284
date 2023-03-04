/*
Name: Terrence Zhang
Section: B
Pledge: I pledge my honor that I have abided by the Stevens Honor System.
 */

public class BinaryNumber {
    private int data[];
    private int length;

    public BinaryNumber(int length) {
        // Constructor for creating a binary number given an integer length
        this.length = length;
        this.data = new int[length];
        for (int i = 0; i < length; i++) {
            this.data[i] = 0;
        }
    }

    public BinaryNumber(String str) {
        // Constructor for creating a binary number given a string str
        this.length = str.length();
        this.data = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            this.data[i] = Character.getNumericValue(str.charAt(i));
        }
    }

    public int getLength() {
        // Getter for length field
        return this.length;
    }

    public int[] getInnerArray() {
        // Getter for data field
        return this.data;
    }

    public void setLength(int length) {
        // Setter for length field
        this.length = length;
    }

    public void setInnerArray(int[] data) {
        // Setter for data field
        this.data = data;
    }

    public int getDigit(int index) {
        // Returns the digit of binary number at specific integer index
        if (index >= this.getLength()) {
            throw new IllegalArgumentException("Invalid value: Index out of bounds");
        } else if (index < 0) {
            throw new IllegalArgumentException("Invalid value: Negative index");
        } else {
            return this.getInnerArray()[index];
        }
    }

    public int toDecimal() {
        // Returns the corresponding decimal number of the binary number
        double result = 0;
        double exponent = this.getLength() - 1;
        for (int i = 0; i < this.getLength(); i++) {
             result = result + (Math.pow(2.0, exponent) * this.getInnerArray()[i]);
             exponent--;
        }
        return (int) result;
    }

    public void bitShift(int direction, int amount) {
        // Shifts binary number left (negative direction) or right (positive direction) by a given amount
        if (direction > 1 || direction < -1 || direction == 0) {
            throw new IllegalArgumentException("Invalid value: Direction must be 1 or -1");
        } else if (amount < 0) {
            throw new IllegalArgumentException("Invalid value: Amount must be nonnegative");
        } else if (direction > 0 && amount > this.getLength()) {
            throw new IllegalArgumentException("Invalid value: Amount greater than length");
        } else {
            if (direction > 0) {
                int[] newData = new int[this.getLength() - amount];
                for (int i = 0; i < this.getLength() - amount; i++) {
                    newData[i] = this.getInnerArray()[i];
                }
                this.setLength(this.getLength() - amount);
                this.setInnerArray(newData);
            }
            if (direction < 0) {
                int[] newData = new int[this.getLength() + amount];
                for (int i = 0; i < this.getLength() + amount; i++) {
                    if (i < this.getLength()) {
                        newData[i] = this.getInnerArray()[i];
                    }
                    else {
                        newData[i] = 0;
                    }
                }
                this.setLength(this.getLength() + amount);
                this.setInnerArray(newData);
            }
        }
    }

    public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2) {
        // Returns the integer array of the bitwise or of two binary numbers
        if (bn1.getLength() != bn2.getLength()) {
            throw new IllegalArgumentException("Invalid input: Different lengths");
        } else {
            int length = bn1.getLength();
            int[] bwor = new int[length];
            for (int i = 0; i < length; i++) {
                if (bn1.getInnerArray()[i] == 0 && bn2.getInnerArray()[i] == 0) {
                    bwor[i] = 0;
                }
                else {
                    bwor[i] = 1;
                }
            }
            return bwor;
        }
    }

    public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
        // Returns the integer array of the bitwise and of two binary numbers
        if (bn1.getLength() != bn2.getLength()) {
            throw new IllegalArgumentException("Invalid input: Different lengths");
        } else {
            int length = bn1.getLength();
            int[] bwand = new int[length];
            for (int i = 0; i < length; i++) {
                if (bn1.getInnerArray()[i] == 1 && bn2.getInnerArray()[i] == 1) {
                    bwand[i] = 1;
                }
                else {
                    bwand[i] = 0;
                }
            }
            return bwand;
        }
    }

    @Override
    public String toString() {
        // Overrides Object class toString method and instead returns the binary numbers as a string
        StringBuilder binaryNumber = new StringBuilder();
        for (int i = 0; i < this.getLength(); i++) {
            binaryNumber.append(this.getInnerArray()[i]);
        }
        return binaryNumber.toString();
    }

    public void add(BinaryNumber aBinaryNumber) {
        // Adds and returns the sum of two binary numbers. The binary number that receives the aBinaryNumber will be
        // modified by the addition
        StringBuilder self = new StringBuilder();
        StringBuilder other = new StringBuilder();
        if (this.getLength() == aBinaryNumber.getLength()) {
            self.append(this);
            other.append(aBinaryNumber);
        } else if (this.getLength() > aBinaryNumber.getLength()) {
            self.append(this);
            int difference = this.getLength() - aBinaryNumber.getLength();
            for (int i = 0; i < difference; i++) {
                other.append(0);
            }
            other.append(aBinaryNumber);
        } else if (this.getLength() < aBinaryNumber.getLength()) {
            other.append(aBinaryNumber);
            int difference = aBinaryNumber.getLength() - this.getLength();
            for (int i = 0; i < difference; i++) {
                self.append(0);
            }
            self.append(this);
        }

        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = self.length() - 1; i >= 0; i--) {
            int sum = Character.getNumericValue(self.charAt(i)) + Character.getNumericValue(other.charAt(i)) + carry;
            if (sum == 3) {
                result.append(1);
                carry = 1;
            }
            if (sum == 2) {
                result.append(0);
                carry = 1;
            }
            if (sum == 1) {
                result.append(1);
                carry = 0;
            }
            if (sum == 0) {
                result.append(0);
                carry = 0;
            }
        }
        if (carry == 1) result.append(1);
        result.reverse();

        int[] newData = new int[result.length()];
        for (int i = 0; i < result.length(); i++) {
            newData[i] = Character.getNumericValue(result.charAt(i));;
        }
        this.setLength(result.length());
        this.setInnerArray(newData);
    }

}
