package com.example.webservice2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

public class GroupController {

    GroupRepository groupRepository;
    GroupService groupService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Groups> getGroupById(@PathVariable(value= "id")String id) throws Exception{
        Groups person = groupRepository.findById(id).orElseThrow();
        return ResponseEntity.ok().body(person);
    }

    @PostMapping("/create")
    public Groups createGroup(@Valid @RequestBody Groups groups){
        groups.setId(UUID.randomUUID().toString());
        groups.setGroupName("name");
        return groupRepository.save(groups);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Groups> updateGroup(@PathVariable(value = "id")String id, @Valid @RequestBody Groups groups, @RequestHeader(value = "header", required = false)String header) throws Exception{
        return groupService.updateGroup(id, groups);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGroup(@PathVariable(value = "id") String id) throws Exception{
        Groups group = groupRepository.findById(id).orElseThrow();
        groupRepository.delete(group);
    }
}

