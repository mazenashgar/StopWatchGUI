package project1;

import java.io.*;
import java.util.*;

/**********************************************************************
 * Description: A stop watch that counts upwards, using milliseconds,
 * seconds, and minutes. The stop watch can be saved to a file and
 * loaded from the file. The program checks if the parameters passed
 * to any method is valid, if not, the program will throw an exception.
 *
 * @author Mazen Ashgar
 * @author Max Carson
 *
 * @version 5/23/2018
 *********************************************************************/

public class StopWatch {

    /** instance variables */

    /** variable to store the values of the minutes */
    private int minutes;

    /** variable to store the values of the seconds*/
    private int seconds;

    /** variable to store the values of the milliseconds */
    private int milliseconds;

    /** FINAL variable to convert between milliseconds and minutes */
    private final int CONVERT_MIN = 60000;

    /** FINAL variable to convert between milliseconds and seconds */
    private final int CONVERT_SEC = 1000;

    /** FINAL variable to convert between milliseconds and minutes */
    private final int MILLI_TO_SEC = 1000;

    /** FINAL variable to convert between seconds and minutes */
    private final int SEC_IN_MIN = 60;

    /** A string array to store the values of the stopWatch */
    private String[] s = new String[0];

    /** A variable to know if the stopWatch is suspended or not */
    private static boolean suspended = false;

    /******************************************************************
     * Default constructor for the stop watch
     *****************************************************************/
    public StopWatch() {

        //assign all the variables to zero
        this.minutes = 0;
        this.seconds = 0;
        this.milliseconds = 0;
    }

    /******************************************************************
     * Constructor with specified milliseconds
     *
     * @param milliseconds milliseconds to be added to the stop watch
     *****************************************************************/
    public StopWatch(int milliseconds) {

        //if parameter is within the appropriate range
        if (milliseconds >= 0 && milliseconds < 1000) {

            //assign the parameter to the milliseconds of the watch
            this.milliseconds = milliseconds;
        } else {

            //if parameter is not in range throw an exception
            throw new IllegalArgumentException();
        }
    }

    /******************************************************************
     * Constructor with specified seconds and milliseconds
     *
     * @param seconds seconds to be added to the stop watch
     * @param milliseconds milliseconds to be added to the stop watch
     *****************************************************************/
    public StopWatch(int seconds, int milliseconds) {

        //if parameters are within the appropriate range
        if (seconds >= 0 && seconds < 60 && milliseconds >= 0 && milliseconds < 1000) {

            //assign the parameters to the seconds and milliseconds of the watch
            this.seconds = seconds;
            this.milliseconds = milliseconds;

        } else {

            //if parameter is not in range throw an exception
            throw new IllegalArgumentException();
        }
    }

    /******************************************************************
     * Constructor with specified minutes, seconds and milliseconds
     *
     * @param minutes
     * @param seconds seconds to be added to the stop watch
     * @param milliseconds milliseconds to be added to the stop watch
     *****************************************************************/
    public StopWatch(int minutes, int seconds, int milliseconds) {

        //if parameters are within the appropriate range
        if (minutes >= 0 && seconds >= 0 && seconds < 60 && milliseconds >= 0 && milliseconds < 1000) {

            //assign the parameters to the minutes, seconds and milliseconds of the watch
            this.minutes = minutes;
            this.seconds = seconds;
            this.milliseconds = milliseconds;

        } else {

            //if parameter is not in range throw an exception
            throw new IllegalArgumentException();
        }
    }

    /******************************************************************
     * Constructor with a string containing the time to be added
     *
     * @param startTime String of time to be added to stop watch
     *****************************************************************/
    public StopWatch(String startTime) {

        //local variables
        int min = 0;
        int sec = 0;
        int milli = 0;

        //check that the last character in the string is a digit to avoid errors, or throw an error
        char temp = startTime.charAt(startTime.length() - 1);
        if(!Character.isDigit(temp)){
            throw new IllegalArgumentException();
        }

        // a try block to make sure nothing goes wrong
        try {

            //split the string into elements in the array
            s = startTime.split(":");

            //if there is 3 elements in the array
            if (s.length == 3) {

                //if any of those elements is null, throw an exception
                if (s[0] == null || s[1] == null || s[2] == null) {
                    throw new IllegalArgumentException();
                }

                //assign the elements of the array to the variables accordingly
                min = Integer.parseInt(s[0]);
                sec = Integer.parseInt(s[1]);
                milli = Integer.parseInt(s[2]);
            }

            //if there is only 2 elements in the array
            else if (s.length == 2) {

                //if any of those elements is null, throw an exception
                if (s[0] == null || s[1] == null) {
                    throw new IllegalArgumentException();
                }

                //assign the elements of the array to the variables accordingly
                sec = Integer.parseInt(s[0]);
                milli = Integer.parseInt(s[1]);
            }
            //if there is only 1 element in the array
            else if (s.length == 1) {

                // if the element is null, throw an exception
                if (s[0] == null) {
                    throw new IllegalArgumentException();
                }

                //assign the element of the array to the variable accordingly
                milli = Integer.parseInt(s[0]);
            }

            //if the elements are not between 1-3, throw an exception
            else {
                throw new IllegalArgumentException();
            }

            //if the variables are not within the appropriate range, throw an exception
            if (min < 0 || sec > 59 || sec < 0 || milli < 0 || milli > 999) {
                throw new IllegalArgumentException();
            }

            //if all the tests passed, assign the instance variable to the local variables
            this.minutes = min;
            this.seconds = sec;
            this.milliseconds = milli;

        } catch (Exception error) {
            //if any line in the try block fails, catch the error and throw an exception
            throw new IllegalArgumentException();
        }
    }

//    /******************************************************************
//     * This method checks if the stop watch object (parameter) is equal
//     * to the (this) stop watch by checking all the variables
//     * within the objects.
//     *
//     * @param obj StopWatch to be checked
//     * @return true -equal, false -not equal
//     *****************************************************************/
//    public boolean equals(StopWatch other){
//
//        //if (this) minutes is equal to (parameter) minutes
//        if(this.minutes == other.minutes){
//
//        //if (this) seconds is equal to (parameter) seconds
//            if(this.seconds == other.seconds){
//
//        //if (this) milliseconds is equal to (parameter) milliseconds
//            if(this.milliseconds == other.milliseconds){
//                    return true;      //return true if all the variables are equal
//                }
//            }
//        }
//        return false;     //return false if one or more of the variables are not equal
//    }

    /******************************************************************
     * This method checks if object (parameter) is equal to
     * (this) stop watch by checking all the variables
     * within the objects.
     *
     * @param obj object to be checked
     * @return if the object is equal or not
     *****************************************************************/
    public boolean equals(Object obj) {

        //if the object (parameter) is not null
        if (obj != null) {

            //if the object (parameter) is a StopWatch object
            if (obj instanceof StopWatch) {

                //Store the object in a temporary StopWatch object, after casting StopWatch on the object
                StopWatch temp = (StopWatch) obj;

                //if the (parameter) minutes is equal to (this) minutes
                if (temp.minutes == this.minutes) {

                    //if the (parameter) seconds is equal to (this) seconds
                    if (temp.seconds == this.seconds) {

                        //if the (parameter) milliseconds is equal to (this) milliseconds
                        if (temp.milliseconds == this.milliseconds) {
                            return true;        //if all the variables are equal, return true
                        }
                    }
                }
            } else {

                //if the object passed is not a StopWatch object, throw an exception
                throw new IllegalArgumentException();
            }
        } else {

            //if the object passed is null, throw an exception
            throw new IllegalArgumentException();
        }
        return false;   //return false if one or more of the variables are not equal
    }

    /******************************************************************
     * This method checks if both StopWatches that are passed
     * (parameters) are equal or not by checking all the variables
     * within the objects.
     *
     * @param s1 first StopWatch object
     * @param s2 second StopWatch object
     * @return if both StopWatch (parameters) are equal or not
     *****************************************************************/
    public static boolean equals(StopWatch s1, StopWatch s2) {

        //if both parameters) StopWatches are not null
        if (s1 != null && s2 != null) {

            //if both (parameter) StopWatch's minutes are equal
            if (s1.minutes == s2.minutes) {

                //if both (parameter) StopWatch's seconds are equal
                if (s1.seconds == s2.seconds) {

                    //if both (parameter) StopWatch's milliseconds are equal
                    if (s1.milliseconds == s2.milliseconds) {
                        return true;        //if all the variables are equal, return true
                    }
                }
            }
        } else {

            // if one or both (parameter) StopWatches are null, throw an exception
            throw new IllegalArgumentException();
        }
        return false;   //return false if one or more of the variables are not equal
    }

    /******************************************************************
     * This method compares two StopWatches and return an integer
     * depending on which on is bigger, or if they are equal.
     *
     * @param other StopWatch to be compared to the current StopWatch
     * @return 1 if (this) StopWatch is bigger the (other) StopWatch
     *        -1 if (other) StopWatch is bigger the (this) StopWatch
     *         0 if both StopWatches are equal
     *****************************************************************/
    public int compareTo(StopWatch other) {

        //if (parameter) StopWatch is null, throw an exception
        if (other == null) {
            throw new IllegalArgumentException();
        }

        //if (this) minutes is bigger than (other) minutes
        if (this.minutes > other.minutes) {
            return 1;   //return 1
        }

        //if (this) minutes is equal to (other) minutes and (this) seconds is bigger than (other) seconds
        else if ((this.minutes == other.minutes) && (this.seconds > other.seconds)) {
            return 1;   //return 1
        }

        //if (this) minutes is equal to (other) minutes and (this) seconds is equal to (other) seconds and
        // (this) milliseconds is bigger than (other) milliseconds
        else if (this.minutes == other.minutes && this.seconds == other.seconds &&
                this.milliseconds > other.milliseconds) {
            return 1;   //return 1
        }

        //if (other) minutes is bigger than (this) minutes
        else if (other.minutes > this.minutes) {
            return -1;  //return -1
        }


        //if (other) minutes is equal to (this) minutes and (other) seconds is bigger than (this) seconds
        else if ((other.minutes == this.minutes) && (other.seconds > this.seconds)) {
            return -1;  //return -1
        }

        //if (other) minutes is equal to (this) minutes and (other) seconds is equal to (this) seconds and
        // (other) milliseconds is bigger than (this) milliseconds
        else if (other.minutes == this.minutes && other.seconds == this.seconds &&
                other.milliseconds > this.milliseconds) {
            return -1;  //return -1
        }
        return 0;       //if they are equal return 0

    }

    /******************************************************************
     * This method adds the parameter milli to the current
     * StopWatch
     *
     * @param milli milliseconds to be added to the watch
     *****************************************************************/
    public void add(int milli) {

        //if the StopWatch is not suspended
        if (!suspended) {

            //if the parameter is zero or greater
            if (milli >= 0) {

                //for loop to inc the milliseconds to the watch (milli) times
                for (int i = 0; i < milli; i++) {
                    this.inc();
                }
            } else {

                //if the parameter is less than zero
                throw new IllegalArgumentException();
            }
        }
    }

    /******************************************************************
     * This method adds the parameter StopWatch object to the current
     * StopWatch
     *
     * @param other StopWatch object to be added to the watch
     *****************************************************************/
    public void add(StopWatch other) {

        //if the StopWatch is not suspended
        if (!suspended) {

            //if the (parameter) StopWatch's variables are within the appropriate range
            if (other.minutes >= 0 && other.seconds >= 0 && other.seconds < 60 && other.milliseconds >= 0 &&
                    other.milliseconds < 1000) {

                //convert the (other) StopWatch to milliseconds
                int addTo = CONVERT_MIN * (other.minutes) + CONVERT_SEC * (other.seconds) + other.milliseconds;

                //call the add(milli) method to add the converted milliseconds to the current watch
                this.add(addTo);
            } else {

                //if the (parameter) StopWatch's variables are not within the appropriate range, throw an exception
                throw new IllegalArgumentException();
            }
        }
    }

    /******************************************************************
     * This method increment the StopWatch by incrementing the
     * milliseconds of the current StopWatch.
     *****************************************************************/
    public void inc() {

        //if the StopWatch is not suspended
        if (!suspended) {

            //increment milliseconds
            this.milliseconds++;

            //if milliseconds reaches the limit == 1000
            if (this.milliseconds == MILLI_TO_SEC) {

                //increment seconds, and set milliseconds back to zero
                this.seconds++;
                this.milliseconds = 0;

                //if seconds reaches the limit == 60
                if (this.seconds == SEC_IN_MIN) {

                    //increment minutes, and set seconds back to zero
                    this.minutes++;
                    this.seconds = 0;
                }
            }
        }
    }

    /******************************************************************
     * This method subtracts the parameter milli from the current
     * StopWatch
     *
     * @param milli milliseconds to be subtracted from the watch
     *****************************************************************/
    public void sub(int milli) {

        //if the StopWatch is not suspended
        if (!suspended) {

            //if the (parameter) is less than the value of the current watch (converted to milliseconds to compare)
            if (milli <= ((this.minutes * CONVERT_MIN) + (CONVERT_SEC * this.seconds) + this.milliseconds)) {

                //if the (parameter) is greater than zero
                if (milli > 0) {

                    //for loop to decrement the current watch (milli) times
                    for (int i = 0; i < milli; i++) {
                        this.dec();
                    }
                } else {

                    //if the (parameter) is zero or less, throw an exception
                    throw new IllegalArgumentException();
                }
            } else {

                //if the (parameter) is greater than the value of the current watch, throw an exception
                throw new IllegalArgumentException();
            }
        }
    }

    /******************************************************************
     * This method subtracts the parameter StopWatch object from the
     * current StopWatch.
     *
     * @param other StopWatch object to be subtracted from the watch
     *****************************************************************/
    public void sub(StopWatch other) {

        //if the StopWatch is not suspended
        if (!suspended) {

            //if the (parameter) StopWatch's variables are within the appropriate range
            if (other.minutes >= 0 && other.seconds >= 0 && other.seconds < 60 && other.milliseconds >= 0 &&
                    other.milliseconds < 1000) {

                //convert the (other) StopWatch to milliseconds
                int subFrom = CONVERT_MIN * (other.minutes) + CONVERT_SEC * (other.seconds) + other.milliseconds;

                //call the sub(milli) method to subtract the converted milliseconds from the current watch
                this.sub(subFrom);
            } else {

                //if the (parameter) StopWatch's variables are not within the appropriate range, throw an exception
                throw new IllegalArgumentException();
            }
        }
    }

    /******************************************************************
     * This method decrement the StopWatch by decrementing the
     * milliseconds of the current StopWatch.
     *****************************************************************/
    public void dec() {

        //if the StopWatch is not suspended
        if (!suspended) {

            //if the current watch still has time
            if (this.milliseconds > 0 || this.seconds > 0 || this.minutes > 0) {

                //decrement milliseconds
                this.milliseconds--;

                //if milliseconds is less than zero
                if (this.milliseconds < 0) {

                    //if seconds or minutes are greater than zero
                    if (this.seconds > 0 || this.minutes > 0) {

                        //decrement seconds, and set milliseconds back to 1 less than the limit = 999
                        this.seconds--;
                        this.milliseconds = MILLI_TO_SEC - 1;
                    }

                    //if seconds is less than zero
                    if (this.seconds < 0) {

                        //if minutes is greater than zero
                        if (this.minutes > 0) {

                            //decrement minutes, and set seconds back to 1 less than the limit = 59
                            this.minutes--;
                            this.seconds = SEC_IN_MIN - 1;
                        }
                    }
                }

                //if minutes is negative, throw an exception
                if (this.minutes < 0) throw new IllegalArgumentException();

            } else {

                //if the current watch doesn't have any time left, throw an exception
                throw new IllegalArgumentException();
            }
        }
    }

    /******************************************************************
     * This method will save the current StopWatch to an external file
     *
     * @param fileName the file name to save the watch to
     *****************************************************************/
    public void save(String fileName) {

        // External file - output stream
        PrintWriter out = null;

        try {
            //Try to create file using the parameter as the file name
            out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        } catch (Exception e) {

            //if can't create file, throw an exception
            e.printStackTrace();
        }

        //file is created if code gets to this point
        //print this instance variables into the file on separate lines
        out.println(this.minutes);
        out.println(this.seconds);
        out.println(this.milliseconds);

        //close the file
        out.close();
    }

    /******************************************************************
     * This method will load a StopWatch from an external file
     *
     * @param fileName the file name to load the watch from
     *****************************************************************/
    public void load(String fileName) {

        //if StopWatch is not suspended
        if (!suspended) {
            try {
                //External file scanner, from the parameter file name
                Scanner fileReader = new Scanner(new File(fileName));

                //file is open and valid if code gets to this point
                //Read from file and store it into instance variables
                this.minutes = fileReader.nextInt();
                this.seconds = fileReader.nextInt();
                this.milliseconds = fileReader.nextInt();

                //close file
                fileReader.close();
            } catch (Exception error) {

                //if can't open file, print error message to the console
                System.out.println("Something went wrong!");
            }
        }

    }

    /******************************************************************
     * this method will set the suspend flag for the StopWatch
     *
     * @param flag true -suspended, false -not suspended
     *****************************************************************/
    public static void setSuspended(boolean flag) {
        suspended = flag;   //assign the suspended variable to the parameter
    }

    /******************************************************************
     * @return suspended whether the StopWatch is suspended or not
     *****************************************************************/
    public boolean isSuspended() {
        return suspended;
    }

    /******************************************************************
     * @return minutes the value of minutes of the current StopWatch
     *****************************************************************/
    public int getMinutes() {
        return minutes;
    }

    /******************************************************************
     * This method will set the minutes for the current StopWatch
     *
     * @param minutes the number of minutes to be set
     *****************************************************************/
    public void setMinutes(int minutes) {

        //if StopWatch not suspended
        if (!suspended) {

            //if the parameter is zero or greater, set the instance variable "minutes" to the parameter
            if (minutes >= 0) {
                this.minutes = minutes;
            } else {

                //if the parameter is less then zero, throw an exception
                throw new IllegalArgumentException();
            }
        }

    }

    /******************************************************************
     * @return seconds the value of seconds of the current StopWatch
     *****************************************************************/
    public int getSeconds() {
        return seconds;
    }

    /******************************************************************
     * This method will set the seconds for the current StopWatch
     *
     * @param seconds the number of seconds to be set
     *****************************************************************/
    public void setSeconds(int seconds) {

        //if StopWatch is not suspended
        if (!suspended) {

            //if the parameter is within the appropriate range, set the instance variable "seconds" to the parameter
            if (seconds >= 0 && seconds < 60) {
                this.seconds = seconds;
            } else {

                //if the parameter is not within the appropriate range, throw an exception
                throw new IllegalArgumentException();
            }
        }
    }

    /******************************************************************
     * @return milliseconds the value of milliseconds of the current
     * StopWatch
     *****************************************************************/
    public int getMilliseconds() {
        return milliseconds;
    }

    /******************************************************************
     * This method will set the milliseconds for the current StopWatch
     *
     * @param milliseconds the number of milliseconds to be set
     *****************************************************************/
    public void setMilliseconds(int milliseconds) {

        //if StopWatch is not suspended
        if (!suspended) {

            //if the parameter is within the appropriate range, set the instance variable "milliseconds" to the parameter
            if (milliseconds >= 0 && milliseconds < 1000) {
                this.milliseconds = milliseconds;
            } else {

                //if the parameter is not within the appropriate range, throw an exception
                throw new IllegalArgumentException();
            }
        }
    }

    /******************************************************************
     * @return String a string value of the current StopWatch
     *****************************************************************/
    public String toString() {

        //if seconds is greater than 9 and milliseconds is between 100-9, return the following string
        if ((this.seconds > 9) && (this.milliseconds < 100) && (this.milliseconds > 9)) {
            return (this.minutes + ":" + this.seconds + ":0" + this.milliseconds);
        }

        //if seconds is greater than 9 and milliseconds is less than 10, return the following string
        else if ((this.seconds > 9) && (this.milliseconds < 10)) {
            return (this.minutes + ":" + this.seconds + ":00" + this.milliseconds);
        }

        //if seconds is less than 10 and milliseconds is less than 10, return the following string
        else if ((this.seconds < 10) && (this.milliseconds < 10)) {
            return (this.minutes + ":0" + this.seconds + ":00" + this.milliseconds);
        }

        //if seconds is less than 10 and milliseconds is between 100-9, return the following string
        else if ((this.seconds < 10) && (this.milliseconds < 100) && (this.milliseconds > 9)) {
            return (this.minutes + ":0" + this.seconds + ":0" + this.milliseconds);
        }

        //if seconds is less than 10 and milliseconds is greater than 100, return the following string
        else if ((this.seconds < 10) && (this.milliseconds > 100)) {
            return (this.minutes + ":0" + this.seconds + ":" + this.milliseconds);
        }

        //otherwise, return the following string
        return (this.minutes + ":" + this.seconds + ":" + this.milliseconds);
    }
}
