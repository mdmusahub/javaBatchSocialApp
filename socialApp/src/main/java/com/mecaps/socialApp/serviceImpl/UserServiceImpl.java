package com.mecaps.socialApp.serviceImpl;

import com.mecaps.socialApp.entity.User;
import com.mecaps.socialApp.repository.UserRepository;
import com.mecaps.socialApp.request.UserRequest;
import com.mecaps.socialApp.response.UserResponse;
import com.mecaps.socialApp.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import com.mecaps.socialApp.exception.UserNotFoundException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    private final EntityManager entityManager;


    public UserServiceImpl(UserRepository userRepository, EntityManager entityManager, EntityManager entityManager1) {
        this.userRepository = userRepository;

        this.entityManager = entityManager1;
    }


    @Override
    public void createUser(User userRequest) {
        User userObj = new User();
        userObj.setUserName(userRequest.getUserName());
        userObj.setEmail(userRequest.getEmail());
        userObj.setPassword(userRequest.getPassword());
        userRepository.save(userRequest);
        

//        return ResponseEntity.ok("User Created");
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(Map.of(
//                        "message" , "User Created successfully",
//                        "body" , save,
//                        "success", true
//                ));


    }



    public List<User> getAllUser() {
//        List<User> userList = userRepository.findAll();
//
////        List<UserResponse> userResponseArrayList = new ArrayList<>();
////        for (User user : userList){
////            UserResponse userResponse = new UserResponse(user);
////            userResponseArrayList.add(userResponse);
////        }
////        return userResponseArrayList;
//
//        return userList.stream().map(UserResponse::new).toList();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> root = criteriaQuery.from(User.class);

        //select * from user
        criteriaQuery.select(root);
        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();


    }


    public User findByUserEmail(String email){

        User user = userRepository.findByEmail(email)
                .orElseThrow( () -> new
                        UserNotFoundException("User not found by " + email+ " email"));

        return user;
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("user not found")
        );

        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        User save = userRepository.save(user);
        return new UserResponse(save);

    }



    public String deleteUserById(Long id){

        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("user not found")
        );
        userRepository.delete(user);
        return "User Delete Successfully!";

    }



    public List<User> getUserByNameUsingCriteriaAPI(String userName){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        Predicate condition = criteriaBuilder.equal(root.get("userName"), userName);
        criteriaQuery.select(root).where(condition);
        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();

        // final query
        //select * from user where userName = ?;


//        How Criteria API Works Internally
//            EntityManager provides CriteriaBuilder
//            You create a CriteriaQuery object for a specific entity
//            Use Root to specify FROM table
//            Add Predicates for conditions
//            Execute using entityManager.createQuery(cq)
//            Hibernate translates it into SQL automatically.


    }

}
