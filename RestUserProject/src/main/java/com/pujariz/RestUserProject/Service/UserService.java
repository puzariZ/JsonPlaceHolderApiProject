package com.pujariz.RestUserProject.Service;

import com.pujariz.RestUserProject.DTO.UserDTO;
import com.pujariz.RestUserProject.Entity.Address;
import com.pujariz.RestUserProject.Entity.Company;
import com.pujariz.RestUserProject.Entity.Geo;
import com.pujariz.RestUserProject.Entity.User;
import com.pujariz.RestUserProject.Repository.UserRepository;
import com.pujariz.RestUserProject.ServiceInterface.UserServiceble;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceble {

    @Autowired
    UserRepository userRepository;

//    @Override
//    public List<User> getAllUser() {
//        return userRepository.findAll();
//    }

    // Fetch all users with their posts
    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserDTO::new) // Convert each User to UserDTO
                .collect(Collectors.toList());
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDTO getUserById(long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return new UserDTO(userOptional.get());
        } else {
            throw new RuntimeException("User  not found with ID: " + userId);
        }
    }

    @Override
    public ResponseEntity<User> updateUserById(long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setName(userDetails.getUserName());
            user.setUserName(userDetails.getUserName());
            user.setEmail(userDetails.getEmail());
            user.setPhone(userDetails.getPhone());
            user.setWebsite(userDetails.getWebsite());
            user.setAddress(userDetails.getAddress());
            user.setCompany(userDetails.getCompany());
            User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser );
        }).orElse(ResponseEntity.notFound().build());
    }


    @Override
    public ResponseEntity<Object> deleteUser(long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.noContent().build();}).
                orElse(ResponseEntity.notFound().build());
    }

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<User> patchUserById(long id, User userUpdates) {
        Optional<User> optionalUser  = userRepository.findById(id);

        if (!optionalUser .isPresent()) {
            return ResponseEntity.notFound().build(); // User not found
        }

        User existingUser  = optionalUser .get();

        // Update only non-null fields for User
        if (userUpdates.getName() != null) {
            existingUser .setName(userUpdates.getName());
        }
        if (userUpdates.getUserName() != null) {
            existingUser .setUserName(userUpdates.getUserName());
        }
        if (userUpdates.getEmail() != null) {
            existingUser .setEmail(userUpdates.getEmail());
        }
        if (userUpdates.getPhone() != null) {
            existingUser .setPhone(userUpdates.getPhone());
        }
        if (userUpdates.getWebsite() != null) {
            existingUser .setWebsite(userUpdates.getWebsite());
        }

        // Update Address if provided
        if (userUpdates.getAddress() != null) {
            Address addressUpdates = userUpdates.getAddress();
            Address existingAddress = existingUser .getAddress();

            if (addressUpdates.getStreet() != null) {
                existingAddress.setStreet(addressUpdates.getStreet());
            }
            if (addressUpdates.getSuite() != null) {
                existingAddress.setSuite(addressUpdates.getSuite());
            }
            if (addressUpdates.getCity() != null) {
                existingAddress.setCity(addressUpdates.getCity());
            }
            if (addressUpdates.getCountry() != null) {
                existingAddress.setCountry(addressUpdates.getCountry());
            }
            if (addressUpdates.getZipcode() != null) {
                existingAddress.setZipcode(addressUpdates.getZipcode());
            }

            // Update Geo if provided
            if (addressUpdates.getGeo() != null) {
                Geo geoUpdates = addressUpdates.getGeo();
                Geo existingGeo = existingAddress.getGeo();

                if (geoUpdates.getLat() != null) {
                    existingGeo.setLat(geoUpdates.getLat());
                }
                if (geoUpdates.getLng() != null) {
                    existingGeo.setLng(geoUpdates.getLng());
                }
            }
        }

        // Update Company if provided
        if (userUpdates.getCompany() != null) {
            Company companyUpdates = userUpdates.getCompany();
            Company existingCompany = existingUser .getCompany();

            if (companyUpdates.getName() != null) {
                existingCompany.setName(companyUpdates.getName());
            }
            if (companyUpdates.getCatchPhrase() != null) {
                existingCompany.setCatchPhrase(companyUpdates.getCatchPhrase());
            }
            if (companyUpdates.getBs() != null) {
                existingCompany.setBs(companyUpdates.getBs());
            }
        }

        // Save the updated user
        User updatedUser  = userRepository.save(existingUser );
        return ResponseEntity.ok(updatedUser );
    }
    }
