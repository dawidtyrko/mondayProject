package com.example.mondayproject.data;

import java.util.UUID;

public record Student(UUID id, String name){
//    private String name;
//    private UUID id;
//

    @Override
    public UUID id() {
        return id;
    }
}
