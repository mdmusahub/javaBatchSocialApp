//package com.mecaps.socialApp.serviceImpl;
//
//import com.mecaps.socialApp.entity.User;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Predicate;
//import jakarta.persistence.criteria.Root;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserCriteria {
//
//
//    private final EntityManager entityManager;
//
//    public UserCriteria(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    public List<User> searchUser(String userName, String email){
//
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//
//        Root<User> userRoot = criteriaQuery.from(User.class);
//
//        List<Predicate> predicates = new ArrayList<>();
//
//        criteriaBuilder.
//
//    }
//}
