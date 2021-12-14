package com.example.webservice2;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Groups {
    String id;
    String groupName;
    List<String> members;

    public Groups(String groupName, List<String> members) {
        this.id = UUID.randomUUID().toString();
        this.groupName = groupName;
        this.members = members;
    }
}
