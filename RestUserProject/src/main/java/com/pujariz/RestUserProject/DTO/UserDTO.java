package com.pujariz.RestUserProject.DTO;

import com.pujariz.RestUserProject.Entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {

    private long id;
    private String name;
    private String userName;
    private String email;
    private String phone;
    private String website;
    private AddressDTO address; // Use AddressDTO
    private CompanyDTO company; // Use CompanyDTO
    private List<PostResponseDTO> posts; // List of posts


    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.website = user.getWebsite();
        this.address = user.getAddress() != null ? new AddressDTO(user.getAddress()) : null; // Convert Address to DTO
        this.company = user.getCompany() != null ? new CompanyDTO(user.getCompany()) : null; // Convert Company to DTO
        this.posts = user.getPosts().stream()
                .map(PostResponseDTO::new) // Convert each Post to PostResponseDTO
                .collect(Collectors.toList());
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public List<PostResponseDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostResponseDTO> posts) {
        this.posts = posts;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
