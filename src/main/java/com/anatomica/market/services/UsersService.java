package com.anatomica.market.services;

import com.anatomica.market.entities.Role;
import com.anatomica.market.entities.User;
import com.anatomica.market.exceptions.ProductNotFoundException;
import com.anatomica.market.repositories.RolesRepository;
import com.anatomica.market.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService implements UserDetailsService {
    public UsersRepository usersRepository;
    public RolesRepository rolesRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository, RolesRepository rolesRepository) {
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
    }

    public User findById(Long id) {
        return usersRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Can't found user with id = " + id));
    }

    public Optional<User> findByEmail(String email) {
        return usersRepository.findOneByEmail(email);
    }

    public List<User> findAllUsers() {
        return (List<User>) usersRepository.findAll();
    }

    public List<User> findAllByEmail() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userEmail;
        if (principal instanceof UserDetails) {
             userEmail = ((UserDetails)principal).getUsername();
            Collection<? extends GrantedAuthority> authorities = ((UserDetails)principal).getAuthorities();
        } else {
            userEmail = principal.toString();
        }
        return usersRepository.findAllByEmailContainsAndUserBlockFalse(userEmail);
    }

    public void blockById(Long id) {
        Optional<User> user = usersRepository.findById(id);
        if (user.isPresent()){
            User u = user.get();
            u.setUserBlock(true);
            usersRepository.save(u);
        }
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findOneByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Invalid username or password"));
        // userEmail = user.getEmail();
        // userRoles = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
        if (!user.isUserBlock())
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
        else
            return new org.springframework.security.core.userdetails.User("block", "block",
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}