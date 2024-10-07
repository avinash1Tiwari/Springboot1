package com.springCrud.example.SpringCrudOperations.exceptions;

public class ResourceNotFoundException extends RuntimeException{

   public ResourceNotFoundException(String message)
   {
       super(message);
   }
}
