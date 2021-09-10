package main;

import database.DBConnection;

public class StoneMain {
    public static  void main(String[] args){

      DBConnection a = new DBConnection();
      a.readInfo();
    }

}
