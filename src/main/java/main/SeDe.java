package main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class SeDe {

    public static <T> byte[] toByteArray(T t) throws  java.io.IOException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(t);
        oos.flush();

        return bos.toByteArray();
    }

    public static <T> T fromByteArray(byte[] bytes) throws java.io.IOException, java.lang.ClassNotFoundException{
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);

        return (T) ois.readObject();
    }
}
