// https://www.youtube.com/watch?v=qVNOw9TWwxo&ab_channel=JavaTechie
//package com.arcadefortune.visit_counter.service;
//
//import com.arcadefortune.visit_counter.model.Task;
//import com.arcadefortune.visit_counter.repository.TaskRepository;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class TaskService {
//    @Autowired
//    private TaskRepository repository;
//
//    // create
//    public Task addTask(Task task) {
//        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
//        return repository.save(task);
//    }
//
//    // read
//    public List<Task> findAllTasks() {
//        return repository.findAll();
//    }
//
//    // read by ID
//    public Task getTaskByTaskId(String taskId) {
//        return repository.findById(taskId).get();
//    }
//
//    // read total amount of entries
//    public long getAmountOfTasks() {
//        return repository.count();
//    }
//
//    // update
//    public Task updateTask(Task task) {
//        // get the document
//        Task existingTask = repository.findById(task.getTaskId()).get();
//        // update the document
//        existingTask.setDescription(task.getDescription());
//        // save the document
//        return repository.save(existingTask);
//    }
//
//    // delete
//    public String deleteTask(String taskId) {
//        repository.deleteById(taskId);
//        return "Deleted task #" + taskId + " successfully.";
//    }
//
//
//    // ChatGPT: I have an endpoint that reads the ip address from the user, how can I display the location/city of the user using its ip address?
//    // get City
//    // this is for some time in the future
////    public String getCityFromIp(String ip) {
////        RestTemplate restTemplate = new RestTemplate();
////        String url = "https://api.db-ip.com/v2/free/" + ip;
////        String response = restTemplate.getForObject(url, String.class);
////        String country = ".";
////        try {
////            ObjectMapper objectMapper = new ObjectMapper();
////
////            JsonNode jsonNode = objectMapper.readTree(response);
////
////            country = jsonNode.get("countryCode").asText();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return country;
////    }
//}
