package com.example.webservice2;

import org.springframework.stereotype.Service;

@Service
public class GroupService {
    GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }
}
