package model;

import exception.GraphenException;

import java.awt.*;
import java.io.File;

public class DirectoryCreation{

    public static void create(String directory) throws GraphenException{
        if(directory != null){
            if(!directory.isBlank()){
                if(directory.length() > 0 && directory.length() < 30){
                    try{
                        File file = new File("src/" + directory);
                        if(! file.exists()){
                            file.mkdir();
                        }else{
                            throw new GraphenException("delete | Path exists!");
                        }
                    }catch(SecurityException e){
                        throw new GraphenException("delete | SecurityException thrown!");
                    }
                }else{
                    throw new GraphenException("create | Character-length must be bigger than 0 and smaller than 30! Your input: "+directory.length());
                }
            }else{
                throw new GraphenException("create | Directory-path is blank!");
            }
        }else{
            throw new GraphenException("create | Null-Ref by directory creation!");
        }
    }

    public static void delet(String directory)throws GraphenException{
        if(directory != null){
            if(!directory.isBlank()){
                if(directory.length() > 0 && directory.length() < 30){
                    try{
                        File file = new File("src/" + directory);
                        if(file.exists()){
                            file.delete();
//                            file.de
                        }else{
                            throw new GraphenException("delete | Path dont exists!");
                        }
                    }catch(SecurityException e){
                        throw new GraphenException("delete | SecurityException thrown!");
                    }
                }else{
                    throw new GraphenException("delete | Character-length must be bigger than 0 and smaller than 30! Your input: "+directory.length());
                }
            }else{
                throw new GraphenException("delete | Directory-path is blank!");
            }
        }else{
            throw new GraphenException("delete | Null-Ref by directory delete!");
        }
    }

}
