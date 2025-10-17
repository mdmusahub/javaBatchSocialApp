//package com.mecaps.socialApp.serviceImpl; ////  Filter by two fields (productName & price)
////@GetMapping("/filter")
////public ResponseEntity<List<Product>> filterProducts(
////        @RequestParam(required = false) String name,
////        @RequestParam(required = false) Double price) {
////
////    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
////    CriteriaQuery<Product> cq = cb.createQuery(Product.class);
////    Root<Product> root = cq.from(Product.class);
////
////    List<Predicate> predicates = new ArrayList<>();
////
////    if (name != null && !name.isEmpty()) {
////        predicates.add(cb.equal(root.get("productName"), name));
////    }
////    if (price != null) {
////        predicates.add(cb.equal(root.get("price"), price));
////    }
////
////    cq.select(root).where(cb.and(predicates.toArray(new Predicate[0])));
////
////    List<Product> products = entityManager.createQuery(cq).getResultList();
////    return ResponseEntity.ok(products);
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////package com.mecaps.socialApp.serviceImpl;
////
////import com.mecaps.socialApp.entity.User;
////import jakarta.persistence.EntityManager;
////import jakarta.persistence.TypedQuery;
////import jakarta.persistence.criteria.CriteriaBuilder;
////import jakarta.persistence.criteria.CriteriaQuery;
////import jakarta.persistence.criteria.Predicate;
////import jakarta.persistence.criteria.Root;
////
////import java.util.ArrayList;
////import java.util.List;
////
////public class UserCriteria {
////
////
////    private final EntityManager entityManager;
////
////    public UserCriteria(EntityManager entityManager) {
////        this.entityManager = entityManager;
////    }
////
////    public List<User> getUsersAboveAge(int minAge) {
////
////        //  Get the CriteriaBuilder (used to construct query components)
////        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
////
////        //  Create a CriteriaQuery for User entity
////        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
////
////        //  Define the root (equivalent to FROM User)
////        Root<User> root = criteriaQuery.from(User.class);
////
////        //  Add a condition: WHERE age > minAge
////        criteriaQuery.select(root).where(criteriaBuilder.gt(root.get("age"), minAge));
////
////        //  Order results by name ascending
////        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("name")));
////
////        //  Create a TypedQuery and execute it
////        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
////        return query.getResultList();
////    }
////
////
////
////
////
////
////    public List<Employee> searchEmployees(String department, Double minSalary, Double maxSalary) {
////
////        //  Get CriteriaBuilder — used to create CriteriaQuery, Predicates, Order, etc.
////        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
////
////        //  Create CriteriaQuery — defines the structure of the query (what we are selecting)
////        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
////
////        //  Define the FROM clause — sets the main entity (table) we’re querying from
////        Root<Employee> root = criteriaQuery.from(Employee.class);
////        // "root" represents the Employee table, used to access its fields like root.get("salary")
////
////        //  Create dynamic predicates — conditions that will form the WHERE clause
////        List<Predicate> predicates = new ArrayList<>();
////
////        // If department filter is provided, add WHERE department = :department
////        if (department != null) {
////            predicates.add(criteriaBuilder.equal(root.get("department"), department));
////        }
////
////        // If minSalary is provided, add WHERE salary >= :minSalary
////        if (minSalary != null) {
////            predicates.add(criteriaBuilder.ge(root.get("salary"), minSalary));
////        }
////
////        // If maxSalary is provided, add WHERE salary <= :maxSalary
////        if (maxSalary != null) {
////            predicates.add(criteriaBuilder.le(root.get("salary"), maxSalary));
////        }
////
////        //  Combine all conditions into one WHERE clause
////        // Convert list of predicates to an array and apply them using CriteriaQuery.where()
////        criteriaQuery.select(root).where(predicates.toArray(new Predicate[0]));
////
////        //  Add ORDER BY clause — sort results by salary in ascending order
////        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("salary")));
////
////        //  Create TypedQuery to execute the built query
////        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
////
////        // Execute the query and return the result list
////        return query.getResultList();
////    }
////
////
////
////
////}
////
////
////
//
//
//
//
////public List<User> getAllUsers() {
//
////    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
////    CriteriaQuery<User> cq = cb.createQuery(User.class);
////    Root<User> root = cq.from(User.class);
////    cq.select(root); // SELECT * FROM users
////    return entityManager.createQuery(cq).getResultList();
////}
////
//
//
////// 🧠 2️⃣ Find users by username (exact match)
////public List<User> findByUserName(String userName) {
////    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
////    CriteriaQuery<User> cq = cb.createQuery(User.class);
////    Root<User> root = cq.from(User.class);
////
////    Predicate condition = cb.equal(root.get("userName"), userName);
////    cq.select(root).where(condition);
////
////    TypedQuery<User> query = entityManager.createQuery(cq);
////    return query.getResultList();
////}
//
//
//import com.mecaps.socialApp.entity.User;
//import com.mecaps.socialApp.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
////// 🧠 4️⃣ Dynamic search (optional filters)
////public List<User> searchUsers(String userName, String email) {
////    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
////    CriteriaQuery<User> cq = cb.createQuery(User.class);
////    Root<User> root = cq.from(User.class);
////
////    List<Predicate> predicates = new ArrayList<>();
////
////    if (userName != null && !userName.isEmpty()) {
////        predicates.add(cb.like(root.get("userName"), "%" + userName + "%"));
////    }
////    if (email != null && !email.isEmpty()) {
////        predicates.add(cb.like(root.get("email"), "%" + email + "%"));
////    }
////
////    cq.select(root).where(cb.and(predicates.toArray(new Predicate[0])));
////
////    TypedQuery<User> query = entityManager.createQuery(cq);
////    return query.getResultList();
////}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.crypto.SecretKey;

////@Configuration // Marks this class as a Spring configuration class
////public class SecurityConfig {
////
////    private final UserDetailsService userDetailsService; // Injects a custom UserDetailsService for authentication
////
////    // Constructor-based dependency injection
////    public SecurityConfig(UserDetailsService userDetailsService) {
////        this.userDetailsService = userDetailsService;
////    }
////
////    // Password encoder bean definition
////    @Bean // Registers a BCryptPasswordEncoder bean in Spring context
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder(); // Provides password hashing using BCrypt algorithm
////    }
////
////    // Security filter chain configuration
////    @Bean // Defines the main security configuration bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .csrf(AbstractHttpConfigurer::disable) // Disables CSRF protection (useful for REST APIs)
////                .authorizeHttpRequests(auth -> auth // Begins defining authorization rules
////                        .requestMatchers("/user/**").permitAll() // Allows public access to all /user/** endpoints
////                        .anyRequest().authenticated() // Requires authentication for all other endpoints
////                )
////                .userDetailsService(userDetailsService) // Uses the injected custom UserDetailsService for user lookup
////                .httpBasic(); // Enables HTTP Basic Authentication (username/password in request header)
////
////        return http.build(); // Builds and returns the configured SecurityFilterChain
////    }
////}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//@Service // Marks this class as a Spring service component
//class customUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository; // Repository for accessing user data from the database
//
//    // Constructor-based dependency injection for UserRepository
//    public customUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override // Implements the loadUserByUsername method from UserDetailsService
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Finds the user by username or throws exception if not found
//        User user = userRepository.findByUserName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//        // Converts the User entity to a Spring Security UserDetails object
//        return new org.springframework.security.core.userdetails.User(
//                user.getUserName(), // Username
//                user.getPassword(), // Encrypted password
//                Collections.emptyList() // No roles or authorities assigned
//        );
//    }
//}











//
//String role = user.getRole().startsWith("ROLE_") ? user.getRole() : "ROLE_" + user.getRole();
//
//GrantedAuthority authority = new SimpleGrantedAuthority(role);
//
//        return new org.springframework.security.core.userdetails.User(
//        user.getUserName(),
//                user.getPassword(),
//                Collections.singleton(authority));









//    public String generateAccessToken(String email, String role) {
//        return Jwts.builder()
//                .subject(email)
//                .claim("role", role) //  store list of roles
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION))
//                .signWith(getSigningKey())
//                .compact();
//    }




//private SecretKey getSigningKey() {
//    return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
//}