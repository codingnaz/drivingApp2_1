package com.example.saimon22.drivingapp2_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by SAimon22 on 11/13/2017.
 */

public class DriverIO {


        public static void writeUsers(Object data) throws IOException {

            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("users.dat"));
            output.writeObject(data);

        }

        public static Object readUsers() throws IOException, ClassNotFoundException {

            ObjectInputStream input = new ObjectInputStream(new FileInputStream("users.dat"));
            return input.readObject();
        }


}
