//package com.mecaps.socialApp.security;
//
//
//import com.mecaps.socialApp.repository.UserRepository;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import java.io.IOException;
//import java.util.List;
//
//@Component
//public class JwtAuthFilter extends OncePerRequestFilter {
//
//    private final JwtService jwtService;
//    private final UserRepository userRepository;
//
//    public JwtAuthFilter(JwtService jwtService, UserRepository userRepository) {
//        this.jwtService = jwtService;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String header = request.getHeader("Authorization");
//
//        if (header == null || !header.startsWith("Bearer ")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String token = header.substring(7);
//        String username = jwtService.extractUsername(token);
//
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            var user = userRepository.findByUserName(username).orElse(null);
//
//            if (user != null && jwtService.isTokenValid(token, user.getUserName())) {
//                var auth = new UsernamePasswordAuthenticationToken(
//                        user.getUserName(),
//                        null,
//                        List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
//                );
//                SecurityContextHolder.getContext().setAuthentication(auth);
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
