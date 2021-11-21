package edu.eci.cvds.utils;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 17/10/2021
 */
public enum Role {
    ADMIN("ADMIN"),
    STUDENT("STUDENT"),
    TEACHER("TEACHER"),
    GRADUATED("GRADUATED"),
    ADMINISTRATIVE("ADMINISTRATIVE");

    private String name;

    Role(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
