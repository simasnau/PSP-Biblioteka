package lt.vu.laboratorinisdarbas3.service;

import lombok.SneakyThrows;
import lt.vu.laboratorinisdarbas3.model.User;
import lt.vu.laboratorinisdarbas3.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void testFindAll() {
        User user = new User(1L, "Jonas", "Jonaitis", "+37066666666", "jonas@gmail.com", "Gatves g. 1", "Slaptazodis1!");
        List<User> users = new ArrayList<>();
        users.add(user);

        when(userRepository.findAll()).thenReturn(users);

        List<User> found = userService.findAll();
        verify(userRepository).findAll();

        assertEquals(1, found.size());
    }

    @SneakyThrows
    @Test
    void testFindById() {
        User user = new User(1L, "Jonas", "Jonaitis", "+37066666666", "jonas@gmail.com", "Gatves g. 1", "Slaptazodis1!");
        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));

        User found = userService.findById(1L);
        verify(userRepository).findById(Mockito.anyLong());
        assertNotNull(found);
        assertEquals(user, found);
    }

    @SneakyThrows
    @Test
    void testUpdateUser() {
        User user = new User(1L, "Jonas", "Jonaitis", "+37066666666", "jonas@gmail.com", "Gatves g. 1", "Slaptazodis1!");
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        when(userRepository.existsById(1L)).thenReturn(true);

        User updatedUser = userService.updateUser(user);
        verify(userRepository).save(Mockito.any(User.class));

        assertEquals(user, updatedUser);
    }

    @SneakyThrows
    @Test
    void testCreateUser() {
        User user = new User(1L, "Jonas", "Jonaitis", "+37066666666", "jonas@gmail.com", "Gatves g. 1", "Slaptazodis1!");
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        User created = userService.createUser(user);
        verify(userRepository).save(Mockito.any(User.class));
        assertNotNull(created);
        assertEquals(user, created);
    }

    @Test
    void testDeleteUserById() {
        userService.deleteUserById(1L);
        verify(userRepository).deleteById(Mockito.anyLong());
    }
}
