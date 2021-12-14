package com.example.webservice2;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    public ResponseEntity<Groups> updateGroup(String id, Groups groups) throws Exception{
        Groups group = groupRepository.findById(id).orElseThrow();
        group.setGroupName(groups.getGroupName());
        group.setMembers(groups.getMembers());
        final Groups updatePerson = groupRepository.save(group);
        return ResponseEntity.ok(updatePerson);
    }
}
